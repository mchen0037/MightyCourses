package com.example.mightychen.mightycourses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mighty Chen on 5/14/2017.
 */

public class Classes implements Parcelable
{
    private String NameOfClass;
    private Time start;
    private boolean[] Days;
    private Time end;

    public Classes()
    {
        NameOfClass = "classname";
        start = new Time();
        end = new Time();
        Days = new boolean[5];
        for (int i = 0; i < 5; ++i)
        {
            Days[i] = false;
        }
    }

    public Classes(String n, String s, String e, boolean[] wd)
    {
        NameOfClass = n;
        start = new Time(s); //LEFT OFF HERE
        Days = new boolean[5];
        for (int i = 0; i < 5; ++i)
            Days[i] = wd[i];
        end = new Time(e);
    }

    public Classes(Parcel source) {
        NameOfClass = source.readString();
        Days = source.createBooleanArray();
    }

    public void setNameOfClass(String n)
    {
        NameOfClass = n;
    }


    public String getClassName()
    {
        return NameOfClass;
    }

    public int getStartHour()
    {
        return start.getHour();
    }

    public void setStartTime(String str)
    {
        start = new Time(str);
        return;
    }

    public void setEndTime(String str)
    {
        end = new Time(str);
        return;
    }

    public int getStartMinute()
    {
        return start.getMinute();
    }

    public int getEndHour()
    {
        return end.getHour();
    }

    public int getEndMinute()
    {
        return end.getMinute();
    }

    public String getStartTime()
    {
        return start.getTime();
    }

    public String getEndTime()
    {
        return end.getTime();
    }

    public boolean ClassOnDay(int i)
    {
        return Days[i];
    }

    public void setClassOnDay(boolean b, int i)
    {
        Days[i] = b;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(NameOfClass);
        out.writeBooleanArray(Days);
        out.writeValue(start);
        out.writeValue(end);
        // out.writeTypedArray(Schedule, 0);
    }

    public static final Parcelable.Creator<Classes> CREATOR = new Parcelable.Creator<Classes>() {
        public Classes createFromParcel(Parcel in) {
            return new Classes(in);
        }

        public Classes[] newArray(int size) {
            return new Classes[size];
        }

    };
}
