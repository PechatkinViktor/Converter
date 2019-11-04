package com.pechatkin.sbt.converter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pechatkin.sbt.converter.R;
import com.pechatkin.sbt.converter.Values;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    private List<Values> mValues;

    public SpinnerAdapter(List<Values> values) {
        mValues = new ArrayList<>(values);
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Object getItem(int i) {
        return mValues.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            ViewHolder holder = new ViewHolder(view);
            view.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.mValue.setText(mValues.get(i).mLabelRes);
        return view;
        }

    private class ViewHolder{
        private final TextView mValue;

        ViewHolder(View view){
            mValue = view.findViewById(android.R.id.text1);
            mValue.setTextSize(mValue.getResources().getDimension(R.dimen.spinner_text_size));
        }
    }
}
