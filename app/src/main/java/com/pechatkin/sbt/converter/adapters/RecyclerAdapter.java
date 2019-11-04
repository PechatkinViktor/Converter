package com.pechatkin.sbt.converter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.pechatkin.sbt.converter.Conversion;
import com.pechatkin.sbt.converter.R;
import com.pechatkin.sbt.converter.RecyclerOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends Adapter<RecyclerAdapter.ViewHolder> {

    private List<Conversion> mConventers;
    private RecyclerOnClickListener mListener;

    public RecyclerAdapter(RecyclerOnClickListener listener) {

        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(mConventers.get(position));
    }

    @Override
    public int getItemCount() {
        return mConventers.size();
    }

    public void setValues(List<Conversion> mUnits) {
        this.mConventers = new ArrayList<>(mUnits);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mName;
        private final RecyclerOnClickListener mListener;

        ViewHolder(@NonNull View itemView, RecyclerOnClickListener listener) {
            super(itemView);
            mListener = listener;
            mName = itemView.findViewById(R.id.name_of_value);
        }

        void bindView(final Conversion conversion) {
            mName.setText(mName.getContext().getResources().getString(conversion.mLabelRes));
            mName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(conversion);
                }
            });
        }
    }
}
