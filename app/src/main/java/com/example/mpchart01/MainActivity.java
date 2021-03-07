package com.example.mpchart01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    CardView stockBitCoinCard;
    CardView candleStickCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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