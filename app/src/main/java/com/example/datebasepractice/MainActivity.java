package com.example.datebasepractice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MyOpenHelper(getApplicationContext());


    }

    public void add(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into info(name, phone) values(?,?)", new Object[]{"穆弘洧","0956860424"});
        db.close();
    }

    public void delete(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from info where name = ?", new Object[]{"穆弘洧"});
        db.close();
    }

    public void update(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update info set phone = ? where name = ?", new Object[]{"0988870477","穆弘洧"});
        db.close();
    }

    public void search(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from info", null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                String name = cursor.getString(cursor.getColumnIndex("name"));

                System.out.println("name" + name + "---" + phone);
            }
        }
        db.close();
    }
}
