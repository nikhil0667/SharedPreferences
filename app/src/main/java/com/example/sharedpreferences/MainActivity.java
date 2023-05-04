package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList arrayList = new ArrayList();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,arrayList);
        ListView listView = findViewById(R.id.list);
        EditText editText = findViewById(R.id.edt);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("str",msg);
                editor.apply();
                arrayList.add(msg);
                listView.setAdapter(adapter);
                editText.clearComposingText();

            }
        });
        SharedPreferences getshared = getSharedPreferences("demo",MODE_PRIVATE);
        arrayList.add(getshared.getString("str","Save a note and it will show up here"));
        listView.setAdapter(adapter);

    }
}