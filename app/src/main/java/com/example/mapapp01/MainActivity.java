package com.example.mapapp01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button view = (Button)findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplication(),MapsActivity.class);
                startActivityForResult(intent,001);
            }
        });

        Button input = (Button)findViewById(R.id.input);
        input.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplication(),InputActivity.class);
                startActivityForResult(intent,002);
            }
        });
    }


}
