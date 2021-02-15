package com.example.mpchart01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LineChart mpLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL="https://api.coindesk.com/v1/bpi/historical/close.json";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response", response.toString());
                        try {
                            System.out.println(response.getJSONObject("bpi").get("2021-01-15"));
                            System.out.println(response.getJSONObject("bpi").get("2021-01-16"));
                            System.out.println(response.getJSONObject("bpi").get("2021-01-17"));
                            System.out.println(response.getJSONObject("bpi").get("2021-01-18"));
                            System.out.println(response.getJSONObject("bpi").get("2021-01-19"));
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


        mpLineChart=(LineChart) findViewById(R.id.line_chart);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();
    }

    private ArrayList<Entry> dataValues1()
    {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,5));
        dataVals.add(new Entry(500,7));
        dataVals.add(new Entry(1100,24));
        dataVals.add(new Entry(6000,22));
        dataVals.add(new Entry(11200,4));
        dataVals.add(new Entry(15200,6));
        dataVals.add(new Entry(21300,10));
        dataVals.add(new Entry(24300,12));
        dataVals.add(new Entry(30400,24));
        dataVals.add(new Entry(40400,29));
        dataVals.add(new Entry(51000,12));
        dataVals.add(new Entry(52000,27));
        dataVals.add(new Entry(55000,7));
        dataVals.add(new Entry(58000,5));
        dataVals.add(new Entry(63000,11));
        dataVals.add(new Entry(69000,10));
        dataVals.add(new Entry(74000,32));
        dataVals.add(new Entry(87000,11));
        dataVals.add(new Entry(96000,19));
        dataVals.add(new Entry(102000,13));
        dataVals.add(new Entry(110000,24));
        dataVals.add(new Entry(115000,15));
        dataVals.add(new Entry(120000,21));
        dataVals.add(new Entry(125000,12));
        dataVals.add(new Entry(130000,11));
        dataVals.add(new Entry(135000,17));
        dataVals.add(new Entry(140000,25));
        dataVals.add(new Entry(145000,5));
        dataVals.add(new Entry(150000,19));
        dataVals.add(new Entry(155000,20));
        dataVals.add(new Entry(166600,13));
        dataVals.add(new Entry(175600,24));
        dataVals.add(new Entry(177700,27));
        dataVals.add(new Entry(180000,25));
        dataVals.add(new Entry(188800,35));
        dataVals.add(new Entry(200000,7));
        dataVals.add(new Entry(230000,28));
        dataVals.add(new Entry(275000,29));
        dataVals.add(new Entry(300000,7));
        dataVals.add(new Entry(315000,4));
        dataVals.add(new Entry(325000,3));
        dataVals.add(new Entry(335000,17));
        dataVals.add(new Entry(350000,9));
        dataVals.add(new Entry(362000,12));
        dataVals.add(new Entry(375000,11));
        dataVals.add(new Entry(385000,17));
        dataVals.add(new Entry(394000,28));
        dataVals.add(new Entry(400000,29));
        return dataVals;
    }//end of dataValues1()

}