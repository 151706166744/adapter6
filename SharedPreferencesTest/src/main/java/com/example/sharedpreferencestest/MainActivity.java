package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
         private Button saveData;
         private Button restoreData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoreData = (Button) findViewById(R.id.restore_data);
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                pref.getString("name","");
                pref.getInt("age",0);
                pref.getBoolean("married",false);
                boolean married = pref.getBoolean("married", false);
                Log.d("MainActivity","name is"+"name");
                Log.d("MainActivity","age is"+"age");
                Log.d("MainActivity","married is"+"married");
            }
        });
        saveData = (Button) findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = getSharedPreferences("data", MODE_PRIVATE).edit();
                edit.putString("name","Tom");
                edit.putInt("age",20);
                edit.putBoolean("married",false);
                edit.apply();
            }
        });
    }
}