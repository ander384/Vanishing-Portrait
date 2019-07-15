package com.christine.vanishingportrait;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView currentPortrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentPortrait = findViewById(R.id.iv_current_portrait);
        setContentView(R.layout.activity_main);
    }

    public void onVanish(View view) {
        currentPortrait.setBackground(getDrawable(R.drawable.empty_portrait));
    }
}
