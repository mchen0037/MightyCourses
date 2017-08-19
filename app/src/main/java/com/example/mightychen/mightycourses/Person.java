package com.example.mightychen.mightycourses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Mighty Chen on 5/14/2017.
 */

public class Person implements Parcelable {
    private static String name;
    static Classes[] Schedule;
    private static int NumberOfClasses;

    public Person() {
        name = "";
        NumberOfClasses = 0;
        Schedule = new Classes[NumberOfClasses];
    }

    public Person(Parcel source) {
        NumberOfClasses = source.readInt();
        name = source.readString();
        Schedule = source.createTypedArray(Classes.CREATOR);
    }

    public Person(String n, int c) {
        name = n;
        NumberOfClasses = c;
        Schedule = new Classes[NumberOfClasses];
        //Schedule = new ArrayList<Classes>();
    }

    public static void setName(String n) {
        name = n;
    }

    public static String getName() {
        return name;
    }

    public static void setNumberOfClasses(int n) {
        NumberOfClasses = n;
        Schedule = new Classes[n];
        for (int i = 0; i < n; ++i) {
            Schedule[i] = new Classes();
        }
    }

    public static int getNumberOfClasses() {
        return NumberOfClasses;
    }

    public static Classes[] getSchedule()
    {
        return Schedule;
    }

    public static void setSchedule(Classes[] schedule) {
        Schedule = schedule;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(NumberOfClasses);
        out.writeString(name);
        out.writeTypedArray(Schedule, 0);
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }

    };

}