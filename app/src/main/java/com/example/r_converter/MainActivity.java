package com.example.r_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items = new ArrayList<String>(Arrays.asList());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("FAVORITE LIST");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        final SharedPreferences sp = this.getSharedPreferences("share_data", Context.MODE_PRIVATE);

        String[] arrayItems = sp.getString("list", "Black:Black:White:Gold").split(",");

        items = new ArrayList<String>(Arrays.asList(arrayItems));

        RecyclerView recyclerView = findViewById(R.id.Rfavorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecycleAdapter adapter = new MyRecycleAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            final SharedPreferences sp = this.getSharedPreferences("share_data", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sp.edit();

            String stringItem = "";

            if(stringItem==""){
                stringItem = items.get(0);
            }

            for (int i = 1; i < items.size(); i++) {
                stringItem = stringItem + "," + items.get(i);
            }

            editor.putString("list", stringItem);
            editor.commit();
        }
        return super.onKeyDown(keyCode, event);
    }
}