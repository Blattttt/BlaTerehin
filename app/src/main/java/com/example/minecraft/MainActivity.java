package com.example.minecraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] countries = {"Кирка", "Лопата", "Мотыга", "Топор", "Шлем", "Нагрудник", "Штаны", "Ботинки", "Блок"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView countriesList = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, countries);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
               intentString( countries[position]);
                }

        });
    }

    public void intentString(String index){
        try {
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("id", index);
            startActivity(intent);
        }catch (Exception e) {
            Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show();
        }
    }
}