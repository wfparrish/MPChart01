package com.btcbrunch;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.btcbrunch.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


import java.time.LocalDate;
import java.util.ArrayList;

public class BitCoinVsStocksActivity extends AppCompatActivity implements View.OnClickListener {


    LineChart mpLineChart;
    //Button bitCoinApiButton0;
    private double[] bitCoinData;
    //private JSONObject[] cornData;
    private JSONObject[] cornDataObj;
    private JSONObject[] appleDataObj;
    private JSONObject[] soybDataObj;
    private JSONObject[] sugarDataObj;
    private JSONObject[] amazonDataObj;
    private JSONObject[] boeingDataObj;
    private JSONObject[] bloombergCottonDataObj;
    private JSONObject[] invescoDbOilDataObj;
    private JSONObject[] duPontDataObj;
    private JSONObject[] consolidatedEdisonDataObj;
    private JSONObject[] vanEckVectorsGoldMinersDataObj;
    private JSONObject[] alphabetDataObj;
    private JSONObject[] nyseDataObj;
    private JSONObject[] sAndP500DataObj;
    private JSONObject[] sAndP500GrowthDataObj;
    private JSONObject[] uSEnergyDataObj;
    private JSONObject[] teucriumGrainDataObj;
    private JSONObject[] bloombergCoffeeDataObj;
    private JSONObject[] jPMorganChaseDataObj;
    private JSONObject[] cocaColaDataObj;
    private JSONObject[] microsoftDataObj;
    private JSONObject[] nasdaqDataObj;
    private JSONObject[] globalXSilverMinersDataObj;
    private JSONObject[] vanEckVectorsSteelDataObj;
    private JSONObject[] unitedHealthGroupDataObj;
    private JSONObject[] exxonMobilDataObj;

    ArrayList<Entry> dataVals;
    ArrayList<Entry> cornVals;
    ArrayList<Entry> appleVals;
    ArrayList<Entry> soybVals;
    ArrayList<Entry> sugarVals;
    ArrayList<Entry> amazonVals;
    ArrayList<Entry> boeingVals;
    ArrayList<Entry> bloombergCottonVals;
    ArrayList<Entry> invescoDbOilVals;
    ArrayList<Entry> duPontVals;
    ArrayList<Entry> consolidatedEdisonVals;
    ArrayList<Entry> vanEckVectorsGoldMinersVals;
    ArrayList<Entry> alphabetVals;
    ArrayList<Entry> nyseVals;
    ArrayList<Entry> sAndP500Vals;
    ArrayList<Entry> sAndP500GrowthVals;
    ArrayList<Entry> uSEnergyVals;
    ArrayList<Entry> teucriumGrainVals;
    ArrayList<Entry> bloombergCoffeeVals;
    ArrayList<Entry> jPMorganChaseVals;
    ArrayList<Entry> cocaColaVals;
    ArrayList<Entry> microsoftVals;
    ArrayList<Entry> nasdaqVals;
    ArrayList<Entry> globalXSilverMinersVals;
    ArrayList<Entry> vanEckVectorsSteelVals;
    ArrayList<Entry> unitedHealthGroupVals;
    ArrayList<Entry> exxonMobilVals;

    ArrayList<Candlestick> cryptoVals = new ArrayList<Candlestick>();
    static ArrayList<Candlestick> cryptoValsInOnClick = new ArrayList<Candlestick>();
    int numOfDaysCrypto;
    ChartMaker chartMaker;
    CommoditySelector commoditySelector;
    CryptoSelector cryptoSelector;


    static ArrayList<Candlestick> candlesticks = new ArrayList<Candlestick>();
    Button sevenDay;
    Button fourteenDay;
    Button thirtyDay;
    Button ninetyDay;
    Button oneHundredEightyDay;
    Button threeHundredSixtyFiveDay;
    Spinner stockSpinner;
    Spinner bitCoinSpinner;
    RequestQueue requestQueue;
    String URL1;
    String URL2;
    String URL3;
    String URL4;
    String URL5;
    String URL6;
    String URL7;
    String URL8;
    String URL9;
    String URL10;
    String URL11;
    String URL12;
    String URL13;
    String URL14;
    String URL15;
    String URL16;
    String URL17;
    String URL18;
    String URL19;
    String URL20;
    String URL21;
    String URL22;
    String URL23;
    String URL24;
    String URL25;
    String URL26;
    String URL27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_coin_vs_stocks);

        stockSpinner = findViewById(R.id.stock_spinner);
        ArrayAdapter<String> stockSpinnerAdapter = new ArrayAdapter<String>(BitCoinVsStocksActivity.this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.stock_tickers));
        stockSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stockSpinner.setAdapter(stockSpinnerAdapter);

        bitCoinSpinner = findViewById(R.id.bitcoin_spinner);
        ArrayAdapter<String> bitCoinSpinnerAdapter = new ArrayAdapter<String>(BitCoinVsStocksActivity.this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.bitcoin_tickers));
        bitCoinSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bitCoinSpinner.setAdapter(bitCoinSpinnerAdapter);

        sevenDay = (Button) findViewById(R.id.bitcoin_api_button0);
        fourteenDay = (Button) findViewById(R.id.bitcoin_api_button1);
        thirtyDay = (Button) findViewById(R.id.bitcoin_api_button2);
        ninetyDay = (Button) findViewById(R.id.bitcoin_api_button3);
        oneHundredEightyDay = (Button) findViewById(R.id.bitcoin_api_button4);
        threeHundredSixtyFiveDay = (Button) findViewById(R.id.bitcoin_api_button5);

        sevenDay.setOnClickListener(this);
        fourteenDay.setOnClickListener(this);
        thirtyDay.setOnClickListener(this);
        ninetyDay.setOnClickListener(this);
        oneHundredEightyDay.setOnClickListener(this);
        threeHundredSixtyFiveDay.setOnClickListener(this);


//        btcbrunchapi.com/ calls for production
//        String URL1="https://btcbrunchapi.com/bpi";
//        String URL2="https://btcbrunchapi.com/CORN";
//        String URL3="https://btcbrunchapi.com/AAPL";
//        String URL4="https://btcbrunchapi.com/SOYB";
//        String URL5="https://btcbrunchapi.com/CANE";


        URL1="https://btcbrunchapi.com/ROLLING_365_BTC";
        URL2="https://btcbrunchapi.com/ROLLING_365_CORN";
        URL3="https://btcbrunchapi.com/ROLLING_365_AAPL";
        URL4="https://btcbrunchapi.com/ROLLING_365_SOYB";
        URL5="https://btcbrunchapi.com/ROLLING_365_CANE";
        URL6="https://btcbrunchapi.com/ROLLING_365_AMZN";
        URL7="https://btcbrunchapi.com/ROLLING_365_BA";
        URL8="https://btcbrunchapi.com/ROLLING_365_BAL";
        URL9="https://btcbrunchapi.com/ROLLING_365_DBO";
        URL10="https://btcbrunchapi.com/ROLLING_365_DD";
        URL11="https://btcbrunchapi.com/ROLLING_365_ED";
        URL12="https://btcbrunchapi.com/ROLLING_365_GDX";
        URL13="https://btcbrunchapi.com/ROLLING_365_GOOG";
        URL14="https://btcbrunchapi.com/ROLLING_365_ICE";
        URL15="https://btcbrunchapi.com/ROLLING_365_IVV";
        URL16="https://btcbrunchapi.com/ROLLING_365_IVW";
        URL17="https://btcbrunchapi.com/ROLLING_365_IYE";
        URL18="https://btcbrunchapi.com/ROLLING_365_JJG";
        URL19="https://btcbrunchapi.com/ROLLING_365_JO";
        URL20="https://btcbrunchapi.com/ROLLING_365_JPM";
        URL21="https://btcbrunchapi.com/ROLLING_365_KO";
        URL22="https://btcbrunchapi.com/ROLLING_365_MSFT";
        URL23="https://btcbrunchapi.com/ROLLING_365_NDAQ";
        URL24="https://btcbrunchapi.com/ROLLING_365_SIL";
        URL25="https://btcbrunchapi.com/ROLLING_365_SLX";
        URL26="https://btcbrunchapi.com/ROLLING_365_UNH";
        URL27="https://btcbrunchapi.com/ROLLING_365_XOM";

//        URL1="https://btcbrunchapi.com/ROLLING_7_BTC";
//        URL2="https://btcbrunchapi.com/ROLLING_7_CORN";
//        URL3="https://btcbrunchapi.com/ROLLING_7_AAPL";
//        URL4="https://btcbrunchapi.com/ROLLING_7_SOYB";
//        URL5="https://btcbrunchapi.com/ROLLING_7_CANE";


//      localhost:3000 API calls for development. Uses the Desktop's IP address for the wifi NIC

//        URL1="http://192.168.0.13:3000/ROLLING_365_BTC";
//        URL2="http://192.168.0.13:3000/ROLLING_365_CORN";
//        URL3="http://192.168.0.13:3000/ROLLING_365_AAPL";
//        URL4="http://192.168.0.13:3000/ROLLING_365_SOYB";
//        URL5="http://192.168.0.13:3000/ROLLING_365_CANE";

        //Creating the instance of the CommoditySelector object
        commoditySelector = new CommoditySelector();

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest objectRequest1 = new JsonArrayRequest(Request.Method.GET,
                URL1,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.e("Bitcoin Response", response.toString());
                        System.out.println("BTC RESPONSE:" + response);
                        dataVals = bitcoinDataFunction(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
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
                        System.out.println("These are the cornVals you are looking for: " + cornVals);
                        commoditySelector.setCornVals(cornDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest3 = new JsonObjectRequest(Request.Method.GET,
                URL3,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Apple stock Response", response.toString());
                        appleVals =  appleDataFunction(response);
                        commoditySelector.setAppleVals(appleDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
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
                        commoditySelector.setSoybVals(soybDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
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
                        commoditySelector.setSugarVals(sugarDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );


        JsonObjectRequest objectRequest6 = new JsonObjectRequest(Request.Method.GET,
                URL6,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("amazon stock Response", response.toString());
                        amazonVals =  amazonDataFunction(response);
                        commoditySelector.setAmazonVals(amazonDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest7 = new JsonObjectRequest(Request.Method.GET,
                URL7,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("boeing stock Response", response.toString());
                        boeingVals =  boeingDataFunction(response);
                        commoditySelector.setBoeingVals(boeingDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest8 = new JsonObjectRequest(Request.Method.GET,
                URL8,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("bloombergCotton stock Response", response.toString());
                        bloombergCottonVals =  bloombergCottonDataFunction(response);
                        commoditySelector.setBloombergCottonVals(bloombergCottonDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest9 = new JsonObjectRequest(Request.Method.GET,
                URL9,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("invescoDbOil stock Response", response.toString());
                        invescoDbOilVals =  invescoDbOilDataFunction(response);
                        commoditySelector.setInvescoDbOilVals(invescoDbOilDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest10 = new JsonObjectRequest(Request.Method.GET,
                URL10,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("duPont stock Response", response.toString());
                        duPontVals =  duPontDataFunction(response);
                        commoditySelector.setDuPontVals(duPontDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest11 = new JsonObjectRequest(Request.Method.GET,
                URL11,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("consolidatedEdison stock Response", response.toString());
                        consolidatedEdisonVals =  consolidatedEdisonDataFunction(response);
                        commoditySelector.setConsolidatedEdisonVals(consolidatedEdisonDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest12 = new JsonObjectRequest(Request.Method.GET,
                URL12,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("vanEckVectorsGoldMiners stock Response", response.toString());
                        vanEckVectorsGoldMinersVals =  vanEckVectorsGoldMinersDataFunction(response);
                        commoditySelector.setVanEckVectorsGoldMinersVals(vanEckVectorsGoldMinersDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest13 = new JsonObjectRequest(Request.Method.GET,
                URL13,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("alphabet stock Response", response.toString());
                        alphabetVals =  alphabetDataFunction(response);
                        commoditySelector.setAlphabetVals(alphabetDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest14 = new JsonObjectRequest(Request.Method.GET,
                URL14,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("nyse stock Response", response.toString());
                        nyseVals =  nyseDataFunction(response);
                        commoditySelector.setNyseVals(nyseDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest15 = new JsonObjectRequest(Request.Method.GET,
                URL15,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("sAndP500 stock Response", response.toString());
                        sAndP500Vals =  sAndP500DataFunction(response);
                        commoditySelector.setsAndP500Vals(sAndP500DataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest16 = new JsonObjectRequest(Request.Method.GET,
                URL16,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("sAndP500Growth stock Response", response.toString());
                        sAndP500GrowthVals =  sAndP500GrowthDataFunction(response);
                        commoditySelector.setsAndP500GrowthVals(sAndP500GrowthDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest17 = new JsonObjectRequest(Request.Method.GET,
                URL17,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("uSEnergy stock Response", response.toString());
                        uSEnergyVals =  uSEnergyDataFunction(response);
                        commoditySelector.setuSEnergyVals(uSEnergyDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );


        JsonObjectRequest objectRequest18 = new JsonObjectRequest(Request.Method.GET,
                URL18,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("teucriumGrain stock Response", response.toString());
                        teucriumGrainVals =  teucriumGrainDataFunction(response);
                        commoditySelector.setTeucriumGrainVals(teucriumGrainDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest19 = new JsonObjectRequest(Request.Method.GET,
                URL19,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("bloombergCoffee stock Response", response.toString());
                        bloombergCoffeeVals =  bloombergCoffeeDataFunction(response);
                        commoditySelector.setBloombergCoffeeVals(bloombergCoffeeDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest20 = new JsonObjectRequest(Request.Method.GET,
                URL20,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("jPMorganChase stock Response", response.toString());
                        jPMorganChaseVals =  jPMorganChaseDataFunction(response);
                        commoditySelector.setjPMorganChaseVals(jPMorganChaseDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest21 = new JsonObjectRequest(Request.Method.GET,
                URL21,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("cocaCola stock Response", response.toString());
                        cocaColaVals =  cocaColaDataFunction(response);
                        commoditySelector.setCocaColaVals(cocaColaDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest22 = new JsonObjectRequest(Request.Method.GET,
                URL22,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("microsoft stock Response", response.toString());
                        microsoftVals =  microsoftDataFunction(response);
                        commoditySelector.setMicrosoftVals(microsoftDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest23 = new JsonObjectRequest(Request.Method.GET,
                URL23,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("nasdaq stock Response", response.toString());
                        nasdaqVals =  nasdaqDataFunction(response);
                        commoditySelector.setNasdaqVals(nasdaqDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest24 = new JsonObjectRequest(Request.Method.GET,
                URL24,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("globalXSilverMiners stock Response", response.toString());
                        globalXSilverMinersVals =  globalXSilverMinersDataFunction(response);
                        commoditySelector.setGlobalXSilverMinersVals(globalXSilverMinersDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest25 = new JsonObjectRequest(Request.Method.GET,
                URL25,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("vanEckVectorsSteel stock Response", response.toString());
                        vanEckVectorsSteelVals =  vanEckVectorsSteelDataFunction(response);
                        commoditySelector.setVanEckVectorsSteelVals(vanEckVectorsSteelDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest26 = new JsonObjectRequest(Request.Method.GET,
                URL26,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("unitedHealthGroup stock Response", response.toString());
                        unitedHealthGroupVals =  unitedHealthGroupDataFunction(response);
                        commoditySelector.setUnitedHealthGroupVals(unitedHealthGroupDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );

        JsonObjectRequest objectRequest27 = new JsonObjectRequest(Request.Method.GET,
                URL27,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("exxonMobil stock Response", response.toString());
                        exxonMobilVals =  exxonMobilDataFunction(response);
                        commoditySelector.setExxonMobilVals(exxonMobilDataFunction(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.e("Rest Response", error.toString());
                    }
                }
        );


        requestQueue.add(objectRequest1);
        requestQueue.add(objectRequest2);
        requestQueue.add(objectRequest3);
        requestQueue.add(objectRequest4);
        requestQueue.add(objectRequest5);
        requestQueue.add(objectRequest6);
        requestQueue.add(objectRequest7);
        requestQueue.add(objectRequest8);
        requestQueue.add(objectRequest9);
        requestQueue.add(objectRequest10);
        requestQueue.add(objectRequest11);
        requestQueue.add(objectRequest12);
        requestQueue.add(objectRequest13);
        requestQueue.add(objectRequest14);
        requestQueue.add(objectRequest15);
        requestQueue.add(objectRequest16);
        requestQueue.add(objectRequest17);
        requestQueue.add(objectRequest18);
        requestQueue.add(objectRequest19);
        requestQueue.add(objectRequest20);
        requestQueue.add(objectRequest21);
        requestQueue.add(objectRequest22);
        requestQueue.add(objectRequest23);
        requestQueue.add(objectRequest24);
        requestQueue.add(objectRequest25);
        requestQueue.add(objectRequest26);
        requestQueue.add(objectRequest27);

        //Links the line chart XML to the java code
        mpLineChart = findViewById(R.id.line_chart);

        //Add the CommoditySelector here, before the end of onCreate()
//        CommoditySelector commoditySelector = new CommoditySelector(cornVals,
//                appleVals, soybVals, sugarVals, amazonVals, boeingVals, bloombergCottonVals, invescoDbOilVals, duPontVals, consolidatedEdisonVals,
//                vanEckVectorsGoldMinersVals, alphabetVals, nyseVals, sAndP500Vals, sAndP500GrowthVals, uSEnergyVals, teucriumGrainVals,
//                bloombergCoffeeVals, jPMorganChaseVals, cocaColaVals, microsoftVals, nasdaqVals,
//                globalXSilverMinersVals, vanEckVectorsSteelVals, unitedHealthGroupVals, exxonMobilVals);

        }//end of onCreate()


    //I moved this method into the CryptoSelector class, I may not need it here anymore
//    private ArrayList<Candlestick> tickerDataFunction(JSONArray response) {
//
//        //Clears the array every time so the old data doesn't get used in plotting the chart
//        candlesticks.clear();
//
//        //ArrayList<CandleEntry> candleVals = new ArrayList<>();
//        try {
//
//            for (int idx = 0; idx <= response.length() - 1; idx++) {
//                JSONArray candlestickData = response.getJSONArray(idx);
//                long data0 = (long) candlestickData.get(0);
//                String data1 = (String) candlestickData.get(1);
//                String data2 = (String) candlestickData.get(2);
//                String data3 = (String) candlestickData.get(3);
//                String data4 = (String) candlestickData.get(4);
//
//                long convertedData0 = data0;
//                float convertedData1 = Float.parseFloat(data1);
//                float convertedData2 = Float.parseFloat(data2);
//                float convertedData3 = Float.parseFloat(data3);
//                float convertedData4 = Float.parseFloat(data4);
//
//
//                Candlestick candlestick = new Candlestick(convertedData0, convertedData1, convertedData2, convertedData3, convertedData4);
//                candlesticks.add(candlestick);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return candlesticks;
//    }



    private ArrayList<Entry> bitcoinDataFunction(JSONArray response) {
        //System.out.println("Bitcoin API data starting here: ");
        System.out.println("BTC ARRAY: " + response.toString());
        ArrayList<Entry> dataVals = new ArrayList<>();
        try {
            for (int i = 0; i <= response.length() - 1; i++ ) {
                bitCoinData = new double[] {(double) Double.parseDouble((String) response.getJSONArray(i).get(1))};
                dataVals.add(new Entry(i, (float) bitCoinData[0]));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dataVals;
    }

    private ArrayList<Entry> cornDataFunction(JSONObject response) {
        //System.out.println("Corn API data starting here: ");
        //System.out.println(response);
        ArrayList<Entry> cornVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                //cornDataArrayList.add(i, response.getJSONArray("data").getJSONObject(i));
                cornDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double coData = cornDataObj[0].getDouble("open");
                cornVals.add(new Entry(i, (float) coData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cornVals;
    }

    private ArrayList<Entry> appleDataFunction(JSONObject response) {
        //System.out.println("Apple API data starting here: ");
        //System.out.println(response.toString());
        ArrayList<Entry> appleVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                //appleDataArrayList.add(i, response.getJSONArray("data").getJSONObject(i));
                appleDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double whData = appleDataObj[0].getDouble("open");
                appleVals.add(new Entry(i, (float) whData));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return appleVals;
    }

    private ArrayList<Entry> soybDataFunction(JSONObject response) {
        //System.out.println("Soy Bean API data starting here: ");
        //System.out.println(response.toString());
        ArrayList<Entry> soybVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                //soybDataArrayList.add(i, response.getJSONArray("data").getJSONObject(i));
                soybDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double sbData = soybDataObj[0].getDouble("open");
                soybVals.add(new Entry(i, (float) sbData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return soybVals;
    }


    private ArrayList<Entry> sugarDataFunction(JSONObject response) {
        //System.out.println("Sugar API data starting here: ");
        //System.out.println(response.toString());
        ArrayList<Entry> sugarVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                //sugarDataArrayList.add(i, response.getJSONArray("data").getJSONObject(i));
                sugarDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double sgData = sugarDataObj[0].getDouble("open");
                sugarVals.add(new Entry(i, (float) sgData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sugarVals;
    }

    private ArrayList<Entry> amazonDataFunction(JSONObject response) {
        ArrayList<Entry> amazonVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                amazonDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double amznData = amazonDataObj[0].getDouble("open");
                amazonVals.add(new Entry(i, (float) amznData));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return amazonVals;
    }

    private ArrayList<Entry> boeingDataFunction(JSONObject response) {
        ArrayList<Entry> boeingVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                boeingDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double bgData = boeingDataObj[0].getDouble("open");
                boeingVals.add(new Entry(i, (float) bgData));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return boeingVals;
    }

    private ArrayList<Entry> bloombergCottonDataFunction(JSONObject response) {
        ArrayList<Entry> bloombergCottonVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                bloombergCottonDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double bbcData = bloombergCottonDataObj[0].getDouble("open");
                bloombergCottonVals.add(new Entry(i, (float) bbcData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bloombergCottonVals;
    }

    private ArrayList<Entry> invescoDbOilDataFunction(JSONObject response) {
        ArrayList<Entry> invescoDbOilVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                invescoDbOilDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double idboData = invescoDbOilDataObj[0].getDouble("open");
                invescoDbOilVals.add(new Entry(i, (float) idboData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return invescoDbOilVals;
    }

    private ArrayList<Entry> duPontDataFunction(JSONObject response) {
        ArrayList<Entry> duPontVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                duPontDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double dpData = duPontDataObj[0].getDouble("open");
                duPontVals.add(new Entry(i, (float) dpData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return duPontVals;
    }

    private ArrayList<Entry> consolidatedEdisonDataFunction(JSONObject response) {
        ArrayList<Entry> consolidatedEdisonVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                consolidatedEdisonDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double ceData = consolidatedEdisonDataObj[0].getDouble("open");
                consolidatedEdisonVals.add(new Entry(i, (float) ceData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return consolidatedEdisonVals;
    }

    private ArrayList<Entry> vanEckVectorsGoldMinersDataFunction(JSONObject response) {
        ArrayList<Entry> vanEckVectorsGoldMinersVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                vanEckVectorsGoldMinersDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double vvgmData = vanEckVectorsGoldMinersDataObj[0].getDouble("open");
                vanEckVectorsGoldMinersVals.add(new Entry(i, (float) vvgmData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return vanEckVectorsGoldMinersVals;
    }

    private ArrayList<Entry> alphabetDataFunction(JSONObject response) {
        ArrayList<Entry> alphabetVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                alphabetDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double alphaData = alphabetDataObj[0].getDouble("open");
                alphabetVals.add(new Entry(i, (float) alphaData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return alphabetVals;
    }

    private ArrayList<Entry> nyseDataFunction(JSONObject response) {
        ArrayList<Entry> nyseVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                nyseDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double nyseData = nyseDataObj[0].getDouble("open");
                nyseVals.add(new Entry(i, (float) nyseData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return nyseVals;
    }

    private ArrayList<Entry> sAndP500DataFunction(JSONObject response) {
        ArrayList<Entry> sAndP500Vals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                sAndP500DataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double sandp500Data = sAndP500DataObj[0].getDouble("open");
                sAndP500Vals.add(new Entry(i, (float) sandp500Data));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sAndP500Vals;
    }

    private ArrayList<Entry> sAndP500GrowthDataFunction(JSONObject response) {
        ArrayList<Entry> sAndP500GrowthVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                sAndP500GrowthDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double sandp500GrData = sAndP500GrowthDataObj[0].getDouble("open");
                sAndP500GrowthVals.add(new Entry(i, (float) sandp500GrData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sAndP500GrowthVals;
    }

    private ArrayList<Entry> uSEnergyDataFunction(JSONObject response) {
        ArrayList<Entry> uSEnergyVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                uSEnergyDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double usegyData = uSEnergyDataObj[0].getDouble("open");
                uSEnergyVals.add(new Entry(i, (float) usegyData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return uSEnergyVals;
    }


    private ArrayList<Entry> teucriumGrainDataFunction(JSONObject response) {
        ArrayList<Entry> teucriumGrainVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                teucriumGrainDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double tgData = teucriumGrainDataObj[0].getDouble("open");
                teucriumGrainVals.add(new Entry(i, (float) tgData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return teucriumGrainVals;
    }

    private ArrayList<Entry> bloombergCoffeeDataFunction(JSONObject response) {
        ArrayList<Entry> bloombergCoffeeVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                bloombergCoffeeDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double bbcffData = bloombergCoffeeDataObj[0].getDouble("open");
                bloombergCoffeeVals.add(new Entry(i, (float) bbcffData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bloombergCoffeeVals;
    }

    private ArrayList<Entry> jPMorganChaseDataFunction(JSONObject response) {
        ArrayList<Entry> jPMorganChaseVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                jPMorganChaseDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double jpmData = jPMorganChaseDataObj[0].getDouble("open");
                jPMorganChaseVals.add(new Entry(i, (float) jpmData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jPMorganChaseVals;
    }

    private ArrayList<Entry> cocaColaDataFunction(JSONObject response) {
        ArrayList<Entry> cocaColaVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                cocaColaDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double ccData = cocaColaDataObj[0].getDouble("open");
                cocaColaVals.add(new Entry(i, (float) ccData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cocaColaVals;
    }

    private ArrayList<Entry> microsoftDataFunction(JSONObject response) {
        ArrayList<Entry> microsoftVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                microsoftDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double msftData = microsoftDataObj[0].getDouble("open");
                microsoftVals.add(new Entry(i, (float) msftData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return microsoftVals;
    }

    private ArrayList<Entry> nasdaqDataFunction(JSONObject response) {
        ArrayList<Entry> nasdaqVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                nasdaqDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double nsdqData = nasdaqDataObj[0].getDouble("open");
                nasdaqVals.add(new Entry(i, (float) nsdqData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return nasdaqVals;
    }

    private ArrayList<Entry> globalXSilverMinersDataFunction(JSONObject response) {
        ArrayList<Entry> globalXSilverMinersVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                globalXSilverMinersDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double gxsmData = globalXSilverMinersDataObj[0].getDouble("open");
                globalXSilverMinersVals.add(new Entry(i, (float) gxsmData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return globalXSilverMinersVals;
    }

    private ArrayList<Entry> vanEckVectorsSteelDataFunction(JSONObject response) {
        ArrayList<Entry> vanEckVectorsSteelVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                vanEckVectorsSteelDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double vvsData = vanEckVectorsSteelDataObj[0].getDouble("open");
                vanEckVectorsSteelVals.add(new Entry(i, (float) vvsData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return vanEckVectorsSteelVals;
    }

    private ArrayList<Entry> unitedHealthGroupDataFunction(JSONObject response) {
        ArrayList<Entry> unitedHealthGroupVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                unitedHealthGroupDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double uhgData = unitedHealthGroupDataObj[0].getDouble("open");
                unitedHealthGroupVals.add(new Entry(i, (float) uhgData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return unitedHealthGroupVals;
    }

    private ArrayList<Entry> exxonMobilDataFunction(JSONObject response) {
        ArrayList<Entry> exxonMobilVals = new ArrayList<>();
        try {
            for (int i = 0; i < response.getJSONArray("data").length(); i++) {
                exxonMobilDataObj = new JSONObject[] {response.getJSONArray("data").getJSONObject(i)};
                double exxmData = exxonMobilDataObj[0].getDouble("open");
                exxonMobilVals.add(new Entry(i, (float) exxmData));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return exxonMobilVals;
    }


    @Override
    public void onClick(View v) {

        stockSpinner = findViewById(R.id.stock_spinner);
        bitCoinSpinner = findViewById(R.id.bitcoin_spinner);
        String stockSpinnerStrVal = stockSpinner.getSelectedItem().toString();
        String bitCoinSpinnerStrVal = bitCoinSpinner.getSelectedItem().toString();

        mpLineChart = findViewById(R.id.line_chart);


        //String selectedURL = null;

        switch (v.getId()) {
            case R.id.bitcoin_api_button0:
                int numOfDaysBtn0 = 7;
                System.out.println(sevenDay);
                System.out.println(stockSpinnerStrVal + " + " + bitCoinSpinnerStrVal);
                cryptoSelector = new CryptoSelector();
                cryptoSelector.selectCrypto(stockSpinnerStrVal, bitCoinSpinnerStrVal, numOfDaysBtn0, requestQueue, mpLineChart, commoditySelector);

                break;

            case R.id.bitcoin_api_button1:
                int numOfDaysBtn1 = 14;
                System.out.println(fourteenDay);
                System.out.println(stockSpinnerStrVal + " + " + bitCoinSpinnerStrVal);
                cryptoSelector = new CryptoSelector();
                cryptoSelector.selectCrypto(stockSpinnerStrVal, bitCoinSpinnerStrVal, numOfDaysBtn1, requestQueue, mpLineChart, commoditySelector);
                break;

            case R.id.bitcoin_api_button2:
                int numOfDaysBtn2 = 30;
                System.out.println(thirtyDay);
                System.out.println(stockSpinnerStrVal + " + " + bitCoinSpinnerStrVal);
                cryptoSelector = new CryptoSelector();
                cryptoSelector.selectCrypto(stockSpinnerStrVal, bitCoinSpinnerStrVal, numOfDaysBtn2, requestQueue, mpLineChart, commoditySelector);
                break;

            case R.id.bitcoin_api_button3:
                int numOfDaysBtn3 = 90;
                System.out.println(ninetyDay);
                System.out.println(stockSpinnerStrVal + " + " + bitCoinSpinnerStrVal);
                cryptoSelector = new CryptoSelector();
                cryptoSelector.selectCrypto(stockSpinnerStrVal, bitCoinSpinnerStrVal, numOfDaysBtn3, requestQueue, mpLineChart, commoditySelector);
                break;

            case R.id.bitcoin_api_button4:
                int numOfDaysBtn4 = 180;
                System.out.println(oneHundredEightyDay);
                System.out.println(stockSpinnerStrVal + " + " + bitCoinSpinnerStrVal);
                cryptoSelector = new CryptoSelector();
                cryptoSelector.selectCrypto(stockSpinnerStrVal, bitCoinSpinnerStrVal, numOfDaysBtn4, requestQueue, mpLineChart, commoditySelector);
                break;

            case R.id.bitcoin_api_button5:
                int numOfDaysBtn5 = 365;
                System.out.println(threeHundredSixtyFiveDay);
                System.out.println(stockSpinnerStrVal + " + " + bitCoinSpinnerStrVal);
                cryptoSelector = new CryptoSelector();
                cryptoSelector.selectCrypto(stockSpinnerStrVal, bitCoinSpinnerStrVal, numOfDaysBtn5, requestQueue, mpLineChart, commoditySelector);
                break;

            default:
                break;
        }



    }


}