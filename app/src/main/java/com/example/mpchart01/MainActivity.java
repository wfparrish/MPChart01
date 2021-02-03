package com.example.mpchart01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LineChart mpLineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        dataVals.add(new Entry(1100,24));
        dataVals.add(new Entry(11200,2));
        dataVals.add(new Entry(21300,10));
        dataVals.add(new Entry(30400,28));
        dataVals.add(new Entry(51000,24));
        dataVals.add(new Entry(52000,2));
        dataVals.add(new Entry(63000,10));
        dataVals.add(new Entry(74000,28));
        dataVals.add(new Entry(96000,15));
        dataVals.add(new Entry(110000,24));
        dataVals.add(new Entry(120000,2));
        dataVals.add(new Entry(130000,10));
        dataVals.add(new Entry(140000,28));
        dataVals.add(new Entry(150000,20));
        dataVals.add(new Entry(166600,24));
        dataVals.add(new Entry(177700,2));
        dataVals.add(new Entry(188800,10));
        dataVals.add(new Entry(299900,28));
        dataVals.add(new Entry(315000,25));
        dataVals.add(new Entry(325000,24));
        dataVals.add(new Entry(350000,2));
        dataVals.add(new Entry(375000,10));
        dataVals.add(new Entry(400000,28));
        return dataVals;
    }//end of dataValues1()

}