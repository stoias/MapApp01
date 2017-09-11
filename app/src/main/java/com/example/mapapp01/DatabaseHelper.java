package com.example.mapapp01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sachi on 2017/09/05.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(Context context){
        super(context, "Map.db",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        // テーブルの作成
        db.execSQL("Create Table Map " +
                "(" +
                "_id  INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",name TEXT" +
                ",longitude REAL" +
                ",latitude REAL" +
                ",memo TEXT" +
                ")");
    }

    /*
     * onUpgradeメソッド
     * onUpgrade()メソッドはデータベースをバージョンアップした時に呼ばれる
     */
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        // とりあえず今は空にするらしい。じゃないとエラーが消えない
    }
}
