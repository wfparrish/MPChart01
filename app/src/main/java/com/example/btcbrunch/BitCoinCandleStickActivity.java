package com.example.btcbrunch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import android.os.Bundle;

public class BitCoinCandleStickActivity extends AppCompatActivity {

    CandleStickChart candleStickChart;
    Button candleStickApiButton;
    private double[] bitCoinData;

    ArrayList<CandleEntry> listValsCandleStick = new ArrayList<CandleEntry>();
    ArrayList<Candlestick> candlesticks = new ArrayList<Candlestick>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_coin_candle_stick);

        Spinner bitCoinSpinner = findViewById(R.id.bitcoin_spinner);
        ArrayAdapter<String> bitCoinSpinnerAdapter = new ArrayAdapter<String>(BitCoinCandleStickActivity.this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.bitcoin_tickers));
        bitCoinSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bitCoinSpinner.setAdapter(bitCoinSpinnerAdapter);


        String URL="https://api.binance.com/api/v3/klines?symbol=BTCUSDT&interval=1d&limit=100";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest objectRequest1 = new JsonArrayRequest(Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("Ticker1 Response", response.toString());
                        tickerDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response1 Error", error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest1);

        //Links the line chart XML to the java code
        candleStickChart = findViewById(R.id.candle_stick_chart);

        //The button that loads the data from the API call into the chart
        candleStickApiButton = findViewById(R.id.candle_stick_api_button);

        //The code that formats the chart
        candleStickChart.setHighlightPerDragEnabled(true);
        candleStickChart.setDrawBorders(true);
        candleStickChart.setBorderColor(getResources().getColor(R.color.design_default_color_primary));

        YAxis yAxis = candleStickChart.getAxisLeft();
        YAxis rightAxis = candleStickChart.getAxisRight();
        yAxis.setDrawGridLines(false);
        rightAxis.setDrawGridLines(false);
        candleStickChart.requestDisallowInterceptTouchEvent(true);

        XAxis xAxis = candleStickChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(false);
        rightAxis.setTextColor(Color.WHITE);
        yAxis.setDrawLabels(false);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setAvoidFirstLastClipping(true);

        Legend legend = candleStickChart.getLegend();
        legend.setEnabled(false);




        candleStickApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //We create another query object inside the onClick that will
                //eventually be given a new URL address to query for it's data

                //Place a switch here that will check the value of the string in cryptoTicker
                String cryptoTicker = bitCoinSpinner.getSelectedItem().toString();

                //The value of the crypto string that will trigger the switch to perform the desired query
                System.out.println(cryptoTicker);
                String selectedURL;

                switch (cryptoTicker) {
                    case "BTC": {
                        selectedURL="https://api.binance.com/api/v3/klines?symbol=BTCUSDT&interval=1d&limit=100";
                    }
                    break;
                    case "ETH": {
                        selectedURL="https://api.binance.com/api/v3/klines?symbol=ETHUSDT&interval=1d&limit=100";
                    }
                    break;
                    case "BCH": {
                        selectedURL="https://api.binance.com/api/v3/klines?symbol=BCHUSDT&interval=1d&limit=100";

                    }
                    break;
                    case "LTC": {
                        selectedURL="https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=100";

                    }
                    break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + cryptoTicker);
                }

                System.out.println(selectedURL);


                JsonArrayRequest objectRequest2 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Log.e("Ticker2 Response", response.toString());
                                tickerDataFunction(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Rest Response2 Error", error.toString());
                            }
                        }
                );

                //If if breaks anywhere, I think it might break here...

                requestQueue.add(objectRequest2);



             //Create a loop here that will iterate as many times as size
                int candleStickSize = candlesticks.size();
                int listValsCandleStickSize = listValsCandleStick.size();
                System.out.println("This is the size of candlesticks: " + candleStickSize);
                System.out.println("This is the size of listValsCandleStick: " + listValsCandleStickSize);

                //clear the chart values and prepare for a new chart in the requestqueue
                if(listValsCandleStickSize > 0) {
                    for(int i = listValsCandleStickSize - 1; i >= 0; i--) {

                        listValsCandleStick.remove(i);
                        listValsCandleStickSize--;
                        //System.out.println(listValsCandleStick.size());
                    }

                }

                  for(int idx = 0; idx <= candleStickSize - 1; idx++) {
                    listValsCandleStick.add(new CandleEntry(idx, candlesticks.get(idx).getHigh(), candlesticks.get(idx).getLow(), candlesticks.get(idx).getOpen(), candlesticks.get(idx).getClose()));
                 }

//                  This call SHOULD destroy any array already in the chart
                  if(candleStickSize > 0) {
                      for(int i = candleStickSize - 1; i >=0; i--) {
                          candlesticks.remove(i);
                          candleStickSize--;
                      }
                  }

                CandleDataSet dataList = new CandleDataSet(listValsCandleStick, "DataList 1");
                dataList.setColor(Color.rgb(80, 80, 80));

                dataList.setShadowColor(getResources().getColor(R.color.design_default_color_secondary));
                dataList.setShadowWidth(0.8f);
                dataList.setDecreasingColor(getResources().getColor(R.color.design_default_color_surface));
                dataList.setDecreasingPaintStyle(Paint.Style.FILL);
                dataList.setIncreasingColor(getResources().getColor(R.color.design_default_color_primary_variant));
                dataList.setIncreasingPaintStyle(Paint.Style.FILL);
                dataList.setNeutralColor(Color.LTGRAY);
                dataList.setDrawValues(false);

                CandleData data = new CandleData(dataList);

                candleStickChart.setData(data);
                candleStickChart.setBackgroundColor(Color.rgb(0, 0, 0));
                candleStickChart.invalidate();

            }//end of onClick()
        });
    }//end of onCreate()

//The code in this function is almost identical to the code in the onClick because I copied it from the onClick... BE CAREFUL TO KNOW WHERE YOU ARE!!!!
    private ArrayList<Candlestick> tickerDataFunction(JSONArray response) {

        ArrayList<CandleEntry> candleVals = new ArrayList<>();
        try {

           for(int idx = 0; idx <= response.length() - 1; idx++) {
               JSONArray candlestickData = response.getJSONArray(idx);
               long data0 = (long) candlestickData.get(0);
               String data1 = (String) candlestickData.get(1);
               String data2 = (String) candlestickData.get(2);
               String data3 = (String) candlestickData.get(3);
               String data4 = (String) candlestickData.get(4);

               long convertedData0 = data0;
               float convertedData1 = Float.parseFloat(data1);
               float convertedData2 = Float.parseFloat(data2);
               float convertedData3 = Float.parseFloat(data3);
               float convertedData4 = Float.parseFloat(data4);


               Candlestick candlestick = new Candlestick(convertedData0, convertedData1, convertedData2, convertedData3, convertedData4);

               candlesticks.add(candlestick);
           }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Create a loop here that will iterate as many times as size
        int candleStickSize = candlesticks.size();
        int listValsCandleStickSize = listValsCandleStick.size();
        System.out.println("This is the size of candlesticks: " + candleStickSize);
        System.out.println("This is the size of listValsCandleStick: " + listValsCandleStickSize);

        //clear the chart values and prepare for a new chart in the requestqueue
        if(listValsCandleStickSize > 0) {
            for(int i = listValsCandleStickSize - 1; i >= 0; i--) {

                listValsCandleStick.remove(i);
                listValsCandleStickSize--;
                //System.out.println(listValsCandleStick.size());
            }

        }

        for(int idx = 0; idx <= candleStickSize - 1; idx++) {
            listValsCandleStick.add(new CandleEntry(idx, candlesticks.get(idx).getHigh(), candlesticks.get(idx).getLow(), candlesticks.get(idx).getOpen(), candlesticks.get(idx).getClose()));
        }

        CandleDataSet dataList = new CandleDataSet(listValsCandleStick, "DataList 1");
        dataList.setColor(Color.rgb(80, 80, 80));

        dataList.setShadowColor(getResources().getColor(R.color.design_default_color_secondary));
        dataList.setShadowWidth(0.8f);
        dataList.setDecreasingColor(getResources().getColor(R.color.design_default_color_surface));
        dataList.setDecreasingPaintStyle(Paint.Style.FILL);
        dataList.setIncreasingColor(getResources().getColor(R.color.design_default_color_primary_variant));
        dataList.setIncreasingPaintStyle(Paint.Style.FILL);
        dataList.setNeutralColor(Color.LTGRAY);
        dataList.setDrawValues(false);

        CandleData data = new CandleData(dataList);

        candleStickChart.setData(data);
        candleStickChart.setBackgroundColor(Color.rgb(0, 0, 0));
        candleStickChart.invalidate();

        return candlesticks;
    }


}