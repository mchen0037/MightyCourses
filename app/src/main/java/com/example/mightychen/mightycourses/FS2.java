package com.example.mightychen.mightycourses;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FS2 extends AppCompatActivity {

    TextView myTextView;
    LinearLayout[] Days = new LinearLayout[5];
    TextView[] Times = new TextView[33];
    boolean[][] check = new boolean[5][33];

//    LinearLayout Sched = (LinearLayout) findViewById(R.id.Horizontal);
//    LinearLayout[] Week = new LinearLayout[5];
//    TextView[] Times = new TextView[32];

    public static int getIndex(int hour, int minute) {
        int index = (hour - 7) * 2 + 1;
        if (minute > 15)
            index++;
        return index;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("IS ANYBODY OUT THERE?", "");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fs2);

        Resources res = getResources();

        int[] palette =
                {
                        res.getColor(R.color.a),
                        res.getColor(R.color.b),
                        res.getColor(R.color.c),
                        res.getColor(R.color.d),
                        res.getColor(R.color.e),
                        res.getColor(R.color.f),
                        res.getColor(R.color.g),
                        res.getColor(R.color.h),
                        res.getColor(R.color.i),
                        res.getColor(R.color.j),
                };


        // Days[j].getChildAt(indexS).setBackgroundColor(res.getColor(R.color.colorPrimaryDark));
        //int ColorTest = res.getColor(R.color.test);
        //Color myColor = new Color(res.getColor(R.color.colorPrimaryDark));
        //myColor.setColor(res.getColor(R.color.colorPrimaryDark));

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "LemonMilk.otf");
        myTextView = (TextView) findViewById(R.id.Monday);
        myTextView.setTypeface(myTypeFace);
        myTextView = (TextView) findViewById(R.id.Tuesday);
        myTextView.setTypeface(myTypeFace);
        myTextView = (TextView) findViewById(R.id.Wednesday);
        myTextView.setTypeface(myTypeFace);
        myTextView = (TextView) findViewById(R.id.Thursday);
        myTextView.setTypeface(myTypeFace);
        myTextView = (TextView) findViewById(R.id.Friday);
        myTextView.setTypeface(myTypeFace);
        myTextView = (TextView) findViewById(R.id.button2);
        myTextView.setTypeface(myTypeFace);

        LinearLayout tmp = (LinearLayout) findViewById(R.id.linearLayout2);

        //int[] test = context.getResources().getIntArray(R.array.palette);

        for (int i = 0; i < 17; ++i) {
            myTextView = (TextView) tmp.getChildAt(i);
            myTextView.setTypeface(myTypeFace);
        }

        Days[0] = (LinearLayout) findViewById(R.id.Monday_LL);
        Days[1] = (LinearLayout) findViewById(R.id.Tuesday_LL);
        Days[2] = (LinearLayout) findViewById(R.id.Wednesday_LL);
        Days[3] = (LinearLayout) findViewById(R.id.Thursday_LL);
        Days[4] = (LinearLayout) findViewById(R.id.Friday_LL);

        Intent obj = getIntent();
        Person user = (Person) obj.getSerializableExtra("myPObj");

        //code to determine which boxes should be filled with a color
        //ex: For "Math," go through Mon-Fri--> If there's class on Wednesday, then do this
        for (int i = 0; i < user.getNumberOfClasses(); ++i) //go through each class to see which days they are on|
        {
            for (int j = 0; j < 5; ++j) {
                if (user.Schedule[i].ClassOnDay(j) == true) //if there's class on Wednesday, then get the Start/End times and color in the boxes
                {
                    int indexS = (getIndex(user.Schedule[i].getStartHour(), user.Schedule[i].getStartMinute()));
                    int indexE = (getIndex(user.Schedule[i].getEndHour(), user.Schedule[i].getEndMinute()));
                    //(TextView) Days[j].getChildAt(indexS).setText("Hello");
                    TextView text = (TextView) Days[j].getChildAt(indexS);  //create a TextView to set the name of the course on the first box
                    text.setText(user.Schedule[i].getClassName());
                    text.setTypeface(myTypeFace);
                    //text.setTextColor(res.getColor(R.color.white));


                    while (indexS < indexE) //FIXME: make sure you go back into CNS2 and add a check where end time must be > than start time
                    {
                        //Days[j].getChildAt(indexS).setBackgroundColor(res.getColor(R.color.colorPrimaryDark)); TESTING TESTING TESTING
                        Days[j].getChildAt(indexS).setBackgroundColor(palette[i % 11]);
                        //check[j][indexS] = true;
                        indexS++;
                    }
                }
            }
        }

    }

}
