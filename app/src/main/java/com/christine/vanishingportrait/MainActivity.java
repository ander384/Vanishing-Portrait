package com.christine.vanishingportrait;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView currentPortrait;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentPortrait = findViewById(R.id.iv_current_portrait);
    }

    public void onVanish(View view) {
        if (count%2 == 1){
            currentPortrait.setImageResource(R.drawable.empty_portrait);
            ++count;
        }
        else{
            currentPortrait.setImageResource(R.drawable.dumbledore_with_black_background);
            ++count;
        }
    }
}
