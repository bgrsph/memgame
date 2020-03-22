package com.example.bugrasipahioglu.memorygame;


/**
 * Created by bugrasipahioglu on 18.01.2018.
 */


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Button;
import android.support.v7.widget.AppCompatDrawableManager;





public class Card extends android.support.v7.widget.AppCompatButton{

    boolean isOpen = false;
    boolean isTurnable = true;
    int pictureId;
    int backgroundID;
    int ongroundID = 0;
    Drawable front;
    Drawable back;

    @SuppressLint("RestrictedApi")
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public Card(Context context, int id) {
        super(context);

        setId(id);
        backgroundID = R.drawable.back2;


        if(id%8 == 1)
            ongroundID = R.drawable.icon;

        if(id%8 == 2)
            ongroundID = R.drawable.icon2;

        if(id%8 == 3)
            ongroundID = R.drawable.icon3;

        if(id%8 == 4)
            ongroundID = R.drawable.icon4;

        if(id%8 == 5)
            ongroundID = R.drawable.icon5;

        if(id%8 == 6)
            ongroundID = R.drawable.icon6;

        if(id%8 == 7)
            ongroundID = R.drawable.icon7;

        if(id%8 == 0)
            ongroundID = R.drawable.icon8;

        back = AppCompatDrawableManager.get().getDrawable(context,backgroundID);
        front = AppCompatDrawableManager.get().getDrawable(context,ongroundID);
        setBackground(back);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void turnTheCard(){
        if(isTurnable) {
            if (!isOpen) {
                setBackground(front);
                isOpen = true;
            } else {
                setBackground(back);
                isOpen = false;
            }
        }





    }
}
