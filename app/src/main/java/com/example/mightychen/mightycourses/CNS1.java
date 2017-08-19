package com.example.mightychen.mightycourses;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CNS1 extends AppCompatActivity {

    EditText NumberOfClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cns1);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "LemonMilk.otf");
        TextView myTextView = (TextView) findViewById(R.id.textView2);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.NumberOfClasses);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.next);
        myTextView.setTypeface(myTypeFace);
    }

    public void submit(View v)
    {

        //used to retrieve the objects
        Intent toodles = getIntent();
        Person user = (Person)toodles.getSerializableExtra("myObject");


        NumberOfClasses = (EditText) findViewById(R.id.NumberOfClasses);
        int tmp = Integer.parseInt(NumberOfClasses.getText().toString());
        String str = "number: " + tmp;

        user.setNumberOfClasses(tmp);

        str = user.getName() + " has " + user.getNumberOfClasses();

        user.Schedule = new Classes[user.getNumberOfClasses()];

        Toast myToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
        myToast.show();

        Intent toodles2 = new Intent(CNS1.this, CNS2.class);
        toodles2.putExtra("myPObj", (Parcelable)user);
        startActivity(toodles2);
    }
}
