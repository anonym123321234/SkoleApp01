package com.headfirst.minapp;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Dager{

    public static long convertDates(int dag, int måned, int år,
                                    int nesteDag, int nesteMåned, int nesteÅr){
        long differenceDates = 0;
        try {
            Date date1;
            Date date2;
            String CurrentDate=  String.format("%d/%d/%d", måned, dag, år);
            String FinalDate=  String.format("%d/%d/%d", nesteMåned, nesteDag, nesteÅr);
            SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
            date1 = dates.parse(CurrentDate);
            date2 = dates.parse(FinalDate);
            long difference = Math.abs(date1.getTime() - date2.getTime());
            differenceDates = difference / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            Log.v("Here!", e.getMessage());
        }
        return differenceDates;
    }


}
