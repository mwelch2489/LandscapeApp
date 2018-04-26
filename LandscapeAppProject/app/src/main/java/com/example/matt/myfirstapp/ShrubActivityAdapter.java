package com.example.matt.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class ShrubActivityAdapter extends BaseAdapter {
    String[] shrubs;
    LayoutInflater inflate;
    Context Ctx;
    SharedPreferences Settings;

    public ShrubActivityAdapter(Context ctx, String[] Shrubs) {
        shrubs = Shrubs;
        inflate = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Ctx = ctx;
    }

    @Override
    public int getCount() {
        return shrubs.length;
    }

    @Override
    public Object getItem(int i) {
        return shrubs[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflate.inflate(R.layout.activity_shrub_layout, null);
        TextView shrubTxtVw = (TextView) v.findViewById(R.id.ShrubsTxt);
        final TextView countTxtVw = (TextView) v.findViewById(R.id.CountTxt);
        Button plusBtn = (Button) v.findViewById(R.id.plusBtn);
        Button minusBtn = (Button) v.findViewById(R.id.minusBtn);

        String Shrub = shrubs[i];
        shrubTxtVw.setText(Shrub);
        int setValue = 0;
        Settings = Ctx.getSharedPreferences("SavedItems", 0);
        if(Settings.contains(Shrub)) {
            setValue = Settings.getInt(Shrub, 0);
        }
        SharedPreferences.Editor edit = Settings.edit();
        countTxtVw.setText(String.valueOf(setValue));

        edit.putInt(Shrub, setValue);
        edit.commit();

        plusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View p = (View)view.getParent();

                TextView shrubTxtVw = (TextView) p.findViewById(R.id.ShrubsTxt);
                Integer value = Integer.parseInt(countTxtVw.getText().toString());
                value++;
                Settings = Ctx.getSharedPreferences("SavedItems", 0);
                SharedPreferences.Editor edit = Settings.edit();
                edit.putInt(shrubTxtVw.getText().toString(), value);
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

                    TextView shrubTxtVw = (TextView) p.findViewById(R.id.ShrubsTxt);
                    value--;
                    Settings = Ctx.getSharedPreferences("SavedItems", 0);
                    SharedPreferences.Editor edit = Settings.edit();
                    edit.putInt(shrubTxtVw.getText().toString(), value);
                    edit.apply();
                    countTxtVw.setText(value.toString());
                }
            }
        });

        return v;
    }
}