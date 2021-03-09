package com.example.mpchart01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.os.Bundle;

public class BitCoinVsStocksActivity extends AppCompatActivity {


    LineChart mpLineChart;
    Button bitCoinApiButton;
    private double[] bitCoinData;
    private JSONObject[] cornData;
    private JSONObject[] wheatData;
    private JSONObject[] soybData;
    private JSONObject[] sugarData;
    ArrayList<Entry> dataVals;
    ArrayList<Entry> cornVals;
    ArrayList<Entry> wheatVals;
    ArrayList<Entry> soybVals;
    ArrayList<Entry> sugarVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_coin_vs_stocks);

        Spinner stockSpinner = findViewById(R.id.stock_spinner);
        ArrayAdapter<String> stockSpinnerAdapter = new ArrayAdapter<String>(BitCoinVsStocksActivity.this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.stock_tickers));
        stockSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stockSpinner.setAdapter(stockSpinnerAdapter);

        Spinner bitCoinSpinner = findViewById(R.id.bitcoin_spinner);
        ArrayAdapter<String> bitCoinSpinnerAdapter = new ArrayAdapter<String>(BitCoinVsStocksActivity.this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.bitcoin_tickers));
        bitCoinSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bitCoinSpinner.setAdapter(bitCoinSpinnerAdapter);


        String URL1="https://api.coindesk.com/v1/bpi/historical/close.json";


        String URL2="https://api.marketstack.com/v1/eod?access_key=86746e122918145ebf3f1473bf378d26&symbols=CORN";
        String URL3="https://api.marketstack.com/v1/eod?access_key=86746e122918145ebf3f1473bf378d26&symbols=WEAT";
        String URL4="https://api.marketstack.com/v1/eod?access_key=86746e122918145ebf3f1473bf378d26&symbols=SOYB";
        String URL5="https://api.marketstack.com/v1/eod?access_key=86746e122918145ebf3f1473bf378d26&symbols=CANE";



        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest1 = new JsonObjectRequest(Request.Method.GET,
                URL1,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Bitcoin Response", response.toString());
                        dataVals = bitcoinDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest2 = new JsonObjectRequest(Request.Method.GET,
                URL2,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Corn stock Response", response.toString());
                        cornVals =  cornDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest3 = new JsonObjectRequest(Request.Method.GET,
                URL3,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Wheat stock Response", response.toString());
                        wheatVals =  wheatDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
        );


        JsonObjectRequest objectRequest4 = new JsonObjectRequest(Request.Method.GET,
                URL4,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Soy bean stock Response", response.toString());
                        soybVals =  soybDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest5 = new JsonObjectRequest(Request.Method.GET,
                URL5,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Sugar stock Response", response.toString());
                        sugarVals =  sugarDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest1);
        requestQueue.add(objectRequest2);
        requestQueue.add(objectRequest3);
        requestQueue.add(objectRequest4);
        requestQueue.add(objectRequest5);

        //Links the line chart XML to the java code
        mpLineChart = findViewById(R.id.line_chart);

        //The button that loads the data from the API call into the chart
        bitCoinApiButton = findViewById(R.id.bitcoin_api_button);
        bitCoinApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //onClick,
                //declare a variable stockTickerPrice
                // get the stockSpinner.getSelectedItem.toString() and assign the value to stockTicker

                String stockTicker = stockSpinner.getSelectedItem().toString();

                //the amount of days we are analyzing. Here it is always the size of the bitcoin API object
                int size = dataVals.size();
                ArrayList<Entry> commodityBitCoin = new ArrayList<>();

                //The switch for the commodities ticker spinner
                switch (stockTicker) {
                    case "CORN":
                        for(int i = 0; i <= size - 1; i++) {
                            float result;
                            float bitCoinPrice = dataVals.get(i).getY();
                            System.out.println(bitCoinPrice);
                            float cornPrice = cornVals.get(i).getY();
                            System.out.println(cornPrice);
                            result = cornPrice/bitCoinPrice;
                            System.out.println(result);
                            commodityBitCoin.add(new Entry(i, result));
                        }
                        break;
                    case "WEAT":
                        for(int i = 0; i <= size - 1; i++) {
                            float result;
                            float bitCoinPrice = dataVals.get(i).getY();
                            System.out.println(bitCoinPrice);
                            float wheatPrice = wheatVals.get(i).getY();
                            System.out.println(wheatPrice);
                            result = wheatPrice/bitCoinPrice;
                            System.out.println(result);
                            commodityBitCoin.add(new Entry(i, result));
                        }
                        break;
                    case "SOYB":
                        for(int i = 0; i <= size - 1; i++) {
                            float result;
                            float bitCoinPrice = dataVals.get(i).getY();
                            System.out.println(bitCoinPrice);
                            float soybeansPrice = soybVals.get(i).getY();
                            System.out.println(soybeansPrice);
                            result = soybeansPrice/bitCoinPrice;
                            System.out.println(result);
                            commodityBitCoin.add(new Entry(i, result));
                        }
                        break;
                    case "CANE":
                        for(int i = 0; i <= size - 1; i++) {
                            float result;
                            float bitCoinPrice = dataVals.get(i).getY();
                            System.out.println(bitCoinPrice);
                            float sugarPrice = sugarVals.get(i).getY();
                            System.out.println(sugarPrice);
                            result = sugarPrice/bitCoinPrice;
                            System.out.println(result);
                            commodityBitCoin.add(new Entry(i, result));
                        }
                        break;
                }

                LineDataSet lineDataSet1 = new LineDataSet(commodityBitCoin, "Teucrium Fund ETV ("+ stockTicker + ") / Bitcoin");
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(lineDataSet1);

                LineData data = new LineData(dataSets);
                mpLineChart.setData(data);
                mpLineChart.invalidate();
            }//end of onClick
        });//end of .setOnClickListener Interface is this parenthesis/semicolon
    }//end of onCreate()

    private ArrayList<Entry> bitcoinDataFunction(JSONObject response) {
        //System.out.println("Bitcoin API data starting here: ");
        //System.out.println(response.toString());
        ArrayList<Entry> dataVals = new ArrayList<>();
        try {
            bitCoinData = new double[] {

                    (double) response.getJSONObject("bpi").get("2021-02-06"),
                    (double) response.getJSONObject("bpi").get("2021-02-07"),
                    (double) response.getJSONObject("bpi").get("2021-02-08"),
                    (double) response.getJSONObject("bpi").get("2021-02-09"),
                    (double) response.getJSONObject("bpi").get("2021-02-10"),
                    (double) response.getJSONObject("bpi").get("2021-02-11"),
                    (double) response.getJSONObject("bpi").get("2021-02-12"),
                    (double) response.getJSONObject("bpi").get("2021-02-13"),
                    (double) response.getJSONObject("bpi").get("2021-02-14"),
                    (double) response.getJSONObject("bpi").get("2021-02-15"),
                    (double) response.getJSONObject("bpi").get("2021-02-16"),
                    (double) response.getJSONObject("bpi").get("2021-02-17"),
                    (double) response.getJSONObject("bpi").get("2021-02-18"),
                    (double) response.getJSONObject("bpi").get("2021-02-19"),
                    (double) response.getJSONObject("bpi").get("2021-02-20"),
                    (double) response.getJSONObject("bpi").get("2021-02-21"),
                    (double) response.getJSONObject("bpi").get("2021-02-22"),
                    (double) response.getJSONObject("bpi").get("2021-02-23"),
                    (double) response.getJSONObject("bpi").get("2021-02-24"),
                    (double) response.getJSONObject("bpi").get("2021-02-25"),
                    (double) response.getJSONObject("bpi").get("2021-02-26"),
                    (double) response.getJSONObject("bpi").get("2021-02-27"),
                    (double) response.getJSONObject("bpi").get("2021-02-28"),
                    (double) response.getJSONObject("bpi").get("2021-03-01"),
                    (double) response.getJSONObject("bpi").get("2021-03-02"),
                    (double) response.getJSONObject("bpi").get("2021-03-03"),
                    (double) response.getJSONObject("bpi").get("2021-03-04"),
                    (double) response.getJSONObject("bpi").get("2021-03-05"),
                    (double) response.getJSONObject("bpi").get("2021-03-06"),
                    (double) response.getJSONObject("bpi").get("2021-03-07"),
                    (double) response.getJSONObject("bpi").get("2021-03-08"),

            };

            dataVals.add(new Entry(0, (float) bitCoinData[0]));
            dataVals.add(new Entry(1, (float) bitCoinData[1]));
            dataVals.add(new Entry(2, (float) bitCoinData[2]));
            dataVals.add(new Entry(3, (float) bitCoinData[3]));
            dataVals.add(new Entry(4, (float) bitCoinData[4]));
            dataVals.add(new Entry(5, (float) bitCoinData[5]));
            dataVals.add(new Entry(6, (float) bitCoinData[6]));
            dataVals.add(new Entry(7, (float) bitCoinData[7]));
            dataVals.add(new Entry(8, (float) bitCoinData[8]));
            dataVals.add(new Entry(9, (float) bitCoinData[9]));
            dataVals.add(new Entry(10, (float) bitCoinData[10]));
            dataVals.add(new Entry(11, (float) bitCoinData[11]));
            dataVals.add(new Entry(12, (float) bitCoinData[12]));
            dataVals.add(new Entry(13, (float) bitCoinData[13]));
            dataVals.add(new Entry(14, (float) bitCoinData[14]));
            dataVals.add(new Entry(15, (float) bitCoinData[15]));
            dataVals.add(new Entry(16, (float) bitCoinData[16]));
            dataVals.add(new Entry(17, (float) bitCoinData[17]));
            dataVals.add(new Entry(18, (float) bitCoinData[18]));
            dataVals.add(new Entry(19, (float) bitCoinData[19]));
            dataVals.add(new Entry(20, (float) bitCoinData[20]));
            dataVals.add(new Entry(21, (float) bitCoinData[21]));
            dataVals.add(new Entry(22, (float) bitCoinData[22]));
            dataVals.add(new Entry(23, (float) bitCoinData[23]));
            dataVals.add(new Entry(24, (float) bitCoinData[24]));
            dataVals.add(new Entry(25, (float) bitCoinData[25]));
            dataVals.add(new Entry(26, (float) bitCoinData[26]));
            dataVals.add(new Entry(27, (float) bitCoinData[27]));
            dataVals.add(new Entry(28, (float) bitCoinData[28]));
            dataVals.add(new Entry(29, (float) bitCoinData[29]));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dataVals;
    }

    private ArrayList<Entry> cornDataFunction(JSONObject response) {
        //System.out.println("Corn API data starting here: ");
        //System.out.println(response.toString());
        ArrayList<Entry> cornVals = new ArrayList<>();
        try {
            cornData = new JSONObject[] {
                    response.getJSONArray("data").getJSONObject(0),
                    response.getJSONArray("data").getJSONObject(1),
                    response.getJSONArray("data").getJSONObject(2),
                    response.getJSONArray("data").getJSONObject(3),
                    response.getJSONArray("data").getJSONObject(4),
                    response.getJSONArray("data").getJSONObject(5),
                    response.getJSONArray("data").getJSONObject(6),
                    response.getJSONArray("data").getJSONObject(7),
                    response.getJSONArray("data").getJSONObject(8),
                    response.getJSONArray("data").getJSONObject(9),
                    response.getJSONArray("data").getJSONObject(10),
                    response.getJSONArray("data").getJSONObject(11),
                    response.getJSONArray("data").getJSONObject(12),
                    response.getJSONArray("data").getJSONObject(13),
                    response.getJSONArray("data").getJSONObject(14),
                    response.getJSONArray("data").getJSONObject(15),
                    response.getJSONArray("data").getJSONObject(16),
                    response.getJSONArray("data").getJSONObject(17),
                    response.getJSONArray("data").getJSONObject(18),
                    response.getJSONArray("data").getJSONObject(19),
                    response.getJSONArray("data").getJSONObject(20),
                    response.getJSONArray("data").getJSONObject(21),
                    response.getJSONArray("data").getJSONObject(22),
                    response.getJSONArray("data").getJSONObject(23),
                    response.getJSONArray("data").getJSONObject(24),
                    response.getJSONArray("data").getJSONObject(25),
                    response.getJSONArray("data").getJSONObject(26),
                    response.getJSONArray("data").getJSONObject(27),
                    response.getJSONArray("data").getJSONObject(28),
                    response.getJSONArray("data").getJSONObject(29),
            };

            double coData0 = cornData[0].getDouble("open");
            double coData1 = cornData[1].getDouble("open");
            double coData2 = cornData[2].getDouble("open");
            double coData3 = cornData[3].getDouble("open");
            double coData4 = cornData[4].getDouble("open");
            double coData5 = cornData[5].getDouble("open");
            double coData6 = cornData[6].getDouble("open");
            double coData7 = cornData[7].getDouble("open");
            double coData8 = cornData[8].getDouble("open");
            double coData9 = cornData[9].getDouble("open");
            double coData10 = cornData[10].getDouble("open");
            double coData11 = cornData[11].getDouble("open");
            double coData12 = cornData[12].getDouble("open");
            double coData13 = cornData[13].getDouble("open");
            double coData14 = cornData[14].getDouble("open");
            double coData15 = cornData[15].getDouble("open");
            double coData16 = cornData[16].getDouble("open");
            double coData17 = cornData[17].getDouble("open");
            double coData18 = cornData[18].getDouble("open");
            double coData19 = cornData[19].getDouble("open");
            double coData20 = cornData[20].getDouble("open");
            double coData21 = cornData[21].getDouble("open");
            double coData22 = cornData[22].getDouble("open");
            double coData23 = cornData[23].getDouble("open");
            double coData24 = cornData[24].getDouble("open");
            double coData25 = cornData[25].getDouble("open");
            double coData26 = cornData[26].getDouble("open");
            double coData27 = cornData[27].getDouble("open");
            double coData28 = cornData[28].getDouble("open");
            double coData29 = cornData[29].getDouble("open");


            cornVals.add(new Entry(0, (float) coData0));
            cornVals.add(new Entry(1, (float) coData1));
            cornVals.add(new Entry(2, (float) coData2));
            cornVals.add(new Entry(3, (float) coData3));
            cornVals.add(new Entry(4, (float) coData4));
            cornVals.add(new Entry(5, (float) coData5));
            cornVals.add(new Entry(6, (float) coData6));
            cornVals.add(new Entry(7, (float) coData7));
            cornVals.add(new Entry(8, (float) coData8));
            cornVals.add(new Entry(9, (float) coData9));
            cornVals.add(new Entry(10, (float) coData10));
            cornVals.add(new Entry(11, (float) coData11));
            cornVals.add(new Entry(12, (float) coData12));
            cornVals.add(new Entry(13, (float) coData13));
            cornVals.add(new Entry(14, (float) coData14));
            cornVals.add(new Entry(15, (float) coData15));
            cornVals.add(new Entry(16, (float) coData16));
            cornVals.add(new Entry(17, (float) coData17));
            cornVals.add(new Entry(18, (float) coData18));
            cornVals.add(new Entry(19, (float) coData19));
            cornVals.add(new Entry(20, (float) coData20));
            cornVals.add(new Entry(21, (float) coData21));
            cornVals.add(new Entry(22, (float) coData22));
            cornVals.add(new Entry(23, (float) coData23));
            cornVals.add(new Entry(24, (float) coData24));
            cornVals.add(new Entry(25, (float) coData25));
            cornVals.add(new Entry(26, (float) coData26));
            cornVals.add(new Entry(27, (float) coData27));
            cornVals.add(new Entry(28, (float) coData28));
            cornVals.add(new Entry(29, (float) coData29));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cornVals;
    }

    private ArrayList<Entry> wheatDataFunction(JSONObject response) {
        System.out.println("Wheat API data starting here: ");
        System.out.println(response.toString());
        ArrayList<Entry> wheatVals = new ArrayList<>();
        try {
            wheatData = new JSONObject[] {
                    response.getJSONArray("data").getJSONObject(0),
                    response.getJSONArray("data").getJSONObject(1),
                    response.getJSONArray("data").getJSONObject(2),
                    response.getJSONArray("data").getJSONObject(3),
                    response.getJSONArray("data").getJSONObject(4),
                    response.getJSONArray("data").getJSONObject(5),
                    response.getJSONArray("data").getJSONObject(6),
                    response.getJSONArray("data").getJSONObject(7),
                    response.getJSONArray("data").getJSONObject(8),
                    response.getJSONArray("data").getJSONObject(9),
                    response.getJSONArray("data").getJSONObject(10),
                    response.getJSONArray("data").getJSONObject(11),
                    response.getJSONArray("data").getJSONObject(12),
                    response.getJSONArray("data").getJSONObject(13),
                    response.getJSONArray("data").getJSONObject(14),
                    response.getJSONArray("data").getJSONObject(15),
                    response.getJSONArray("data").getJSONObject(16),
                    response.getJSONArray("data").getJSONObject(17),
                    response.getJSONArray("data").getJSONObject(18),
                    response.getJSONArray("data").getJSONObject(19),
                    response.getJSONArray("data").getJSONObject(20),
                    response.getJSONArray("data").getJSONObject(21),
                    response.getJSONArray("data").getJSONObject(22),
                    response.getJSONArray("data").getJSONObject(23),
                    response.getJSONArray("data").getJSONObject(24),
                    response.getJSONArray("data").getJSONObject(25),
                    response.getJSONArray("data").getJSONObject(26),
                    response.getJSONArray("data").getJSONObject(27),
                    response.getJSONArray("data").getJSONObject(28),
                    response.getJSONArray("data").getJSONObject(29),
            };

            double whData0 = wheatData[0].getDouble("open");
            double whData1 = wheatData[1].getDouble("open");
            double whData2 = wheatData[2].getDouble("open");
            double whData3 = wheatData[3].getDouble("open");
            double whData4 = wheatData[4].getDouble("open");
            double whData5 = wheatData[5].getDouble("open");
            double whData6 = wheatData[6].getDouble("open");
            double whData7 = wheatData[7].getDouble("open");
            double whData8 = wheatData[8].getDouble("open");
            double whData9 = wheatData[9].getDouble("open");
            double whData10 = wheatData[10].getDouble("open");
            double whData11= wheatData[11].getDouble("open");
            double whData12 = wheatData[12].getDouble("open");
            double whData13 = wheatData[13].getDouble("open");
            double whData14 = wheatData[14].getDouble("open");
            double whData15 = wheatData[15].getDouble("open");
            double whData16 = wheatData[16].getDouble("open");
            double whData17 = wheatData[17].getDouble("open");
            double whData18 = wheatData[18].getDouble("open");
            double whData19 = wheatData[19].getDouble("open");
            double whData20 = wheatData[20].getDouble("open");
            double whData21 = wheatData[21].getDouble("open");
            double whData22 = wheatData[22].getDouble("open");
            double whData23 = wheatData[23].getDouble("open");
            double whData24 = wheatData[24].getDouble("open");
            double whData25 = wheatData[25].getDouble("open");
            double whData26 = wheatData[26].getDouble("open");
            double whData27 = wheatData[27].getDouble("open");
            double whData28 = wheatData[28].getDouble("open");
            double whData29 = wheatData[29].getDouble("open");


            wheatVals.add(new Entry(0, (float) whData0));
            wheatVals.add(new Entry(1, (float) whData1));
            wheatVals.add(new Entry(2, (float) whData2));
            wheatVals.add(new Entry(3, (float) whData3));
            wheatVals.add(new Entry(4, (float) whData4));
            wheatVals.add(new Entry(5, (float) whData5));
            wheatVals.add(new Entry(6, (float) whData6));
            wheatVals.add(new Entry(7, (float) whData7));
            wheatVals.add(new Entry(8, (float) whData8));
            wheatVals.add(new Entry(9, (float) whData9));
            wheatVals.add(new Entry(10, (float) whData10));
            wheatVals.add(new Entry(11, (float) whData11));
            wheatVals.add(new Entry(12, (float) whData12));
            wheatVals.add(new Entry(13, (float) whData13));
            wheatVals.add(new Entry(14, (float) whData14));
            wheatVals.add(new Entry(15, (float) whData15));
            wheatVals.add(new Entry(16, (float) whData16));
            wheatVals.add(new Entry(17, (float) whData17));
            wheatVals.add(new Entry(18, (float) whData18));
            wheatVals.add(new Entry(19, (float) whData19));
            wheatVals.add(new Entry(20, (float) whData20));
            wheatVals.add(new Entry(21, (float) whData21));
            wheatVals.add(new Entry(22, (float) whData22));
            wheatVals.add(new Entry(23, (float) whData23));
            wheatVals.add(new Entry(24, (float) whData24));
            wheatVals.add(new Entry(25, (float) whData25));
            wheatVals.add(new Entry(26, (float) whData26));
            wheatVals.add(new Entry(27, (float) whData27));
            wheatVals.add(new Entry(28, (float) whData28));
            wheatVals.add(new Entry(29, (float) whData29));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return wheatVals;
    }

    private ArrayList<Entry> soybDataFunction(JSONObject response) {
        System.out.println("Soy Bean API data starting here: ");
        System.out.println(response.toString());
        ArrayList<Entry> soybVals = new ArrayList<>();
        try {
            soybData = new JSONObject[] {
                    response.getJSONArray("data").getJSONObject(0),
                    response.getJSONArray("data").getJSONObject(1),
                    response.getJSONArray("data").getJSONObject(2),
                    response.getJSONArray("data").getJSONObject(3),
                    response.getJSONArray("data").getJSONObject(4),
                    response.getJSONArray("data").getJSONObject(5),
                    response.getJSONArray("data").getJSONObject(6),
                    response.getJSONArray("data").getJSONObject(7),
                    response.getJSONArray("data").getJSONObject(8),
                    response.getJSONArray("data").getJSONObject(9),
                    response.getJSONArray("data").getJSONObject(10),
                    response.getJSONArray("data").getJSONObject(11),
                    response.getJSONArray("data").getJSONObject(12),
                    response.getJSONArray("data").getJSONObject(13),
                    response.getJSONArray("data").getJSONObject(14),
                    response.getJSONArray("data").getJSONObject(15),
                    response.getJSONArray("data").getJSONObject(16),
                    response.getJSONArray("data").getJSONObject(17),
                    response.getJSONArray("data").getJSONObject(18),
                    response.getJSONArray("data").getJSONObject(19),
                    response.getJSONArray("data").getJSONObject(20),
                    response.getJSONArray("data").getJSONObject(21),
                    response.getJSONArray("data").getJSONObject(22),
                    response.getJSONArray("data").getJSONObject(23),
                    response.getJSONArray("data").getJSONObject(24),
                    response.getJSONArray("data").getJSONObject(25),
                    response.getJSONArray("data").getJSONObject(26),
                    response.getJSONArray("data").getJSONObject(27),
                    response.getJSONArray("data").getJSONObject(28),
                    response.getJSONArray("data").getJSONObject(29),
            };

            double sbData0 = soybData[0].getDouble("open");
            double sbData1 = soybData[1].getDouble("open");
            double sbData2 = soybData[2].getDouble("open");
            double sbData3 = soybData[3].getDouble("open");
            double sbData4 = soybData[4].getDouble("open");
            double sbData5 = soybData[5].getDouble("open");
            double sbData6 = soybData[6].getDouble("open");
            double sbData7 = soybData[7].getDouble("open");
            double sbData8 = soybData[8].getDouble("open");
            double sbData9 = soybData[9].getDouble("open");
            double sbData10 = soybData[10].getDouble("open");
            double sbData11 = soybData[11].getDouble("open");
            double sbData12 = soybData[12].getDouble("open");
            double sbData13 = soybData[13].getDouble("open");
            double sbData14 = soybData[14].getDouble("open");
            double sbData15 = soybData[15].getDouble("open");
            double sbData16 = soybData[16].getDouble("open");
            double sbData17 = soybData[17].getDouble("open");
            double sbData18 = soybData[18].getDouble("open");
            double sbData19 = soybData[19].getDouble("open");
            double sbData20 = soybData[20].getDouble("open");
            double sbData21 = soybData[21].getDouble("open");
            double sbData22 = soybData[22].getDouble("open");
            double sbData23 = soybData[23].getDouble("open");
            double sbData24 = soybData[24].getDouble("open");
            double sbData25 = soybData[25].getDouble("open");
            double sbData26 = soybData[26].getDouble("open");
            double sbData27 = soybData[27].getDouble("open");
            double sbData28 = soybData[28].getDouble("open");
            double sbData29 = soybData[29].getDouble("open");

            soybVals.add(new Entry(0, (float) sbData0));
            soybVals.add(new Entry(1, (float) sbData1));
            soybVals.add(new Entry(2, (float) sbData2));
            soybVals.add(new Entry(3, (float) sbData3));
            soybVals.add(new Entry(4, (float) sbData4));
            soybVals.add(new Entry(5, (float) sbData5));
            soybVals.add(new Entry(6, (float) sbData6));
            soybVals.add(new Entry(7, (float) sbData7));
            soybVals.add(new Entry(8, (float) sbData8));
            soybVals.add(new Entry(9, (float) sbData9));
            soybVals.add(new Entry(10, (float) sbData10));
            soybVals.add(new Entry(11, (float) sbData11));
            soybVals.add(new Entry(12, (float) sbData12));
            soybVals.add(new Entry(13, (float) sbData13));
            soybVals.add(new Entry(14, (float) sbData14));
            soybVals.add(new Entry(15, (float) sbData15));
            soybVals.add(new Entry(16, (float) sbData16));
            soybVals.add(new Entry(17, (float) sbData17));
            soybVals.add(new Entry(18, (float) sbData18));
            soybVals.add(new Entry(19, (float) sbData19));
            soybVals.add(new Entry(20, (float) sbData20));
            soybVals.add(new Entry(21, (float) sbData21));
            soybVals.add(new Entry(22, (float) sbData22));
            soybVals.add(new Entry(23, (float) sbData23));
            soybVals.add(new Entry(24, (float) sbData24));
            soybVals.add(new Entry(25, (float) sbData25));
            soybVals.add(new Entry(26, (float) sbData26));
            soybVals.add(new Entry(27, (float) sbData27));
            soybVals.add(new Entry(28, (float) sbData28));
            soybVals.add(new Entry(29, (float) sbData29));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return soybVals;
    }


    private ArrayList<Entry> sugarDataFunction(JSONObject response) {
        System.out.println("Sugar API data starting here: ");
        System.out.println(response.toString());
        ArrayList<Entry> sugarVals = new ArrayList<>();
        try {
            sugarData = new JSONObject[] {
                    response.getJSONArray("data").getJSONObject(0),
                    response.getJSONArray("data").getJSONObject(1),
                    response.getJSONArray("data").getJSONObject(2),
                    response.getJSONArray("data").getJSONObject(3),
                    response.getJSONArray("data").getJSONObject(4),
                    response.getJSONArray("data").getJSONObject(5),
                    response.getJSONArray("data").getJSONObject(6),
                    response.getJSONArray("data").getJSONObject(7),
                    response.getJSONArray("data").getJSONObject(8),
                    response.getJSONArray("data").getJSONObject(9),
                    response.getJSONArray("data").getJSONObject(10),
                    response.getJSONArray("data").getJSONObject(11),
                    response.getJSONArray("data").getJSONObject(12),
                    response.getJSONArray("data").getJSONObject(13),
                    response.getJSONArray("data").getJSONObject(14),
                    response.getJSONArray("data").getJSONObject(15),
                    response.getJSONArray("data").getJSONObject(16),
                    response.getJSONArray("data").getJSONObject(17),
                    response.getJSONArray("data").getJSONObject(18),
                    response.getJSONArray("data").getJSONObject(19),
                    response.getJSONArray("data").getJSONObject(20),
                    response.getJSONArray("data").getJSONObject(21),
                    response.getJSONArray("data").getJSONObject(22),
                    response.getJSONArray("data").getJSONObject(23),
                    response.getJSONArray("data").getJSONObject(24),
                    response.getJSONArray("data").getJSONObject(25),
                    response.getJSONArray("data").getJSONObject(26),
                    response.getJSONArray("data").getJSONObject(27),
                    response.getJSONArray("data").getJSONObject(28),
                    response.getJSONArray("data").getJSONObject(29),
            };

            double sgData0 = sugarData[0].getDouble("open");
            double sgData1 = sugarData[1].getDouble("open");
            double sgData2 = sugarData[2].getDouble("open");
            double sgData3 = sugarData[3].getDouble("open");
            double sgData4 = sugarData[4].getDouble("open");
            double sgData5 = sugarData[5].getDouble("open");
            double sgData6 = sugarData[6].getDouble("open");
            double sgData7 = sugarData[7].getDouble("open");
            double sgData8 = sugarData[8].getDouble("open");
            double sgData9 = sugarData[9].getDouble("open");
            double sgData10 = sugarData[10].getDouble("open");
            double sgData11 = sugarData[11].getDouble("open");
            double sgData12 = sugarData[12].getDouble("open");
            double sgData13 = sugarData[13].getDouble("open");
            double sgData14 = sugarData[14].getDouble("open");
            double sgData15 = sugarData[15].getDouble("open");
            double sgData16 = sugarData[16].getDouble("open");
            double sgData17 = sugarData[17].getDouble("open");
            double sgData18 = sugarData[18].getDouble("open");
            double sgData19 = sugarData[19].getDouble("open");
            double sgData20 = sugarData[20].getDouble("open");
            double sgData21 = sugarData[21].getDouble("open");
            double sgData22 = sugarData[22].getDouble("open");
            double sgData23 = sugarData[23].getDouble("open");
            double sgData24 = sugarData[24].getDouble("open");
            double sgData25 = sugarData[25].getDouble("open");
            double sgData26 = sugarData[26].getDouble("open");
            double sgData27 = sugarData[27].getDouble("open");
            double sgData28 = sugarData[28].getDouble("open");
            double sgData29 = sugarData[29].getDouble("open");


            sugarVals.add(new Entry(0, (float) sgData0));
            sugarVals.add(new Entry(1, (float) sgData1));
            sugarVals.add(new Entry(2, (float) sgData2));
            sugarVals.add(new Entry(3, (float) sgData3));
            sugarVals.add(new Entry(4, (float) sgData4));
            sugarVals.add(new Entry(5, (float) sgData5));
            sugarVals.add(new Entry(6, (float) sgData6));
            sugarVals.add(new Entry(7, (float) sgData7));
            sugarVals.add(new Entry(8, (float) sgData8));
            sugarVals.add(new Entry(9, (float) sgData9));
            sugarVals.add(new Entry(10, (float) sgData10));
            sugarVals.add(new Entry(11, (float) sgData11));
            sugarVals.add(new Entry(12, (float) sgData12));
            sugarVals.add(new Entry(13, (float) sgData13));
            sugarVals.add(new Entry(14, (float) sgData14));
            sugarVals.add(new Entry(15, (float) sgData15));
            sugarVals.add(new Entry(16, (float) sgData16));
            sugarVals.add(new Entry(17, (float) sgData17));
            sugarVals.add(new Entry(18, (float) sgData18));
            sugarVals.add(new Entry(19, (float) sgData19));
            sugarVals.add(new Entry(20, (float) sgData20));
            sugarVals.add(new Entry(21, (float) sgData21));
            sugarVals.add(new Entry(22, (float) sgData22));
            sugarVals.add(new Entry(23, (float) sgData23));
            sugarVals.add(new Entry(24, (float) sgData24));
            sugarVals.add(new Entry(25, (float) sgData25));
            sugarVals.add(new Entry(26, (float) sgData26));
            sugarVals.add(new Entry(27, (float) sgData27));
            sugarVals.add(new Entry(28, (float) sgData28));
            sugarVals.add(new Entry(29, (float) sgData29));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sugarVals;
    }


}