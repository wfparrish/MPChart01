package com.btcbrunch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;

import com.btcbrunch.R;


public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;

    CardView stockBitCoinCard;
//    CardView candleStickCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent stockBitCoinCardActivityIntent = new Intent(MainActivity.this, BitCoinVsStocksActivity.class);
                startActivity(stockBitCoinCardActivityIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

//        stockBitCoinCard = findViewById(R.id.card_view_stock_bitcoin_selection);
//        candleStickCard = findViewById(R.id.card_view_candle_stick_selection);

        //stockBitCoinCard's click listener to direct the user
//        stockBitCoinCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent stockBitCoinCardActivityIntent = new Intent(MainActivity.this, BitCoinVsStocksActivity.class);
//                startActivity(stockBitCoinCardActivityIntent);
//            }
//        });

        //candleStickCard's click listener to direct the user
//        candleStickCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent candleStickCardActivityIntent = new Intent(MainActivity.this, BitCoinCandleStickActivity.class);
//                startActivity(candleStickCardActivityIntent);
//            }
//        });
    }

}//end of MainActivity