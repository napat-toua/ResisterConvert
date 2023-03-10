package com.example.r_converter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<myViewHolder> {

    List<String> items;

    public MyRecycleAdapter(List<String> items){
        this.items = items;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites, parent, false);
        return new myViewHolder(view).linkAdaptor(this);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        String[] item = items.get(position).split(":");

        String band1txt, band2txt, band4txt;
        Double band3value, calResult;

        band1txt = getBandValue(item[0], holder.band1);
        band2txt = getBandValue(item[1], holder.band2);
        band3value = getMultipleValue(item[2], holder.band3);
        band4txt = item[3];

        calResult = Double.parseDouble(band1txt + band2txt) * band3value;

        holder.textView.setText(convertSuffix(calResult) + "Ω ±" + getTolerance(band4txt, holder.band4) + "%");
        //holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public String getBandValue(String bandV, FrameLayout bandColor){
        switch(bandV) {
            case "Black":
                bandColor.setBackgroundColor(Color.parseColor("#000000"));
                return "0";
            case "Brown":
                bandColor.setBackgroundColor(Color.parseColor("#964B00"));
                return "1";
            case "Red":
                bandColor.setBackgroundColor(Color.parseColor("#FF0000"));
                return "2";
            case "Orange":
                bandColor.setBackgroundColor(Color.parseColor("#FFA500"));
                return "3";
            case "Yellow":
                bandColor.setBackgroundColor(Color.parseColor("#FFFF00"));
                return "4";
            case "Green":
                bandColor.setBackgroundColor(Color.parseColor("#00FF00"));
                return "5";
            case "Blue":
                bandColor.setBackgroundColor(Color.parseColor("#0000FF"));
                return "6";
            case "Violet":
                bandColor.setBackgroundColor(Color.parseColor("#8F00FF"));
                return "7";
            case "Grey":
                bandColor.setBackgroundColor(Color.parseColor("#808080"));
                return "8";
            case "White":
                bandColor.setBackgroundColor(Color.parseColor("#FFFFFF"));
                return "9";
            case "Gold":
                bandColor.setBackgroundColor(Color.parseColor("#FFD700"));
                return "0.1";
            case "Silver":
                bandColor.setBackgroundColor(Color.parseColor("#C0C0C0"));
                return "0.01";
            default:
                return "Error at getBandValue";
        }
    }
    public Double getMultipleValue(String bandM, FrameLayout bandColor){
        switch(bandM) {
            case "Black":
                bandColor.setBackgroundColor(Color.parseColor("#000000"));
                return 1.0;
            case "Brown":
                bandColor.setBackgroundColor(Color.parseColor("#964B00"));
                return 10.0;
            case "Red":
                bandColor.setBackgroundColor(Color.parseColor("#FF0000"));
                return 100.0;
            case "Orange":
                bandColor.setBackgroundColor(Color.parseColor("#FFA500"));
                return 1000.0;
            case "Yellow":
                bandColor.setBackgroundColor(Color.parseColor("#FFFF00"));
                return 10000.0;
            case "Green":
                bandColor.setBackgroundColor(Color.parseColor("#00FF00"));
                return 100000.0;
            case "Blue":
                bandColor.setBackgroundColor(Color.parseColor("#0000FF"));
                return 1000000.0;
            case "Violet":
                bandColor.setBackgroundColor(Color.parseColor("#8F00FF"));
                return 10000000.0;
            case "Grey":
                bandColor.setBackgroundColor(Color.parseColor("#808080"));
                return 100000000.0;
            case "White":
                bandColor.setBackgroundColor(Color.parseColor("#FFFFFF"));
                return 1000000000.0;
            case "Gold":
                bandColor.setBackgroundColor(Color.parseColor("#FFD700"));
                return 0.1;
            case "Silver":
                bandColor.setBackgroundColor(Color.parseColor("#C0C0C0"));
                return 0.01;
            default:
                return 0.0;
        }
    }
    public String getTolerance(String bandT, FrameLayout bandColor){
        switch(bandT) {
            case "Brown":
                bandColor.setBackgroundColor(Color.parseColor("#964B00"));
                return "1";
            case "Red":
                bandColor.setBackgroundColor(Color.parseColor("#FF0000"));
                return "2";
            case "Orange":
                bandColor.setBackgroundColor(Color.parseColor("#FFA500"));
                return "0.05";
            case "Yellow":
                bandColor.setBackgroundColor(Color.parseColor("#FFFF00"));
                return "0.02";
            case "Green":
                bandColor.setBackgroundColor(Color.parseColor("#00FF00"));
                return "0.5";
            case "Blue":
                bandColor.setBackgroundColor(Color.parseColor("#0000FF"));
                return "0.25";
            case "Violet":
                bandColor.setBackgroundColor(Color.parseColor("#8F00FF"));
                return "0.1";
            case "Grey":
                bandColor.setBackgroundColor(Color.parseColor("#808080"));
                return "0.01";
            case "Gold":
                bandColor.setBackgroundColor(Color.parseColor("#FFD700"));
                return "5";
            case "Silver":
                bandColor.setBackgroundColor(Color.parseColor("#C0C0C0"));
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

class myViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    FrameLayout band1, band2, band3, band4;
    private MyRecycleAdapter adapter;

    public myViewHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.text);

        band1 = itemView.findViewById(R.id.frame1stBand);
        band2 = itemView.findViewById(R.id.frame2ndBand);
        band3 = itemView.findViewById(R.id.frame3rdBand);
        band4 = itemView.findViewById(R.id.frame4thBand);

        itemView.findViewById(R.id.delete).setOnClickListener(view -> {
            adapter.items.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        });


    }

    public myViewHolder linkAdaptor(MyRecycleAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}