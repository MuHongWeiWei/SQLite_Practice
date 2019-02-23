package com.example.datebasepractice;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
//        db.execSQL("insert into info(name, phone) values(?,?)", new Object[]{"穆弘洧","0956860424"});

        ContentValues values = new ContentValues();
        values.put("name", "蔡佳君");
        values.put("phone","0988870477");
        long insert = db.insert("info", null, values);
        db.close();

        if (insert > -1) {
            Toast.makeText(getApplicationContext(),"新增成功",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"新增失敗",Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
//        db.execSQL("delete from info where name = ?", new Object[]{"穆弘洧"});
        int delete = db.delete("info", "name = ?", new String[]{"蔡佳君"});
        db.close();

        Toast.makeText(getApplicationContext(), "刪除了" + delete + "行", Toast.LENGTH_SHORT).show();

    }

    public void update(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
//        db.execSQL("update info set phone = ? where name = ?", new Object[]{"0988870477","穆弘洧"});

        ContentValues values = new ContentValues();
        values.put("phone", "0956860424");
        int update = db.update("info", values, "name = ?", new String[]{"蔡佳君"});
        db.close();

        Toast.makeText(getApplicationContext(), "更新了" + update + "行", Toast.LENGTH_SHORT).show();
    }

    public void search(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from info", null);

        Cursor cursor = db.query("info", new String[]{"phone"}, "name = ?", new String[]{"蔡佳君"}, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String phone = cursor.getString(0);
                System.out.println(phone);
            }
        }
        db.close();
    }
}
