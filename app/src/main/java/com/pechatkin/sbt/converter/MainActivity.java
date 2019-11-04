package com.pechatkin.sbt.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.pechatkin.sbt.converter.adapters.RecyclerAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements RecyclerOnClickListener{

    public static final String CONVERSION = "Conversion";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerAdapter adapter = new RecyclerAdapter(this);
        adapter.setValues(Arrays.asList(Conversion.values()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(Conversion conversion) {
        Intent intent = new Intent(this, ConverterActivity.class);
        intent.putExtra(CONVERSION, conversion);
        startActivity(intent);
    }
}
