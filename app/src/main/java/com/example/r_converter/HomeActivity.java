package com.example.r_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;


public class HomeActivity extends AppCompatActivity {
    Button calBtn, addBtn, goFavBtn;
    FrameLayout band1, band2, band3, band4;
    TextView result;
    Spinner spin1, spin2, spin3, spin4;

    String items = "";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        calBtn = findViewById(R.id.calculate_button);
        addBtn = findViewById(R.id.add_button);
        goFavBtn = findViewById(R.id.go_list_button);

        result = findViewById(R.id.resultText);

        band1 = findViewById(R.id.frame1stBand);
        band2 = findViewById(R.id.frame2ndBand);
        band3 = findViewById(R.id.frame3rdBand);
        band4 = findViewById(R.id.frame4thBand);

        spin1 = findViewById(R.id.spinner1stBand);
        spin2 = findViewById(R.id.spinner2ndBand);
        spin3 = findViewById(R.id.spinnerMultiple);
        spin4 = findViewById(R.id.spinnerTolerance);

        band1.setBackgroundColor(getResources().getColor(R.color.myBlack));
        band2.setBackgroundColor(getResources().getColor(R.color.myBlack));
        band3.setBackgroundColor(getResources().getColor(R.color.myBlack));
        band4.setBackgroundColor(getResources().getColor(R.color.myBrown));

        final SharedPreferences sp = this.getSharedPreferences("share_data", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String band1txt, band2txt, band4txt;
                Double band3value, calResult;

                band1txt = getBandValue(spin1.getSelectedItem().toString(), band1);
                band2txt = getBandValue(spin2.getSelectedItem().toString(), band2);
                band3value = getMultipleValue(spin3.getSelectedItem().toString(), band3);
                band4txt = spin4.getSelectedItem().toString();

                calResult = Double.parseDouble(band1txt + band2txt) * band3value;

                result.setText(convertSuffix(calResult) + "Ω ±" + getTolerance(band4txt, band4) + "%");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spin1.getSelectedItem().toString() + ":" +
                        spin2.getSelectedItem().toString() + ":" +
                        spin3.getSelectedItem().toString() + ":" +
                        spin4.getSelectedItem().toString();
                if(items==""){
                    items = item;
                }
                else{
                    items = items + "," + item;
                }

                goFavBtn.setEnabled(true);
            }
        });

        goFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("list", items);
                editor.commit();

                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
    public String getBandValue(String bandV, FrameLayout bandColor){
        switch(bandV) {
            case "Black":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBlack));
                return "0";
            case "Brown":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBrown));
                return "1";
            case "Red":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myRed));
                return "2";
            case "Orange":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myOrange));
                return "3";
            case "Yellow":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myYellow));
                return "4";
            case "Green":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGreen));
                return "5";
            case "Blue":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBlue));
                return "6";
            case "Violet":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myViolet));
                return "7";
            case "Grey":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGrey));
                return "8";
            case "White":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myWhite));
                return "9";
            case "Gold":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGold));
                return "0.1";
            case "Silver":
                bandColor.setBackgroundColor(getResources().getColor(R.color.mySilver));
                return "0.01";
            default:
                return "Error at getBandValue";
        }
    }
    public Double getMultipleValue(String bandM, FrameLayout bandColor){
        switch(bandM) {
            case "Black":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBlack));
                return 1.0;
            case "Brown":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBrown));
                return 10.0;
            case "Red":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myRed));
                return 100.0;
            case "Orange":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myOrange));
                return 1000.0;
            case "Yellow":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myYellow));
                return 10000.0;
            case "Green":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGreen));
                return 100000.0;
            case "Blue":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBlue));
                return 1000000.0;
            case "Violet":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myViolet));
                return 10000000.0;
            case "Grey":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGrey));
                return 100000000.0;
            case "White":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myWhite));
                return 1000000000.0;
            case "Gold":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGold));
                return 0.1;
            case "Silver":
                bandColor.setBackgroundColor(getResources().getColor(R.color.mySilver));
                return 0.01;
            default:
                return 0.0;
        }
    }
    public String getTolerance(String bandT, FrameLayout bandColor){
        switch(bandT) {
            case "Brown":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBrown));
                return "1";
            case "Red":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myRed));
                return "2";
            case "Orange":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myOrange));
                return "0.05";
            case "Yellow":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myYellow));
                return "0.02";
            case "Green":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGreen));
                return "0.5";
            case "Blue":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myBlue));
                return "0.25";
            case "Violet":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myViolet));
                return "0.1";
            case "Grey":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGrey));
                return "0.01";
            case "Gold":
                bandColor.setBackgroundColor(getResources().getColor(R.color.myGold));
                return "5";
            case "Silver":
                bandColor.setBackgroundColor(getResources().getColor(R.color.mySilver));
                return "10";
            default:
                return "error at getTolerance";
        }
    }
    public String convertSuffix(Double sum){
        if(sum>=1000000000){
            return new DecimalFormat("#.##").format(sum*0.000000001) + " G";
        }
        else if(sum>=1000000){
            return new DecimalFormat("#.##").format(sum*0.000001) + " M";
        }
        else if(sum>=1000){
            return new DecimalFormat("#.##").format(sum*0.001) + " K";
        } else{
            return new DecimalFormat("#.##").format(sum);
        }
    }

}

