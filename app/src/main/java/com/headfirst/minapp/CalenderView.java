package com.headfirst.minapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.vo.DateData;

import static com.headfirst.minapp.Prøvedag.prøver;

public class CalenderView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_view);
        Calendar calendar = Calendar.getInstance();
        final MCalendarView kalender = findViewById(R.id.kalender);
        for (int i = 0; i < prøver.length; i++) {
            int år = prøver[i].getYear();
            int måned = prøver[i].getMåned();
            int dag = prøver[i].getDag();
            String fag = prøver[i].getFag();
            DateData nå = new DateData(år, måned, dag);
            if (prøver[i].getFag() != "EKSAMEN") {
                kalender.markDate(nå.setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, Color.RED)));
            } else if (prøver[i].getFag() == "EKSAMEN") {
                kalender.markDate(nå.setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, Color.BLACK)));
            }
        }
    }
}