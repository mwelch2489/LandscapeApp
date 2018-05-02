package com.example.matt.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class EndActivityAdapter extends BaseAdapter {
    String[] items;
    LayoutInflater inflate;
    Context Ctx;
    SharedPreferences Settings;

    public EndActivityAdapter(Context ctx, String[] Items) {
        items = Items;
        inflate = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Ctx = ctx;
    }

    @Override
    public int getCount() { return items.length;}

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
          View v = inflate.inflate(R.layout.activity_end_layout, null);
//        TextView EndTxtVw = (TextView) v.findViewById(R.id.EstimateItemTxt);
//        final TextView countTxtVw = (TextView) v.findViewById(R.id.EstimateCountTxt);

        Settings = Ctx.getSharedPreferences("SavedItems", 0);
        String Item = items[i];
        int setValue = 0;
        if (Settings.contains(Item)) {
            if (Settings.getInt(Item, 0) > 0) {

                TextView EndTxtVw = (TextView) v.findViewById(R.id.EstimateItemTxt);
                final TextView countTxtVw = (TextView) v.findViewById(R.id.EstimateCountTxt);
                setValue = Settings.getInt(Item, 0);
                EndTxtVw.setText(Item);
                SharedPreferences.Editor edit = Settings.edit();
                countTxtVw.setText(String.valueOf(setValue));

                edit.putInt(Item, setValue);
                edit.commit();
            }
        }

        return v;
    }
}