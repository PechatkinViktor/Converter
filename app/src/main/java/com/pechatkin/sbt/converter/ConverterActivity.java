package com.pechatkin.sbt.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.pechatkin.sbt.converter.adapters.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConverterActivity extends AppCompatActivity {

    public static final String CONVERSION = "Conversion";

    private EditText mLeftEditText;
    private EditText mRightEditText;
    private Spinner mLeftSpinner;
    private Spinner mRightSpinner;

    private Conversion mConversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        init();
        setUpSpinner(mLeftSpinner);
        setUpSpinner(mRightSpinner);
        setUpEditTexts();
    }

    private void setUpEditTexts() {
        mLeftEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                convert(getValueFromLeftTextEdit());
            }
        });
    }

    private double getValueFromLeftTextEdit(){
        double value;
        String stringFromLeftEditText = mLeftEditText.getText().toString();
        try {
            value = Double.parseDouble(stringFromLeftEditText);
        }catch (Exception e){
            value = 0f;
        }
        return value;
    }

    private void convert(double value){
        Values leftUnit = (Values) mLeftSpinner.getSelectedItem();
        Values rightUnit = (Values) mRightSpinner.getSelectedItem();
        double tempValue = leftUnit.mConvertToBase * value;
        mRightEditText.setText(String.valueOf(tempValue * rightUnit.mConvertFromBase));
    }

    private void setUpSpinner(Spinner spinner) {
        final List<Values> units = new ArrayList<>();
        units.addAll(mConversion.mValuesList);
        SpinnerAdapter adapter = new SpinnerAdapter(units);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convert(getValueFromLeftTextEdit());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void init() {
        mLeftEditText = findViewById(R.id.edit_text_to);
        mRightEditText = findViewById(R.id.edit_text_from);
        mLeftSpinner = findViewById(R.id.spinner_to);
        mRightSpinner = findViewById(R.id.spinner_from);
        mConversion = (Conversion) getIntent().getSerializableExtra(CONVERSION);
        if(mConversion == null) {
            mConversion = Conversion.LENGTH;
        }
        TextView mHeader = findViewById(R.id.text_view_label);
        mHeader.setText(mConversion.mLabelRes);
    }
}
