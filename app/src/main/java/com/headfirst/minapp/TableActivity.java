package com.headfirst.minapp;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.headfirst.minapp.fragments.PageFragment1;
import com.headfirst.minapp.fragments.PageFragment2;
import com.headfirst.minapp.fragments.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter adapter;
    private Fragment page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = findViewById(R.id.pager);
        adapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(adapter);
        page3 = new PageFragment3();
    }
}