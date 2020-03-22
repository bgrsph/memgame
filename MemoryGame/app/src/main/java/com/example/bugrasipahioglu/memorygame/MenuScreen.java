package com.example.bugrasipahioglu.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MenuScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        final EditText nameET = (EditText) findViewById(R.id.editText);



        //In order to switch pages with a button;

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MenuScreen.this,GameScreen.class);
                i.putExtra("message", nameET.getText().toString());
                startActivity(i);
            }
        });











    }

}


