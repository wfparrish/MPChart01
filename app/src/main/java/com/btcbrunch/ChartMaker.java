package com.btcbrunch;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class ChartMaker {

    int numOfDaysCrypto;
    String stockSpinnerStrVal;
    ArrayList<Candlestick> cryptoValsInOnClick;
    ArrayList<Entry> commodityBitCoin;
    //This will take an argument in the constructor like cornVals
    ArrayList<Entry> selectedCommodityVals;

    //I think this will import the mpLineChart from the main Activity...
    LineChart mpLineChart;

    ChartMaker(int numOfDaysCrypto,
               String stockSpinnerStrVal,
               ArrayList<Candlestick> cryptoValsInOnClick,
               ArrayList<Entry> commodityBitCoin,
               ArrayList<Entry> selectedCommodityVals,
               LineChart mpLineChart) {

        this.numOfDaysCrypto = numOfDaysCrypto;
        this.stockSpinnerStrVal = stockSpinnerStrVal;
        this.cryptoValsInOnClick = cryptoValsInOnClick;
        this.commodityBitCoin = commodityBitCoin;
        this.selectedCommodityVals = selectedCommodityVals;
        this.mpLineChart = mpLineChart;
    }

    //contains the code that was in the case. Populates the chart
    public void populateChart() {

        for(int i = 0; i <= numOfDaysCrypto - 1; i++) {
            float result;
            float cryptoPrice = cryptoValsInOnClick.get(i).getOpen();
            float cornPrice = this.selectedCommodityVals.get(i).getY();
            result = cornPrice / cryptoPrice;
            commodityBitCoin.add(new Entry(i, result));
            LineDataSet lineDataSet1 = new LineDataSet(commodityBitCoin, "Teucrium Fund ETV (" + stockSpinnerStrVal + ") / Bitcoin");
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(lineDataSet1);

            LineData data = new LineData(dataSets);
            mpLineChart.setData(data);
            mpLineChart.invalidate();

        }
    }

}//end of the ChartMaker class
