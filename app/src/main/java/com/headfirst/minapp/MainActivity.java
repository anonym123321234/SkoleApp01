package com.headfirst.minapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CalendarView;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dato = (TextView)findViewById(R.id.undertittel);
        dato.setText(getDate());
        GridLayout grid = (GridLayout) findViewById(R.id.gridlayout);
        handleGridEvent(grid);
    }
    private static String getDate(){
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        return currentDate;
    }

    private void handleGridEvent(GridLayout layout){
        for (int i= 0; i < layout.getChildCount(); i++){
            final CardView cardView = (CardView)layout.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CardView kalender = (CardView)findViewById(R.id.cardView1);
                    CardView karakterer = (CardView)findViewById(R.id.cardView2);
                    int  kalendeId = kalender.getId();
                    int karakterId = karakterer.getId();
                    if((cardView.getId()) == kalendeId){
                       Intent intent = new Intent(MainActivity.this, CalenderView.class);
                       startActivity(intent);
                    }else if((cardView.getId()) == karakterId){
                        Intent intent = new Intent(MainActivity.this, TableActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
