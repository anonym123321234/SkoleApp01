package com.headfirst.minapp.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.headfirst.minapp.R;
import com.headfirst.minapp.database.Vg1Database;

public class PageFragment3 extends Fragment {
    private EditText sammfunnskarater;
    private EditText geografikarakter;
    private EditText naturfagkarakter;
    private EditText engelskkarakter;
    private SQLiteDatabase db;
    private Cursor cursor;
    private static int cursorId;
    private static int karakater;
    private int samfEndring;
    private int geoEndring;
    private int natEndring;
    private int engEndring;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.pager3,
                container,
                false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sammfunnskarater  = (EditText) view.findViewById(R.id.sammfunnsfag_karakter);
        sammfunnskarater.setEnabled(false);
        geografikarakter  = (EditText) view.findViewById(R.id.geokrafi_karakter);
        geografikarakter.setEnabled(false);
        naturfagkarakter  = (EditText) view.findViewById(R.id.naturfag_karakter);
        naturfagkarakter.setEnabled(false);
        engelskkarakter  = (EditText) view.findViewById(R.id.engelsk_karakter);
        engelskkarakter.setEnabled(false);
        final Button save = (Button)view.findViewById(R.id.save3);
        save.setVisibility(View.GONE);

        SQLiteOpenHelper databaseHelper = new Vg1Database(getContext());
        try {
            db = databaseHelper.getWritableDatabase();
            cursor = db.query(
                    Vg1Database.TABLE_NAME,
                    new String[]{Vg1Database.KARAKTER},
                    null,
                    null,
                    null,
                    null,
                    null);
            int karakter = cursor.getInt(0);
            if(cursor.moveToFirst()){
                sammfunnskarater.setText(Integer.toString(karakter));
            }
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(getContext(),
                    "Data er utilgjenlig",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        Button rediger = (Button)view.findViewById(R.id.rediger3);
        rediger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sammfunnskarater.setEnabled(true);
                geografikarakter.setEnabled(true);
                naturfagkarakter.setEnabled(true);
                engelskkarakter.setEnabled(true);
                save.setVisibility(View.VISIBLE);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                samfEndring = Integer.parseInt(sammfunnskarater.getText().toString());
                geoEndring = Integer.parseInt(geografikarakter.getText().toString());
                natEndring = Integer.parseInt(naturfagkarakter.getText().toString());
                engEndring = Integer.parseInt(engelskkarakter.getText().toString());
                sammfunnskarater.setCursorVisible(false);
                geografikarakter.setCursorVisible(false);
                naturfagkarakter.setCursorVisible(false);
                engelskkarakter.setCursorVisible(false);
                updateMethod(samfEndring, 1);
                updateMethod(geoEndring, 2);
                updateMethod(natEndring, 3);
                updateMethod(engEndring, 4);
                save.setVisibility(View.GONE);
            }
        });
    }

    public void updateMethod(int nyKarakter, int id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Vg1Database.KARAKTER, 2);
        db.update(Vg1Database.TABLE_NAME,
                contentValues,
                "_id = ?",
                new String[]{Integer.toString(id)});
    }
}