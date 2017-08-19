package com.example.mightychen.mightycourses;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //THE FOLLOW CODE IS TO SET THE FONT OF THE APP, IT WILL NOT SHOW IN THE DEV PREVIEW, BUT WILL SHOW WHEN COMPILING THE APP
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "LemonMilk.otf");
        TextView myTextView = (TextView)findViewById(R.id.Title);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView)findViewById(R.id.CreateNew);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView)findViewById(R.id.FindSchedule);
        myTextView.setTypeface(myTypeFace);

        String TAG = MainMenu.class.getSimpleName();
        Log.i(TAG, "Hello World");
        Log.i(TAG, "Hello World");
        Log.i(TAG, "Hello World");
        Log.i(TAG, "Hello World");
        Log.i(TAG, "Hello World");
    }

    public void CreateSchedule(View v)
    {
        Intent toodles = new Intent(MainMenu.this, CreateNewSchedule.class);
        startActivity(toodles);
    }

    public void FindSchedule (View v)
    {
        Intent toodles = new Intent(MainMenu.this, FS1.class);
        startActivity(toodles);
    }
}
