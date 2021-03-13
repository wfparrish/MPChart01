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
                        Log.e("Ticker Response", response.toString());
                        tickerDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response Error", error.toString());
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

                listValsCandleStick.add(new CandleEntry(0, candlesticks.get(0).getHigh(), candlesticks.get(0).getLow(), candlesticks.get(0).getOpen(), candlesticks.get(0).getClose()));
                listValsCandleStick.add(new CandleEntry(1, candlesticks.get(1).getHigh(), candlesticks.get(1).getLow(), candlesticks.get(1).getOpen(), candlesticks.get(1).getClose()));
                listValsCandleStick.add(new CandleEntry(2, candlesticks.get(2).getHigh(), candlesticks.get(2).getLow(), candlesticks.get(2).getOpen(), candlesticks.get(2).getClose()));
                listValsCandleStick.add(new CandleEntry(3, candlesticks.get(3).getHigh(), candlesticks.get(3).getLow(), candlesticks.get(3).getOpen(), candlesticks.get(3).getClose()));
                listValsCandleStick.add(new CandleEntry(4, candlesticks.get(4).getHigh(), candlesticks.get(4).getLow(), candlesticks.get(4).getOpen(), candlesticks.get(4).getClose()));
                listValsCandleStick.add(new CandleEntry(5, candlesticks.get(5).getHigh(), candlesticks.get(5).getLow(), candlesticks.get(5).getOpen(), candlesticks.get(5).getClose()));
                listValsCandleStick.add(new CandleEntry(6, candlesticks.get(6).getHigh(), candlesticks.get(6).getLow(), candlesticks.get(6).getOpen(), candlesticks.get(6).getClose()));
                listValsCandleStick.add(new CandleEntry(7, candlesticks.get(7).getHigh(), candlesticks.get(7).getLow(), candlesticks.get(7).getOpen(), candlesticks.get(7).getClose()));
                listValsCandleStick.add(new CandleEntry(8, candlesticks.get(8).getHigh(), candlesticks.get(8).getLow(), candlesticks.get(8).getOpen(), candlesticks.get(8).getClose()));
                listValsCandleStick.add(new CandleEntry(9, candlesticks.get(9).getHigh(), candlesticks.get(9).getLow(), candlesticks.get(9).getOpen(), candlesticks.get(9).getClose()));
                listValsCandleStick.add(new CandleEntry(10, candlesticks.get(10).getHigh(), candlesticks.get(10).getLow(), candlesticks.get(10).getOpen(), candlesticks.get(10).getClose()));
                listValsCandleStick.add(new CandleEntry(11, candlesticks.get(11).getHigh(), candlesticks.get(11).getLow(), candlesticks.get(11).getOpen(), candlesticks.get(11).getClose()));
                listValsCandleStick.add(new CandleEntry(12, candlesticks.get(12).getHigh(), candlesticks.get(12).getLow(), candlesticks.get(12).getOpen(), candlesticks.get(12).getClose()));
                listValsCandleStick.add(new CandleEntry(13, candlesticks.get(13).getHigh(), candlesticks.get(13).getLow(), candlesticks.get(13).getOpen(), candlesticks.get(13).getClose()));
                listValsCandleStick.add(new CandleEntry(14, candlesticks.get(14).getHigh(), candlesticks.get(14).getLow(), candlesticks.get(14).getOpen(), candlesticks.get(14).getClose()));
                listValsCandleStick.add(new CandleEntry(15, candlesticks.get(15).getHigh(), candlesticks.get(15).getLow(), candlesticks.get(15).getOpen(), candlesticks.get(15).getClose()));
                listValsCandleStick.add(new CandleEntry(16, candlesticks.get(16).getHigh(), candlesticks.get(16).getLow(), candlesticks.get(16).getOpen(), candlesticks.get(16).getClose()));
                listValsCandleStick.add(new CandleEntry(17, candlesticks.get(17).getHigh(), candlesticks.get(17).getLow(), candlesticks.get(17).getOpen(), candlesticks.get(17).getClose()));
                listValsCandleStick.add(new CandleEntry(18, candlesticks.get(18).getHigh(), candlesticks.get(18).getLow(), candlesticks.get(18).getOpen(), candlesticks.get(18).getClose()));
                listValsCandleStick.add(new CandleEntry(19, candlesticks.get(19).getHigh(), candlesticks.get(19).getLow(), candlesticks.get(19).getOpen(), candlesticks.get(19).getClose()));
                listValsCandleStick.add(new CandleEntry(20, candlesticks.get(20).getHigh(), candlesticks.get(20).getLow(), candlesticks.get(20).getOpen(), candlesticks.get(20).getClose()));
                listValsCandleStick.add(new CandleEntry(21, candlesticks.get(21).getHigh(), candlesticks.get(21).getLow(), candlesticks.get(21).getOpen(), candlesticks.get(21).getClose()));
                listValsCandleStick.add(new CandleEntry(22, candlesticks.get(22).getHigh(), candlesticks.get(22).getLow(), candlesticks.get(22).getOpen(), candlesticks.get(22).getClose()));
                listValsCandleStick.add(new CandleEntry(23, candlesticks.get(23).getHigh(), candlesticks.get(23).getLow(), candlesticks.get(23).getOpen(), candlesticks.get(23).getClose()));
                listValsCandleStick.add(new CandleEntry(24, candlesticks.get(24).getHigh(), candlesticks.get(24).getLow(), candlesticks.get(24).getOpen(), candlesticks.get(24).getClose()));
                listValsCandleStick.add(new CandleEntry(25, candlesticks.get(25).getHigh(), candlesticks.get(25).getLow(), candlesticks.get(25).getOpen(), candlesticks.get(25).getClose()));
                listValsCandleStick.add(new CandleEntry(26, candlesticks.get(26).getHigh(), candlesticks.get(26).getLow(), candlesticks.get(26).getOpen(), candlesticks.get(26).getClose()));
                listValsCandleStick.add(new CandleEntry(27, candlesticks.get(27).getHigh(), candlesticks.get(27).getLow(), candlesticks.get(27).getOpen(), candlesticks.get(27).getClose()));
                listValsCandleStick.add(new CandleEntry(28, candlesticks.get(28).getHigh(), candlesticks.get(28).getLow(), candlesticks.get(28).getOpen(), candlesticks.get(28).getClose()));
                listValsCandleStick.add(new CandleEntry(29, candlesticks.get(29).getHigh(), candlesticks.get(29).getLow(), candlesticks.get(29).getOpen(), candlesticks.get(29).getClose()));
                listValsCandleStick.add(new CandleEntry(30, candlesticks.get(30).getHigh(), candlesticks.get(30).getLow(), candlesticks.get(30).getOpen(), candlesticks.get(30).getClose()));
                listValsCandleStick.add(new CandleEntry(31, candlesticks.get(31).getHigh(), candlesticks.get(31).getLow(), candlesticks.get(31).getOpen(), candlesticks.get(31).getClose()));
                listValsCandleStick.add(new CandleEntry(32, candlesticks.get(32).getHigh(), candlesticks.get(32).getLow(), candlesticks.get(32).getOpen(), candlesticks.get(32).getClose()));
                listValsCandleStick.add(new CandleEntry(33, candlesticks.get(33).getHigh(), candlesticks.get(33).getLow(), candlesticks.get(33).getOpen(), candlesticks.get(33).getClose()));
                listValsCandleStick.add(new CandleEntry(34, candlesticks.get(34).getHigh(), candlesticks.get(34).getLow(), candlesticks.get(34).getOpen(), candlesticks.get(34).getClose()));
                listValsCandleStick.add(new CandleEntry(35, candlesticks.get(35).getHigh(), candlesticks.get(35).getLow(), candlesticks.get(35).getOpen(), candlesticks.get(35).getClose()));
                listValsCandleStick.add(new CandleEntry(36, candlesticks.get(36).getHigh(), candlesticks.get(36).getLow(), candlesticks.get(36).getOpen(), candlesticks.get(36).getClose()));
                listValsCandleStick.add(new CandleEntry(37, candlesticks.get(37).getHigh(), candlesticks.get(37).getLow(), candlesticks.get(37).getOpen(), candlesticks.get(37).getClose()));
                listValsCandleStick.add(new CandleEntry(38, candlesticks.get(38).getHigh(), candlesticks.get(38).getLow(), candlesticks.get(38).getOpen(), candlesticks.get(38).getClose()));
                listValsCandleStick.add(new CandleEntry(39, candlesticks.get(39).getHigh(), candlesticks.get(39).getLow(), candlesticks.get(39).getOpen(), candlesticks.get(39).getClose()));
                listValsCandleStick.add(new CandleEntry(40, candlesticks.get(40).getHigh(), candlesticks.get(40).getLow(), candlesticks.get(40).getOpen(), candlesticks.get(40).getClose()));
                listValsCandleStick.add(new CandleEntry(41, candlesticks.get(41).getHigh(), candlesticks.get(41).getLow(), candlesticks.get(41).getOpen(), candlesticks.get(41).getClose()));
                listValsCandleStick.add(new CandleEntry(42, candlesticks.get(42).getHigh(), candlesticks.get(42).getLow(), candlesticks.get(42).getOpen(), candlesticks.get(42).getClose()));
                listValsCandleStick.add(new CandleEntry(43, candlesticks.get(43).getHigh(), candlesticks.get(43).getLow(), candlesticks.get(43).getOpen(), candlesticks.get(43).getClose()));
                listValsCandleStick.add(new CandleEntry(44, candlesticks.get(44).getHigh(), candlesticks.get(44).getLow(), candlesticks.get(44).getOpen(), candlesticks.get(44).getClose()));
                listValsCandleStick.add(new CandleEntry(45, candlesticks.get(45).getHigh(), candlesticks.get(45).getLow(), candlesticks.get(45).getOpen(), candlesticks.get(45).getClose()));
                listValsCandleStick.add(new CandleEntry(46, candlesticks.get(46).getHigh(), candlesticks.get(46).getLow(), candlesticks.get(46).getOpen(), candlesticks.get(46).getClose()));
                listValsCandleStick.add(new CandleEntry(47, candlesticks.get(47).getHigh(), candlesticks.get(47).getLow(), candlesticks.get(47).getOpen(), candlesticks.get(47).getClose()));
                listValsCandleStick.add(new CandleEntry(48, candlesticks.get(48).getHigh(), candlesticks.get(48).getLow(), candlesticks.get(48).getOpen(), candlesticks.get(48).getClose()));
                listValsCandleStick.add(new CandleEntry(49, candlesticks.get(49).getHigh(), candlesticks.get(49).getLow(), candlesticks.get(49).getOpen(), candlesticks.get(49).getClose()));
                listValsCandleStick.add(new CandleEntry(50, candlesticks.get(50).getHigh(), candlesticks.get(50).getLow(), candlesticks.get(50).getOpen(), candlesticks.get(50).getClose()));
                listValsCandleStick.add(new CandleEntry(51, candlesticks.get(51).getHigh(), candlesticks.get(51).getLow(), candlesticks.get(51).getOpen(), candlesticks.get(51).getClose()));
                listValsCandleStick.add(new CandleEntry(52, candlesticks.get(52).getHigh(), candlesticks.get(52).getLow(), candlesticks.get(52).getOpen(), candlesticks.get(52).getClose()));
                listValsCandleStick.add(new CandleEntry(53, candlesticks.get(53).getHigh(), candlesticks.get(53).getLow(), candlesticks.get(53).getOpen(), candlesticks.get(53).getClose()));
                listValsCandleStick.add(new CandleEntry(54, candlesticks.get(54).getHigh(), candlesticks.get(54).getLow(), candlesticks.get(54).getOpen(), candlesticks.get(54).getClose()));
                listValsCandleStick.add(new CandleEntry(55, candlesticks.get(55).getHigh(), candlesticks.get(55).getLow(), candlesticks.get(55).getOpen(), candlesticks.get(55).getClose()));
                listValsCandleStick.add(new CandleEntry(56, candlesticks.get(56).getHigh(), candlesticks.get(56).getLow(), candlesticks.get(56).getOpen(), candlesticks.get(56).getClose()));
                listValsCandleStick.add(new CandleEntry(57, candlesticks.get(57).getHigh(), candlesticks.get(57).getLow(), candlesticks.get(57).getOpen(), candlesticks.get(57).getClose()));
                listValsCandleStick.add(new CandleEntry(58, candlesticks.get(58).getHigh(), candlesticks.get(58).getLow(), candlesticks.get(58).getOpen(), candlesticks.get(58).getClose()));
                listValsCandleStick.add(new CandleEntry(59, candlesticks.get(59).getHigh(), candlesticks.get(59).getLow(), candlesticks.get(59).getOpen(), candlesticks.get(59).getClose()));
                listValsCandleStick.add(new CandleEntry(60, candlesticks.get(60).getHigh(), candlesticks.get(60).getLow(), candlesticks.get(60).getOpen(), candlesticks.get(60).getClose()));
                listValsCandleStick.add(new CandleEntry(61, candlesticks.get(61).getHigh(), candlesticks.get(61).getLow(), candlesticks.get(61).getOpen(), candlesticks.get(61).getClose()));
                listValsCandleStick.add(new CandleEntry(62, candlesticks.get(62).getHigh(), candlesticks.get(62).getLow(), candlesticks.get(62).getOpen(), candlesticks.get(62).getClose()));
                listValsCandleStick.add(new CandleEntry(63, candlesticks.get(63).getHigh(), candlesticks.get(63).getLow(), candlesticks.get(63).getOpen(), candlesticks.get(63).getClose()));
                listValsCandleStick.add(new CandleEntry(64, candlesticks.get(64).getHigh(), candlesticks.get(64).getLow(), candlesticks.get(64).getOpen(), candlesticks.get(64).getClose()));
                listValsCandleStick.add(new CandleEntry(65, candlesticks.get(65).getHigh(), candlesticks.get(65).getLow(), candlesticks.get(65).getOpen(), candlesticks.get(65).getClose()));
                listValsCandleStick.add(new CandleEntry(66, candlesticks.get(66).getHigh(), candlesticks.get(66).getLow(), candlesticks.get(66).getOpen(), candlesticks.get(66).getClose()));
                listValsCandleStick.add(new CandleEntry(67, candlesticks.get(67).getHigh(), candlesticks.get(67).getLow(), candlesticks.get(67).getOpen(), candlesticks.get(67).getClose()));
                listValsCandleStick.add(new CandleEntry(68, candlesticks.get(68).getHigh(), candlesticks.get(68).getLow(), candlesticks.get(68).getOpen(), candlesticks.get(68).getClose()));
                listValsCandleStick.add(new CandleEntry(69, candlesticks.get(69).getHigh(), candlesticks.get(69).getLow(), candlesticks.get(69).getOpen(), candlesticks.get(69).getClose()));
                listValsCandleStick.add(new CandleEntry(70, candlesticks.get(70).getHigh(), candlesticks.get(70).getLow(), candlesticks.get(70).getOpen(), candlesticks.get(70).getClose()));
                listValsCandleStick.add(new CandleEntry(71, candlesticks.get(71).getHigh(), candlesticks.get(71).getLow(), candlesticks.get(71).getOpen(), candlesticks.get(71).getClose()));
                listValsCandleStick.add(new CandleEntry(72, candlesticks.get(72).getHigh(), candlesticks.get(72).getLow(), candlesticks.get(72).getOpen(), candlesticks.get(72).getClose()));
                listValsCandleStick.add(new CandleEntry(73, candlesticks.get(73).getHigh(), candlesticks.get(73).getLow(), candlesticks.get(73).getOpen(), candlesticks.get(73).getClose()));
                listValsCandleStick.add(new CandleEntry(74, candlesticks.get(74).getHigh(), candlesticks.get(74).getLow(), candlesticks.get(74).getOpen(), candlesticks.get(74).getClose()));
                listValsCandleStick.add(new CandleEntry(75, candlesticks.get(75).getHigh(), candlesticks.get(75).getLow(), candlesticks.get(75).getOpen(), candlesticks.get(75).getClose()));
                listValsCandleStick.add(new CandleEntry(76, candlesticks.get(76).getHigh(), candlesticks.get(76).getLow(), candlesticks.get(76).getOpen(), candlesticks.get(76).getClose()));
                listValsCandleStick.add(new CandleEntry(77, candlesticks.get(77).getHigh(), candlesticks.get(77).getLow(), candlesticks.get(77).getOpen(), candlesticks.get(77).getClose()));
                listValsCandleStick.add(new CandleEntry(78, candlesticks.get(78).getHigh(), candlesticks.get(78).getLow(), candlesticks.get(78).getOpen(), candlesticks.get(78).getClose()));
                listValsCandleStick.add(new CandleEntry(79, candlesticks.get(79).getHigh(), candlesticks.get(79).getLow(), candlesticks.get(79).getOpen(), candlesticks.get(79).getClose()));
                listValsCandleStick.add(new CandleEntry(80, candlesticks.get(80).getHigh(), candlesticks.get(80).getLow(), candlesticks.get(80).getOpen(), candlesticks.get(80).getClose()));
                listValsCandleStick.add(new CandleEntry(81, candlesticks.get(81).getHigh(), candlesticks.get(81).getLow(), candlesticks.get(81).getOpen(), candlesticks.get(81).getClose()));
                listValsCandleStick.add(new CandleEntry(82, candlesticks.get(82).getHigh(), candlesticks.get(82).getLow(), candlesticks.get(82).getOpen(), candlesticks.get(82).getClose()));
                listValsCandleStick.add(new CandleEntry(83, candlesticks.get(83).getHigh(), candlesticks.get(83).getLow(), candlesticks.get(83).getOpen(), candlesticks.get(83).getClose()));
                listValsCandleStick.add(new CandleEntry(84, candlesticks.get(84).getHigh(), candlesticks.get(84).getLow(), candlesticks.get(84).getOpen(), candlesticks.get(84).getClose()));
                listValsCandleStick.add(new CandleEntry(85, candlesticks.get(85).getHigh(), candlesticks.get(85).getLow(), candlesticks.get(85).getOpen(), candlesticks.get(85).getClose()));
                listValsCandleStick.add(new CandleEntry(86, candlesticks.get(86).getHigh(), candlesticks.get(86).getLow(), candlesticks.get(86).getOpen(), candlesticks.get(86).getClose()));
                listValsCandleStick.add(new CandleEntry(87, candlesticks.get(87).getHigh(), candlesticks.get(87).getLow(), candlesticks.get(87).getOpen(), candlesticks.get(87).getClose()));
                listValsCandleStick.add(new CandleEntry(88, candlesticks.get(88).getHigh(), candlesticks.get(88).getLow(), candlesticks.get(88).getOpen(), candlesticks.get(88).getClose()));
                listValsCandleStick.add(new CandleEntry(89, candlesticks.get(89).getHigh(), candlesticks.get(89).getLow(), candlesticks.get(89).getOpen(), candlesticks.get(89).getClose()));
                listValsCandleStick.add(new CandleEntry(90, candlesticks.get(90).getHigh(), candlesticks.get(90).getLow(), candlesticks.get(90).getOpen(), candlesticks.get(90).getClose()));
                listValsCandleStick.add(new CandleEntry(91, candlesticks.get(91).getHigh(), candlesticks.get(91).getLow(), candlesticks.get(91).getOpen(), candlesticks.get(91).getClose()));
                listValsCandleStick.add(new CandleEntry(92, candlesticks.get(92).getHigh(), candlesticks.get(92).getLow(), candlesticks.get(92).getOpen(), candlesticks.get(92).getClose()));
                listValsCandleStick.add(new CandleEntry(93, candlesticks.get(93).getHigh(), candlesticks.get(93).getLow(), candlesticks.get(93).getOpen(), candlesticks.get(93).getClose()));
                listValsCandleStick.add(new CandleEntry(94, candlesticks.get(94).getHigh(), candlesticks.get(94).getLow(), candlesticks.get(94).getOpen(), candlesticks.get(94).getClose()));
                listValsCandleStick.add(new CandleEntry(95, candlesticks.get(95).getHigh(), candlesticks.get(95).getLow(), candlesticks.get(95).getOpen(), candlesticks.get(95).getClose()));
                listValsCandleStick.add(new CandleEntry(96, candlesticks.get(96).getHigh(), candlesticks.get(96).getLow(), candlesticks.get(96).getOpen(), candlesticks.get(96).getClose()));
                listValsCandleStick.add(new CandleEntry(97, candlesticks.get(97).getHigh(), candlesticks.get(97).getLow(), candlesticks.get(97).getOpen(), candlesticks.get(97).getClose()));
                listValsCandleStick.add(new CandleEntry(98, candlesticks.get(98).getHigh(), candlesticks.get(98).getLow(), candlesticks.get(98).getOpen(), candlesticks.get(98).getClose()));
                listValsCandleStick.add(new CandleEntry(99, candlesticks.get(99).getHigh(), candlesticks.get(99).getLow(), candlesticks.get(99).getOpen(), candlesticks.get(99).getClose()));


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

            }
        });
    }//end of onCreate()

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

        return candlesticks;
    }


}