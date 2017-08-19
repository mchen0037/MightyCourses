package com.example.mightychen.mightycourses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static android.R.id.button1;

public class FS1 extends AppCompatActivity {

    Button[][] buttons = new Button[6][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fs1);

        buttons[0][0] = (Button) findViewById(R.id.button1);
        buttons[0][1] = (Button) findViewById(R.id.button2);
        buttons[1][0] = (Button) findViewById(R.id.button3);
        buttons[1][1] = (Button) findViewById(R.id.button4);
        buttons[2][0] = (Button) findViewById(R.id.button5);
        buttons[2][1] = (Button) findViewById(R.id.button6);
        buttons[3][0] = (Button) findViewById(R.id.button7);
        buttons[3][1] = (Button) findViewById(R.id.button8);
        buttons[4][0] = (Button) findViewById(R.id.button9);
        buttons[4][1] = (Button) findViewById(R.id.button10);
        buttons[5][0] = (Button) findViewById(R.id.button11);
        buttons[5][1] = (Button) findViewById(R.id.button12);

        //sets the table in the layout to "table"
        //TableLayout table = (TableLayout) findViewById(R.id.table);
        ArrayList<String> names = new ArrayList<String>();


        try {
            String filename = "/data/user/0/com.example.mightychen.mightycourses/files/123456789NAMESLOL.txt";
            Scanner Kevin = new Scanner(new FileReader(filename));
            while (Kevin.hasNext()) {
                names.add(Kevin.next());
            }
            names.add(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int n = 0;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 2; ++j) {
                if (names.get(n) != null) {
                    TextView myTextView = buttons[i][j];
                    myTextView.setText(names.get(n));
                    n++;
                } else {
                    TextView myTextView = buttons[i][j];
                    myTextView.setText("[empty]");
                }
            }
        }


        //FOR DYNAMICALLY CREATING BUTTONS
        /*for (i = 0; i < names.size(); ++i) {
            TableRow row = new TableRow(this);
            table.addView(row);
            Button button = new Button(this);
            row.addView(button);
            TextView myTextView = button;
            myTextView.setText(names.get(i));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClicked(names.get(i));
                }
            });
        }
    }

    private void buttonClicked(String str) {
        Toast myToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
        myToast.show();
    }
*/

        /* SAMPLE CODE FOR READING FILES. YOU MUST USE THE DIRECTORY IN String filename = ___________;
        try
        {
            String filename = "/data/user/0/com.example.mightychen.mightycourses/files/myfile.txt";
            Scanner Kevin = new Scanner(new FileReader(filename));
            Toast myToast = Toast.makeText(getApplicationContext(), Kevin.nextLine(), Toast.LENGTH_SHORT);
            myToast.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            String TAG = MainMenu.class.getSimpleName();
            Log.i(TAG, "*********************************************FAILED");
        } */
    }


    public void onClick(View v)
    {
        String filename = "/data/user/0/com.example.mightychen.mightycourses/files/";
        switch(v.getId())
        {
            case R.id.button1:
                filename = filename + buttons[0][0].getText().toString() + ".txt";
                break;
            case R.id.button2:
                filename = filename + buttons[0][1].getText().toString()+ ".txt";
                break;
            case R.id.button3:
                filename = filename + buttons[1][0].getText().toString()+ ".txt";
                break;
            case R.id.button4:
                filename = filename + buttons[1][1].getText().toString()+ ".txt";
                break;
            case R.id.button5:
                filename = filename + buttons[2][0].getText().toString()+ ".txt";
                break;
            case R.id.button6:
                filename = filename + buttons[2][1].getText().toString()+ ".txt";
                break;
            case R.id.button7:
                filename = filename + buttons[3][0].getText().toString()+ ".txt";
                break;
            case R.id.button8:
                filename = filename + buttons[3][1].getText().toString()+ ".txt";
                break;
            case R.id.button9:
                filename = filename + buttons[4][0].getText().toString()+ ".txt";
                break;
            case R.id.button10:
                filename = filename + buttons[4][1].getText().toString()+ ".txt";
                break;
            case R.id.button11:
                filename = filename + buttons[5][0].getText().toString()+ ".txt";
                break;
            case R.id.button12:
                filename = filename + buttons[5][1].getText().toString()+ ".txt";
                break;
        }

        Toast myToast = Toast.makeText(getApplicationContext(), filename, Toast.LENGTH_SHORT);
        myToast.show();
        SharedPreferences sp = this.getSharedPreferences("com.example.mightychen.mightycourses", Context.MODE_PRIVATE);
        sp.edit().putString("filename", filename).apply();

        Intent toodles2 = new Intent(FS1.this, FS20.class);
        //toodles2.putExtra("myPObj", (Parcelable) obj);
        startActivity(toodles2);
    }




}
