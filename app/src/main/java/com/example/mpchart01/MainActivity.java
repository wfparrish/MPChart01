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
    private double[] bitCoinData;
    private JSONObject[] cornData;
    ArrayList<Entry> dataVals;
    ArrayList<Entry> cornVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL1="https://api.coindesk.com/v1/bpi/historical/close.json";
        String URL2="https://api.marketstack.com/v1/eod?access_key=86746e122918145ebf3f1473bf378d26&symbols=CORN";

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

        requestQueue.add(objectRequest1);
        requestQueue.add(objectRequest2);

        //Links the line chart XML to the java code
        mpLineChart = (LineChart) findViewById(R.id.line_chart);

        //The button that loads the data from the API call into the chart
        bitCoinApiButton = findViewById(R.id.bitcoin_api_button);
        bitCoinApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(dataVals.get(0).getY());
                System.out.println(cornVals.get(0).getY());

                //Inside here is where we are going to divide bitcoins by corn share prices
                //Eventually passing the values to an arraylist named dataVals, which will
                //be loaded by this onClick() listener into lineDataSet1

                LineDataSet lineDataSet1 = new LineDataSet(dataVals, "30 Day Rolling Bitcoin Prices");
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(lineDataSet1);

                LineData data = new LineData(dataSets);
                mpLineChart.setData(data);
                mpLineChart.invalidate();
            }
        });

    }//end of onCreate()

      private ArrayList<Entry> bitcoinDataFunction(JSONObject response) {
        //System.out.println("Bitcoin API data starting here: ");
        //System.out.println(response.toString());
          ArrayList<Entry> dataVals = new ArrayList<>();
          try {
              bitCoinData = new double[] {
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

}//end of MainActivity