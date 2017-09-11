package com.example.mapapp01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private EditText name;
    private EditText longitude;
    private EditText latitude;
    private EditText memo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // DBオープン処理
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        Button input = (Button)findViewById(R.id.input);
        input.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                InputData();
                name.getEditableText().clear();
                longitude.getEditableText().clear();
                latitude.getEditableText().clear();
                memo.getEditableText().clear();
            }

        });

    }

    private void InputData(){

        name = (EditText)findViewById(R.id.name);
        longitude = (EditText)findViewById(R.id.longitude);
        latitude = (EditText)findViewById(R.id.latitude);
        memo = (EditText)findViewById(R.id.memo);


        ContentValues values = new ContentValues();
        values.put("name",name.getText().toString());
        values.put("longitude",longitude.getText().toString());
        values.put("latitude",latitude.getText().toString());
        values.put("memo",memo.getText().toString());

        try {
            db.insert("map",null,values);
        }finally {
            db.close();
        }
    }
}
