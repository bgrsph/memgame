package com.example.bugrasipahioglu.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);
        TextView tv = (TextView) findViewById(R.id.textView2);
        Intent i = getIntent();
        String name = i.getStringExtra("message");
        int score = i.getIntExtra("score", 0);
        tv.setText("Congrats " + name + ", You Win with " + score + " Points!!");


    }
}
