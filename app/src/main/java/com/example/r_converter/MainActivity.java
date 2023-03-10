package com.example.r_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView sampleTxt, sampleTxt2;

    FrameLayout band1, band2, band3, band4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sp = this.getSharedPreferences("share_data", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        sampleTxt = findViewById(R.id.sample);
        sampleTxt2 = findViewById(R.id.sample2);

        List<String> items = new LinkedList<>();

        //items.add(sp.getString("resistor", null));
        //adapter.notifyItemInserted(items.size()-1);

        sampleTxt.setText(sp.getString("list", "Red:Red:Red:Brown"));

        String[] arrayItems = sp.getString("list", "Red:Red:Red:Brown").split(",");

        items = Arrays.asList(arrayItems);

        sampleTxt2.setText("items index 0 is " + items.get(0));

        RecyclerView recyclerView = findViewById(R.id.Rfavorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecycleAdapter adapter = new MyRecycleAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}