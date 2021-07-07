package com.btcbrunch;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class CryptoSelector {

    public void selectCrypto(String stockSpinnerStrVal, String bitCoinSpinnerStrVal, int numOfDaysBtnSelected, RequestQueue requestQueue, LineChart mpLineChart, CommoditySelector commoditySelector) {
        String selectedURL = null;

        switch (bitCoinSpinnerStrVal) {
            case "BTC": {
//                        selectedURL="http://192.168.0.13:3000/BTC";
//                        selectedURL="http://192.168.0.13:3000/ROLLING_180_BTC";
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_BTC";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=BTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                //Log.e("Crypto Ticker Response", response.toString());
                                int numOfDaysCrypto;
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();

                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;
            case "ETH": {
//                        selectedURL="http://192.168.0.13:3000/ROLLING_180_ETH";
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_ETH";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=ETHUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;
                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;
            case "BCH": {
//                        selectedURL="http://192.168.0.13:3000/ROLLING_180_BCH";
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_BCH";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=BCHUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;
            case "LTC": {
//                        selectedURL="http://192.168.0.13:3000/ROLLING_180_LTC";
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_LTC";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;
            case "BNB": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_BNB";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "ADA": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_ADA";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "DOGE": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_DOGE";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "XRP": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_XRP";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "DOT": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_DOT";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "UNI": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_UNI";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "SOL": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_SOL";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "LINK": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_LINK";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "MATIC": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_MATIC";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "ETC": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_ETC";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "HNT": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_HNT";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "THETA": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_THETA";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "VET": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_VET";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "XLM": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_XLM";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "ZEN": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_ZEN";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "FIL": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_FIL";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "ZIL": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_ZIL";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "WAVES": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_WAVES";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "EOS": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_EOS";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "AAVE": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_AAVE";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;

            case "ENJ": {
                selectedURL="https://btcbrunchapi.com/ROLLING_" + numOfDaysBtnSelected + "_ENJ";
                System.out.println(selectedURL);
                //selectedURL = "https://api.binance.com/api/v3/klines?symbol=LTCUSDT&interval=1d&limit=180";

                String finalSelectedURL = selectedURL;
                JsonArrayRequest objectRequest8 = new JsonArrayRequest(Request.Method.GET,
                        selectedURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int numOfDaysCrypto;

                                //Log.e("Crypto Ticker Response", response.toString());
                                BitCoinVsStocksActivity.cryptoValsInOnClick = tickerDataFunction(response);
                                numOfDaysCrypto = BitCoinVsStocksActivity.cryptoValsInOnClick.size();
                                ArrayList<Entry> commodityBitCoin = new ArrayList<>();
                                commoditySelector.selectCommodity(numOfDaysCrypto, stockSpinnerStrVal, BitCoinVsStocksActivity.cryptoValsInOnClick, commodityBitCoin, mpLineChart);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Log.e("Crypto Response Error", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest8);

            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + bitCoinSpinnerStrVal);
        }
    }

    private ArrayList<Candlestick> tickerDataFunction(JSONArray response) {

        //Clears the array every time so the old data doesn't get used in plotting the chart
        BitCoinVsStocksActivity.candlesticks.clear();

        //ArrayList<CandleEntry> candleVals = new ArrayList<>();
        try {

            for (int idx = 0; idx <= response.length() - 1; idx++) {
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
                BitCoinVsStocksActivity.candlesticks.add(candlestick);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return BitCoinVsStocksActivity.candlesticks;
    }
}
