package com.example.btcbrunch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    CardView stockBitCoinCard;
    CardView candleStickCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);

        stockBitCoinCard = findViewById(R.id.card_view_stock_bitcoin_selection);
        candleStickCard = findViewById(R.id.card_view_candle_stick_selection);

        //stockBitCoinCard's click listener to direct the user
        stockBitCoinCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stockBitCoinCardActivityIntent = new Intent(MainActivity.this, BitCoinVsStocksActivity.class);
                startActivity(stockBitCoinCardActivityIntent);
            }
        });

        //candleStickCard's click listener to direct the user
        candleStickCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent candleStickCardActivityIntent = new Intent(MainActivity.this, BitCoinCandleStickActivity.class);
                startActivity(candleStickCardActivityIntent);
            }
        });
    }

}//end of MainActivity