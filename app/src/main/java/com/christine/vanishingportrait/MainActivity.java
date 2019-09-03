package com.christine.vanishingportrait;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView inputDateTextView;
    private Button enterButton;
    private Button clearButton;
    ImageView currentPortrait;
    ImageView secretCode;
    MediaPlayer magicSound;

    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputDateTextView = findViewById(R.id.tv_input_date);
        this.enterButton = findViewById(R.id.btn_enter);
        this.clearButton = findViewById(R.id.btn_clear);

        //Forces the tablet to not auto-lock
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        currentPortrait = findViewById(R.id.iv_current_portrait);
        this.secretCode = findViewById(R.id.iv_secret_code);

        magicSound = MediaPlayer.create(this,R.raw.magicwand);

        this.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String number = inputDateTextView.getText().toString();
                if (Objects.equals(number, "EVANESCO")) {
                    if (count%2 == 1){
                        currentPortrait.setImageResource(R.drawable.empty_portrait);
                        ++count;
                        inputDateTextView.setText("");
                        secretCode.setVisibility(View.VISIBLE);
                        magicSound.start();
                    }
                    else{
                        currentPortrait.setImageResource(R.drawable.dumbledore_with_black_background);
                        ++count;
                        inputDateTextView.setText("");
                        secretCode.setVisibility(View.INVISIBLE);
                    }/*Intent myIntent = new Intent(ErrorScreen.this, ClueScreen.class);
                ErrorScreen.this.startActivity(myIntent);*/
                }
                else {
                    inputDateTextView.setTextColor(Color.parseColor("#ff0000"));
                    Animation anim = new AlphaAnimation(0.0f, 1.0f);
                    anim.setDuration(50); //You can manage the time of the blink with this parameter
                    anim.setStartOffset(20);
                    anim.setRepeatCount(5);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            inputDateTextView.setText("");
                            inputDateTextView.setTextColor(Color.parseColor("#ffffff"));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    inputDateTextView.startAnimation(anim);

                }
            }
        });

        this.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDateTextView.setText("");
            }
        });


    }

    public void onVanish(View view) {
        String currentText = inputDateTextView.getText().toString();
        //Will only concatenate the next number if less than 4 numbers have been entered
        if (currentText.length()<10)
        {
            Button button = (Button) view;
            String number = button.getText().toString();
            currentText = currentText + number;
            inputDateTextView.setText(currentText);
        }
        else
        {
            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(50); //You can manage the time of the blink with this parameter
            anim.setStartOffset(20);
            anim.setRepeatCount(2);
            inputDateTextView.startAnimation(anim);
        }
    }
}
