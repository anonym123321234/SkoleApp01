package com.headfirst.minapp;

import java.util.Calendar;
import java.util.GregorianCalendar;

import sun.bob.mcalendarview.MCalendarView;

public class Prøvedag {
    private int year;
    private int måned;
    private int dag;
    private String fag;
    private MCalendarView kalender;

    public Prøvedag(int year, int måned, int dag, String fag){
        this.year = year;
        this.måned = måned;
        this.dag = dag;
        this.fag = fag;
    }

    public static final Prøvedag[] prøver =  {
            new Prøvedag(2020, 1, 14, "Historie"),
            new Prøvedag(2020, 1, 21, "Norsk"),
            new Prøvedag(2020,1 , 28, "Fransk"),
            new Prøvedag(2020,1, 31, "Matte"),
            new Prøvedag(2020,2, 4, "Fysikk"),
            new Prøvedag(2020,2,11, "TOF"),
            new Prøvedag(2020,2, 17, "Sosialkunnskap"),
            new Prøvedag(2020,2, 19, "Historie"),
            new Prøvedag(2020,3, 3 ,"Norsk"),
            new Prøvedag(2020,3, 13,"Matte"),
            new Prøvedag(2020,3, 17, "Fransk"),
            new Prøvedag(2020,3, 20, "Tof"),
            new Prøvedag(2020,3, 25, "Norsk"),
            new Prøvedag(2020,3, 26,"Fysikk"),
            new Prøvedag(2020,3, 30, "Sosialkunnskap"),
            new Prøvedag(2020,4, 14, "Norsk-Tentamen"),
            new Prøvedag(2020,4, 21, "Tof"),
            new Prøvedag(2020,4, 28, "Matte-tentamen"),
            new Prøvedag(2020,4, 29, "Historie"),
            new Prøvedag(2020,5,4,"Sosialkunnskao"),
            new Prøvedag(2020,5, 5, "Fysikk"),
            new Prøvedag(2020,5,12,  "Fransk"),
            new Prøvedag(2020,5,14, "Norsk"),
            new Prøvedag(2020, 5, 19, "EKSAMEN"),
            new Prøvedag(2020, 6, 4, "EKSAMEN")
    };

    public static final Prøvedag[] fridager = {};

    public int getDag() {
        return dag;
    }

    public int getMåned() {
        return måned;
    }

    public int getYear() {
        return year;
    }

    public String getFag(){
        return fag;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }

}
