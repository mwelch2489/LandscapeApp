package com.example.matt.myfirstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

public class GrassActivityAdapter extends BaseAdapter {

    String[] grass;
    LayoutInflater inflate;
    Context Ctx;
    SharedPreferences Settings;

    public GrassActivityAdapter(Context ctx, String[] Grass) {
        grass = Grass;
        inflate = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Ctx = ctx;
    }

    @Override
    public int getCount() {
        return grass.length;
    }

    @Override
    public Object getItem(int i) {
        return grass[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflate.inflate(R.layout.activity_grass_layout, null);
        TextView grassTxtVw = (TextView) v.findViewById(R.id.GrassTxt);
        final TextView countTxtVw = (TextView) v.findViewById(R.id.CountTxt);
        Button plusBtn = (Button) v.findViewById(R.id.plusBtn);
        Button minusBtn = (Button) v.findViewById(R.id.minusBtn);

        String Grass = grass[i];
        grassTxtVw.setText(Grass);
        int setValue = 0;
        Settings = Ctx.getSharedPreferences("SavedItems", 0);
        if(Settings.contains(Grass)) {
            setValue = Settings.getInt(Grass, 0);
        }
        SharedPreferences.Editor edit = Settings.edit();
        countTxtVw.setText(String.valueOf(setValue));

        edit.putInt(Grass, setValue);
        edit.commit();

        plusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View p = (View)view.getParent();

                TextView GrassTxtVw = (TextView) p.findViewById(R.id.GrassTxt);
                Integer value = Integer.parseInt(countTxtVw.getText().toString());
                value++;
                Settings = Ctx.getSharedPreferences("SavedItems", 0);
                SharedPreferences.Editor edit = Settings.edit();
                edit.putInt(GrassTxtVw.getText().toString(), value);
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

                    TextView GrassTxtVw = (TextView) p.findViewById(R.id.GrassTxt);
                    value--;
                    Settings = Ctx.getSharedPreferences("SavedItems", 0);
                    SharedPreferences.Editor edit = Settings.edit();
                    edit.putInt(GrassTxtVw.getText().toString(), value);
                    edit.apply();
                    countTxtVw.setText(value.toString());
                }
            }
        });

        return v;
    }
}
