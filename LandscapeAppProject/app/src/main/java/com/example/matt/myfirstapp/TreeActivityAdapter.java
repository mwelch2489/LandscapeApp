package com.example.matt.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class TreeActivityAdapter extends BaseAdapter {
    String[] trees;
    LayoutInflater inflate;
    Context Ctx;
    SharedPreferences Settings;

    public TreeActivityAdapter(Context ctx, String[] Trees) {
        trees = Trees;
        inflate = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Ctx = ctx;
    }

    @Override
    public int getCount() { return trees.length;}

    @Override
    public Object getItem(int i) {
        return trees[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflate.inflate(R.layout.activity_tree_layout, null);
        TextView treesTxtVw = (TextView) v.findViewById(R.id.TreesTxt);
        final TextView countTxtVw = (TextView) v.findViewById(R.id.CountTxt);
        Button plusBtn = (Button) v.findViewById(R.id.plusBtn);
        Button minusBtn = (Button) v.findViewById(R.id.minusBtn);

        String Tree = trees[i];
        treesTxtVw.setText(Tree);
        int setValue = 0;
        Settings = Ctx.getSharedPreferences("TreesSaved", 0);
        if(Settings.contains(Tree)) {
            setValue = Settings.getInt(Tree, 0);
        }
        SharedPreferences.Editor edit = Settings.edit();
        countTxtVw.setText(String.valueOf(setValue));

        edit.putInt(Tree, setValue);
        edit.commit();

        plusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View p = (View)view.getParent();

            TextView treesTxtVw = (TextView) p.findViewById(R.id.TreesTxt);
            Integer value = Integer.parseInt(countTxtVw.getText().toString());
            value++;
            Settings = Ctx.getSharedPreferences("TreesSaved", 0);
            SharedPreferences.Editor edit = Settings.edit();
                edit.putInt(treesTxtVw.getText().toString(), value);
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

                    TextView treesTxtVw = (TextView) p.findViewById(R.id.TreesTxt);
                    value--;
                    Settings = Ctx.getSharedPreferences("TreesSaved", 0);
                    SharedPreferences.Editor edit = Settings.edit();
                    edit.putInt(treesTxtVw.getText().toString(), value);
                    edit.apply();
                    countTxtVw.setText(value.toString());
                }
            }
        });

        return v;
    }
}