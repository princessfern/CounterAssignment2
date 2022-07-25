package com.example.counterassignment2;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity<x> extends AppCompatActivity {
    int counter;
    boolean timer_not_expired = false;
    TextView myText;
    TextView myTimer;
    int clicks = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                myTimer = findViewById(R.id.timer);
                myTimer.setText(Long.toString(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                myTimer = findViewById(R.id.timer);
                myTimer.setText("Timer Expired");
                timer_not_expired = true;
                Toast.makeText(MainActivity.this, "Increase/Decrease clicked "+clicks+" # of times", Toast.LENGTH_SHORT).show();

            }
        }.start();

    }

    // For the counter.
    public void button_1_passed(View view) {
        if (!timer_not_expired) {
            counter ++;
            clicks++;
            myText = findViewById(R.id.counter);
            myText.setText("Counter:" + counter);

        }

    }


    public void button_2_passed(View view) {
        if (!timer_not_expired) {
            counter = counter - 1;
            clicks++;
            myText = findViewById(R.id.counter);
            myText.setText("Counter:" + counter);
        }
    }
}
