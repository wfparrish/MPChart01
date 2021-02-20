package com.example.mpchart01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

public class MainActivity extends AppCompatActivity {

    LineChart mpLineChart;
    Button bitCoinApiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL="https://api.coindesk.com/v1/bpi/historical/close.json";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //So I need multiple objectRequest instance
        //ex. objectRequest1, objectRequest2
        //object

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Rest Response", response.toString());

                        testFunction(response);

                        //starting here is the private method you need to create and call
                        //You need a duplicate one for the Teucrium Corn Fund ETV (CORN) corn API
                        //Then
                        try {
                            double bitCoinData[] = {
                                    (double) response.getJSONObject("bpi").get("2021-01-20"),
                                    (double) response.getJSONObject("bpi").get("2021-01-21"),
                                    (double) response.getJSONObject("bpi").get("2021-01-22"),
                                    (double) response.getJSONObject("bpi").get("2021-01-23"),
                                    (double) response.getJSONObject("bpi").get("2021-01-24"),
                                    (double) response.getJSONObject("bpi").get("2021-01-25"),
                                    (double) response.getJSONObject("bpi").get("2021-01-26"),
                                    (double) response.getJSONObject("bpi").get("2021-01-27"),
                                    (double) response.getJSONObject("bpi").get("2021-01-28"),
                                    (double) response.getJSONObject("bpi").get("2021-01-29"),
                                    (double) response.getJSONObject("bpi").get("2021-01-30"),
                                    (double) response.getJSONObject("bpi").get("2021-01-31"),
                                    (double) response.getJSONObject("bpi").get("2021-02-01"),
                                    (double) response.getJSONObject("bpi").get("2021-02-02"),
                                    (double) response.getJSONObject("bpi").get("2021-02-03"),
                                    (double) response.getJSONObject("bpi").get("2021-02-04"),
                                    (double) response.getJSONObject("bpi").get("2021-02-05"),
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
                            };

                            ArrayList<Entry> dataVals = new ArrayList<>();

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
                            dataVals.add(new Entry(30, (float) bitCoinData[30]));

                            //Lines 125 to
                            mpLineChart = (LineChart) findViewById(R.id.line_chart);

                            //The button that loads the data from the API call into the chart
                            bitCoinApiButton = findViewById(R.id.bitcoin_api_button);
                            bitCoinApiButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LineDataSet lineDataSet1 = new LineDataSet(dataVals, "30 Day Rolling Bitcoin Prices");
                                    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                                    dataSets.add(lineDataSet1);

                                    LineData data = new LineData(dataSets);
                                    mpLineChart.setData(data);
                                    mpLineChart.invalidate();
                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);

    }

      private void testFunction(JSONObject response) {
        System.out.println("Bitcoin API data starting here: ");
        System.out.println(response.toString());
      }

//    private ArrayList<Entry> dataValues1()
//    {
//        ArrayList<Entry> dataVals = new ArrayList<Entry>();
//        dataVals.add(new Entry(0,5));
//        dataVals.add(new Entry(500,7));
//        dataVals.add(new Entry(1100,24));
//        dataVals.add(new Entry(6000,22));
//        dataVals.add(new Entry(11200,4));
//        dataVals.add(new Entry(15200,6));
//        dataVals.add(new Entry(21300,10));
//        dataVals.add(new Entry(24300,12));
//        dataVals.add(new Entry(30400,24));
//        dataVals.add(new Entry(40400,29));
//        dataVals.add(new Entry(51000,12));
//        dataVals.add(new Entry(52000,27));
//        dataVals.add(new Entry(55000,7));
//        dataVals.add(new Entry(58000,5));
//        dataVals.add(new Entry(63000,11));
//        dataVals.add(new Entry(69000,10));
//        dataVals.add(new Entry(74000,32));
//        dataVals.add(new Entry(87000,11));
//        dataVals.add(new Entry(96000,19));
//        dataVals.add(new Entry(102000,13));
//        dataVals.add(new Entry(110000,24));
//        dataVals.add(new Entry(115000,15));
//        dataVals.add(new Entry(120000,21));
//        dataVals.add(new Entry(125000,12));
//        dataVals.add(new Entry(130000,11));
//        dataVals.add(new Entry(135000,17));
//        dataVals.add(new Entry(140000,25));
//        dataVals.add(new Entry(145000,5));
//        dataVals.add(new Entry(150000,19));
//        dataVals.add(new Entry(155000,20));
//        dataVals.add(new Entry(166600,13));
//        dataVals.add(new Entry(175600,24));
//        dataVals.add(new Entry(177700,27));
//        dataVals.add(new Entry(180000,25));
//        dataVals.add(new Entry(188800,35));
//        dataVals.add(new Entry(200000,7));
//        dataVals.add(new Entry(230000,28));
//        dataVals.add(new Entry(275000,29));
//        dataVals.add(new Entry(300000,7));
//        dataVals.add(new Entry(315000,4));
//        dataVals.add(new Entry(325000,3));
//        dataVals.add(new Entry(335000,17));
//        dataVals.add(new Entry(350000,9));
//        dataVals.add(new Entry(362000,12));
//        dataVals.add(new Entry(375000,11));
//        dataVals.add(new Entry(385000,17));
//        dataVals.add(new Entry(394000,28));
//        dataVals.add(new Entry(400000,29));
//        return dataVals;
//    }//end of dataValues1()

}