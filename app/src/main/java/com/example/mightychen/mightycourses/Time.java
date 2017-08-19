package com.example.mightychen.mightycourses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mighty Chen on 5/14/2017.
 */

public class Time implements Parcelable {
    private int hour;
    private int minute;


    public Time()
    {
        hour = 0;
        minute = 0;
    }

    public Time(String s)
    {
        String delim = "[:]+";
        String[] tokens = s.split(delim);

        hour = Integer.valueOf(tokens[0]);
        minute = Integer.valueOf(tokens[1]);
    }

    public String getTime()
    {
        String tmp = hour + ":" + minute;
        return tmp;
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public Time(Parcel source) {
        hour = source.readInt();
        minute = source.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(hour);
        out.writeInt(minute);

    }

    public static final Parcelable.Creator<Time> CREATOR = new Parcelable.Creator<Time>() {
        public Time createFromParcel(Parcel in) {
            return new Time(in);
        }

        public Time[] newArray(int size) {
            return new Time[size];
        }

    };
}
