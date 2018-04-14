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

public class LaborActivityAdapter extends BaseAdapter {

    String[] labor;
    LayoutInflater inflate;
    Context Ctx;
    SharedPreferences Settings;

    public LaborActivityAdapter(Context ctx, String[] Labor) {
        labor = Labor;
        inflate = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Ctx = ctx;
    }

    @Override
    public int getCount() {
        return labor.length;
    }

    @Override
    public Object getItem(int i) {
        return labor[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflate.inflate(R.layout.activity_labor_layout, null);
        TextView laborTxtVw = (TextView) v.findViewById(R.id.LaborTxt);
        final TextView countTxtVw = (TextView) v.findViewById(R.id.CountTxt);
        Button plusBtn = (Button) v.findViewById(R.id.plusBtn);
        Button minusBtn = (Button) v.findViewById(R.id.minusBtn);

        String Labor = labor[i];
        laborTxtVw.setText(Labor);
        int setValue = 0;
        Settings = Ctx.getSharedPreferences("LaborSaved", 0);
        if(Settings.contains(Labor)) {
            setValue = Settings.getInt(Labor, 0);
        }
        SharedPreferences.Editor edit = Settings.edit();
        countTxtVw.setText(String.valueOf(setValue));

        edit.putInt(Labor, setValue);
        edit.commit();
        plusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View p = (View) view.getParent();

                TextView laborTxtVw = (TextView) p.findViewById(R.id.LaborTxt);
                Integer value = Integer.parseInt(countTxtVw.getText().toString());
                value++;
                Settings = Ctx.getSharedPreferences("LaborSaved", 0);
                SharedPreferences.Editor edit = Settings.edit();
                edit.putInt(laborTxtVw.getText().toString(), value);
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

                        TextView laborTxtVw = (TextView) p.findViewById(R.id.LaborTxt);
                        value--;
                        Settings = Ctx.getSharedPreferences("LaborSaved", 0);
                        SharedPreferences.Editor edit = Settings.edit();
                        edit.putInt(laborTxtVw.getText().toString(), value);
                        edit.apply();
                        countTxtVw.setText(value.toString());
                    }
            }
        });

        return v;
    }
}
