package com.example.mpchart01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import android.os.Bundle;

import java.util.ArrayList;

public class BitCoinCandleStickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_coin_candle_stick);
        CandleStickChart candleStickChart = findViewById(R.id.candle_stick_chart);
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

        ArrayList<CandleEntry> listValsCandleStick = new ArrayList<CandleEntry>();
        listValsCandleStick.add(new CandleEntry(0, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(1, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(2, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(3, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(4, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(5, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(6, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(7, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(8, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(9, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(10, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(11, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(12, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(13, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(14, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(15, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(16, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(17, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(18, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(19, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(20, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(21, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(22, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(23, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(24, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(25, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(26, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(27, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(28, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(29, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(30, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(31, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(32, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(33, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(34, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(35, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(36, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(37, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(38, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(39, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(40, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(41, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(42, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(43, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(44, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(45, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(46, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(47, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(48, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(49, 222.10f, 223.21f, 219.17f, 224.97f));

        listValsCandleStick.add(new CandleEntry(50, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(51, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(52, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(53, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(54, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(55, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(56, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(57, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(58, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(59, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(60, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(61, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(62, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(63, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(64, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(65, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(66, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(67, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(68, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(69, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(70, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(71, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(72, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(73, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(74, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(75, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(76, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(77, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(78, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(79, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(80, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(81, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(82, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(83, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(84, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(85, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(86, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(87, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(88, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(89, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(90, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(91, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(92, 225.0f, 219.84f, 224.94f, 221.07f));
        listValsCandleStick.add(new CandleEntry(93, 228.0f, 222.57f, 223.52f, 226.41f));
        listValsCandleStick.add(new CandleEntry(94, 226.84f, 222.52f, 225.75f, 223.84f));
        listValsCandleStick.add(new CandleEntry(95, 222.95f, 217.27f, 222.15f, 217.88f));
        listValsCandleStick.add(new CandleEntry(96, 223.81f, 219.13f, 218.02f, 219.14f));
        listValsCandleStick.add(new CandleEntry(97, 226.02f, 227.62f, 228.00f, 227.91f));
        listValsCandleStick.add(new CandleEntry(98, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(99, 222.10f, 223.21f, 219.17f, 224.97f));
        listValsCandleStick.add(new CandleEntry(100, 222.10f, 223.21f, 219.17f, 224.97f));

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


}