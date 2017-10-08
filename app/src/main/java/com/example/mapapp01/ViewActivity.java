package com.example.mapapp01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        // DBオープン処理
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        //SQL文
        String sql    = "SELECT _id,name,memo FROM Map";
        //SQL文の実行
        Cursor cursor = db.rawQuery(sql,null);
        startManagingCursor(cursor);

        String result_str="";

        while(cursor.moveToNext()){
            int index_id = cursor.getColumnIndex("_id");
            int index_name = cursor.getColumnIndex("name");
            int index_memo = cursor.getColumnIndex("memo");
            int id = cursor.getInt(index_id);
            String name = cursor.getString(index_name);
            String memo = cursor.getString(index_memo);
            result_str += "ID:"+ id + "、名前：" + name + "、メモ：" + memo + "\n";
        }

        TextView result = (TextView)findViewById(R.id.result);
        result.setText(result_str);

    }
}
