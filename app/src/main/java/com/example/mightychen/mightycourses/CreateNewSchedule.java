package com.example.mightychen.mightycourses;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class CreateNewSchedule extends AppCompatActivity {

    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_schedule);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "LemonMilk.otf");
        TextView myTextView = (TextView)findViewById(R.id.textView1);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView)findViewById(R.id.name);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView)findViewById(R.id.next);
        myTextView.setTypeface(myTypeFace);
    }

    public void submit(View v)
    {
        name = (EditText) findViewById(R.id.name);
        String tmp = name.getText().toString();
        String str = "Name: " + tmp;
        Person user = new Person();
        user.setName(tmp);

       // Used to save the object as a Parcel and then sends it to the next Activity
        Intent i = new Intent(CreateNewSchedule.this, CNS1.class);
        i.putExtra("myObject", (Parcelable)user);
        startActivity(i);
    }
}
