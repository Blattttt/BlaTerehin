package com.example.minecraft;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    String[] countries = {"Кирка", "Лопата", "Мотыга", "Топор", "Шлем", "Кираса", "Поножи", "Ботинки", "Блок"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView countriesList = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, countries){

            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.WHITE);
                return view;
            }};

        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
               intentString( countries[position]);
                }

        });}

    public void intentString(String index){
        try {
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("id", index);
            startActivity(intent);
        }catch (Exception e) {
            Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show();
        }}}