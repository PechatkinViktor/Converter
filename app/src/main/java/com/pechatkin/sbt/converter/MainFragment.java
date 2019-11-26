package com.pechatkin.sbt.converter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.pechatkin.sbt.converter.adapters.RecyclerAdapter;

import java.util.Arrays;

public class MainFragment extends Fragment implements RecyclerOnClickListener{

    public static final String CONVERSION = "Conversion";

    public static MainFragment newInstance() {

        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private MainFragment(){
        super(R.layout.fragment_main);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment = super.onCreateView(inflater, container, savedInstanceState);
        RecyclerView recyclerView = fragment.findViewById(R.id.recycler);
        RecyclerAdapter adapter = new RecyclerAdapter(this);
        adapter.setValues(Arrays.asList(Conversion.values()));
        recyclerView.setAdapter(adapter);
        return fragment;
    }

    @Override
    public void onClick(Conversion conversion) {
        getFragmentManager().beginTransaction()
                .replace(R.id.main_ativity, ConverterFragment.newInstance(conversion))
                .addToBackStack(null)
                .commit();

    }
}
