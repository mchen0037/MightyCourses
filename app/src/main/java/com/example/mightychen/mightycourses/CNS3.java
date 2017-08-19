package com.example.mightychen.mightycourses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CNS3 extends AppCompatActivity {

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cns3);

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

        Intent toodles = getIntent();
        Person user = (Person) toodles.getSerializableExtra("myPObj");

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

    public void SaveSched(View v) {
        Intent toodles = getIntent();
        Person user = (Person) toodles.getSerializableExtra("myPObj");

//        String spclasses = user.getName() + "courses";
//        String spnumberclasses = user.getName() + "NOC";
//
//        SharedPreferences sp = this.getSharedPreferences("com.example.mightychen.mightycourses", Context.MODE_PRIVATE);
//        try {
//            sp.edit().putClass(spclasses, ObjectSerializer.serialize(user.getSchedule())).apply();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        sp.edit().putInt(spnumberclasses, user.getNumberOfClasses()).apply();
//
//        Person user2 = new Person();
//        Classes[] sched = new Classes[sp.getInt(spnumberclasses, 0)];
//        user2.setSchedule(sched);
//
//        Log.i("what", user2.getSchedule().toString());
        String filename = user.getName() + ".txt";
        String string = user.getName() + "\n";
        FileOutputStream output;

        try {
            output = openFileOutput(filename, Context.MODE_PRIVATE); // /data/user/0/com.example.mightychen.mightycourses/files
            output.write(string.getBytes());
            string = user.getNumberOfClasses() + "\n";
            output.write(string.getBytes());

            for (int i = 0; i < user.getNumberOfClasses(); ++i) {
                string = user.Schedule[i].getClassName() + "\n";
                output.write(string.getBytes());
                for (int j = 0; j < 5; ++j) {
                    string = user.Schedule[i].ClassOnDay(j) + " ";
                    output.write(string.getBytes());
                }
                string = "\n";
                output.write(string.getBytes());
                string = user.Schedule[i].getStartTime() + "\n";
                output.write(string.getBytes());
                string = user.Schedule[i].getEndTime() + "\n";
                output.write(string.getBytes());
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //String[] names = new String[12];
        ArrayList<String> names = new ArrayList<String>();

        filename = "data/user/0/com.example.mightychen.mightycourses/files/123456789NAMESLOL.txt";

        try {
            Scanner Kevin = new Scanner(new FileReader(filename));
            int i = 0;
            while (Kevin.hasNextLine()){
                string = Kevin.nextLine();
                names.add(string);
                String TAG = MainMenu.class.getSimpleName();
                Log.i(TAG, "*****************" + string);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        filename = "123456789NAMESLOL.txt";
        try {
            output = openFileOutput(filename, Context.MODE_PRIVATE);

            for (int i = 0; i < names.size(); ++i) {
                string = names.get(i) + "\n";
                output.write(string.getBytes());
            }
            string = user.getName() + "\n";
            output.write(string.getBytes());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


      //SAMPLE CODE FOR FILE WRITING
/*        String filename = "myfile.txt";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
            String TAG = MainMenu.class.getSimpleName();
            //Log.i(TAG, "Hello World");
            Log.i(TAG, "*********************************************SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

       Intent toodles2 = new Intent(CNS3.this, MainMenu.class);
       startActivity(toodles2);
    }


}

