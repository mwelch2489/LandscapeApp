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

public class HardgoodsActivityAdapter extends BaseAdapter {
    String[] hardgoods;
    LayoutInflater inflate;
    Context Ctx;
    SharedPreferences Settings;

    public HardgoodsActivityAdapter(Context ctx, String[] Hardgoods) {
        hardgoods = Hardgoods;
        inflate = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Ctx = ctx;
    }

    @Override
    public int getCount() {
        return hardgoods.length;
    }

    @Override
    public Object getItem(int i) {
        return hardgoods[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflate.inflate(R.layout.activity_hardgoods_layout, null);
        TextView hardgoodsTxtVw = (TextView) v.findViewById(R.id.HardgoodsTxt);
        final TextView countTxtVw = (TextView) v.findViewById(R.id.CountTxt);
        Button plusBtn = (Button) v.findViewById(R.id.plusBtn);
        Button minusBtn = (Button) v.findViewById(R.id.minusBtn);

        String Hardgoods = hardgoods[i];


        hardgoodsTxtVw.setText(Hardgoods);
        int setValue = 0;
        Settings = Ctx.getSharedPreferences("SavedItems", 0);
        if(Settings.contains(Hardgoods)) {
            setValue = Settings.getInt(Hardgoods, 0);
        }
        SharedPreferences.Editor edit = Settings.edit();
        countTxtVw.setText(String.valueOf(setValue));

        edit.putInt(Hardgoods, setValue);
        edit.commit();

        plusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View p = (View)view.getParent();

                TextView hardgoodsTxtVw = (TextView) p.findViewById(R.id.HardgoodsTxt);
                Integer value = Integer.parseInt(countTxtVw.getText().toString());
                value++;
                Settings = Ctx.getSharedPreferences("SavedItems", 0);
                SharedPreferences.Editor edit = Settings.edit();
                edit.putInt(hardgoodsTxtVw.getText().toString(), value);
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

                    TextView hardgoodsTxtVw = (TextView) p.findViewById(R.id.HardgoodsTxt);
                    value--;
                    Settings = Ctx.getSharedPreferences("SavedItems", 0);
                    SharedPreferences.Editor edit = Settings.edit();
                    edit.putInt(hardgoodsTxtVw.getText().toString(), value);
                    edit.apply();
                    countTxtVw.setText(value.toString());
                }
            }
        });

        return v;
    }
}
