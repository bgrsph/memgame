package com.example.bugrasipahioglu.memorygame;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    int lastCard = 0;
    int score = 0;
    int error = 0;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);


        Intent i = getIntent();
        final String name = i.getStringExtra("message");

        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("Hello " + name);


        GridLayout gl = (GridLayout) findViewById(R.id.cards);
        Card cards[] = new Card[16];
        for(int j = 1; j<=16; j++) {

            cards[j-1] = new Card(this, j);
            cards[j-1].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    final Card k = (Card) v;
                    k.turnTheCard();
                    if (lastCard > 0){

                        final Card k2 = (Card) findViewById(lastCard);


                        if (k2.ongroundID == k.ongroundID && k2.getId() != k.getId()){

                            //match!
                            k2.isTurnable = false;
                            k.isTurnable = false;
                            score ++;
                            TextView tv = (TextView) findViewById(R.id.scoreTV);
                            tv.setText("Your Score :" + score);


                            if(score == 8){
                                //Game over
                                Intent i = new Intent(GameScreen.this, ScoreScreen.class);
                                i.putExtra("score",error);
                                i.putExtra("name", name);
                                startActivity(i);

                            }
                        }
                        else{
                            //not a match, return two cards
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.turnTheCard();
                                    k2.turnTheCard();

                                }
                            },500);
                            error ++;
                            TextView tv = (TextView) findViewById(R.id.errorTV);
                            tv.setText("Errors :" + error);

                            lastCard = 0;
                        }
                    }
                    else {
                        lastCard = k.getId();
                    }
                }
            });
        }

        //Randomly swap
        for (int j = 0; j<16; j ++){
            int randomCardNumber = (int) (Math.random()*16);

            Card k = cards[randomCardNumber];
            cards[randomCardNumber] = cards[j];
            cards[j] = k;

        }


        for(int j = 0; j<16; j++) {

            gl.addView(cards[j]);
        }


    }
}
