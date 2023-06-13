package com.example.funnypranksounds.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.funnypranksounds.R;
import com.example.funnypranksounds.activity.PrankActivity;

import java.util.ArrayList;

public class TimeFormatAdapter extends BaseAdapter {
    ArrayList<String> timeList = new ArrayList<>();
    int b;
    private final LayoutInflater layoutInflater;
    final Context context;
    PrankActivity prankActivity;

    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"WrongConstant"})
    public TimeFormatAdapter(Context context, ArrayList<String> arrayList, int i, PrankActivity prankActivity) {
        this.context = context;
        this.prankActivity = prankActivity;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.timeList.addAll(arrayList);
        this.b = i;
    }

    public int getCount() {
        return this.timeList.size();
    }

    public Object getItem(int i) {
        return this.timeList.get(i);
    }

    @SuppressLint("InflateParams")
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = null;
        if (view == null) {
            view = this.layoutInflater.inflate(R.layout.time_spin_list, null);
            textView = view.findViewById(R.id.textFormat);
        }
        if (textView != null) {
            textView.setText(this.timeList.get(i));
        }

        return view;
    }
}
