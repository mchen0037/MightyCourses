package com.example.mightychen.mightycourses;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mightychen.mightycourses.R.id.editText;

public class CNS2 extends AppCompatActivity {

    //used to display counter
    TextView InfoNo;
    int NumberOnTop = 1;
    int ClassesInputted = 0;

    //used to for the information inputted by the user
    EditText ClassName;
    EditText StartTime;
    EditText EndTime;

    //boolean values for the days of the week
    private static boolean monday = false;
    private static boolean tuesday = false;
    private static boolean wednesday = false;
    private static boolean thursday = false;
    private static boolean friday = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cns2);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "LemonMilk.otf");
        TextView myTextView = (TextView) findViewById(R.id.InfoNumber); //"Name of Courses"
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.editText4);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(editText); //Start Time
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.editText3); //End Time
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.checkBox);
        myTextView.setTypeface(myTypeFace);


        myTextView = (TextView) findViewById(R.id.checkBox2);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.checkBox3);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.checkBox4);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.checkBox5);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.textView6);
        myTextView.setTypeface(myTypeFace);

        myTextView = (TextView) findViewById(R.id.InfoNumber);
        myTextView.setTypeface(myTypeFace);

        InfoNo = (TextView) findViewById(R.id.InfoNumber);
        ClassName = (EditText) findViewById(R.id.editText4);
        StartTime = (EditText) findViewById(R.id.editText3);
        EndTime = (EditText) findViewById(editText);

    }

    public void submit(View v) {
        Intent toodles = getIntent();
        Person user = (Person) toodles.getSerializableExtra("myPObj");
        NumberOnTop++;

        if (ClassesInputted + 1 < user.getNumberOfClasses()) {

            boolean[] d = new boolean[5];
            d[0] = monday;
            d[1] = tuesday;
            d[2] = wednesday;
            d[3] = thursday;
            d[4] = friday;


            String n = ClassName.getText().toString();
            String s = StartTime.getText().toString();
            String e = EndTime.getText().toString();

            user.Schedule[ClassesInputted] = new Classes(n, s, e, d);
            InfoNo.setText(Integer.toString(NumberOnTop));

            String str = user.Schedule[ClassesInputted].getClassName() + " was successfully added. Please add the information for your next course.";
            Toast myToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG);
            myToast.show();
            ClassesInputted++;



        }
        else {

            boolean[] d = new boolean[5];
            d[0] = monday;
            d[1] = tuesday;
            d[2] = wednesday;
            d[3] = thursday;
            d[4] = friday;


            String n = ClassName.getText().toString();
            String s = StartTime.getText().toString();
            String e = EndTime.getText().toString();

            user.Schedule[ClassesInputted] = new Classes(n, s, e, d);

            String str = user.Schedule[ClassesInputted].getClassName() + " was successfully added.";
            Toast myToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG);
            myToast.show();


            Intent toodles2 = new Intent(CNS2.this, CNS3.class);
            toodles2.putExtra("myPObj", (Parcelable) user);
            startActivity(toodles2);


        }
    }

    public void clearTextS(View v) //on click of the text input, clear the thing
    {
        InfoNo.setText("ASLDKFJ");
    }

    public void checkMonday(View v) {
        monday = !monday;
    }

    public void checkTuesday(View v) {
        tuesday = !tuesday;
    }

    public void checkWednesday(View v) {
        wednesday = !wednesday;
    }

    public void checkThursday(View v) {
        thursday = !thursday;
    }

    public void checkFriday(View v) {
        friday = !friday;
    }

}
