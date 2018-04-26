package com.example.matt.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class FlowerActivityAdapter extends BaseAdapter {

    String[] flowers;
    LayoutInflater inflate;
    Context Ctx;
    SharedPreferences Settings;

    public FlowerActivityAdapter(Context ctx, String[] Flowers) {
        flowers = Flowers;
        inflate = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Ctx = ctx;
    }

    @Override
    public int getCount() {
        return flowers.length;
    }

    @Override
    public Object getItem(int i) {
        return flowers[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflate.inflate(R.layout.activity_flower_layout, null);
        TextView flowerTxtVw = (TextView) v.findViewById(R.id.FlowerTxt);
        final TextView countTxtVw = (TextView) v.findViewById(R.id.CountTxt);
        Button plusBtn = (Button) v.findViewById(R.id.plusBtn);
        Button minusBtn = (Button) v.findViewById(R.id.minusBtn);

        String Flowers = flowers[i];
        flowerTxtVw.setText(Flowers);
        int setValue = 0;
        Settings = Ctx.getSharedPreferences("SavedItems", 0);
        if(Settings.contains(Flowers)) {
            setValue = Settings.getInt(Flowers, 0);
        }
        SharedPreferences.Editor edit = Settings.edit();
        countTxtVw.setText(String.valueOf(setValue));

        edit.putInt(Flowers, setValue);
        edit.commit();

        plusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View p = (View)view.getParent();

                TextView FlowerTxtVw = (TextView) p.findViewById(R.id.FlowerTxt);
                Integer value = Integer.parseInt(countTxtVw.getText().toString());
                value++;
                Settings = Ctx.getSharedPreferences("SavedItems", 0);
                SharedPreferences.Editor edit = Settings.edit();
                edit.putInt(FlowerTxtVw.getText().toString(), value);
                edit.apply();
                countTxtVw.setText(value.toString());
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer value = Integer.parseInt(countTxtVw.getText().toString());
                if (value > 0) {
                    View p = (View) view.getParent();
                    TextView FlowerTxtVw = (TextView) p.findViewById(R.id.FlowerTxt);
                    value--;
                    Settings = Ctx.getSharedPreferences("SavedItems", 0);
                    SharedPreferences.Editor edit = Settings.edit();
                    edit.putInt(FlowerTxtVw.getText().toString(), value);
                    edit.apply();
                    countTxtVw.setText(value.toString());
                }
            }
        });

        return v;
    }
}
