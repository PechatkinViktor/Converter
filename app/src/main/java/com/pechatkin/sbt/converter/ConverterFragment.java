package com.pechatkin.sbt.converter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pechatkin.sbt.converter.adapters.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConverterFragment extends Fragment {

    public static final String CONVERSION = "Conversion";

    private EditText mLeftEditText;
    private EditText mRightEditText;
    private Spinner mLeftSpinner;
    private Spinner mRightSpinner;

    private Conversion mConversion;

    public ConverterFragment() {
        super(R.layout.converter_main);
    }

    public static ConverterFragment newInstance(Conversion conversion) {

        Bundle args = new Bundle();
        ConverterFragment fragment = new ConverterFragment();
        int value = conversion.ordinal();
        args.putSerializable(CONVERSION, conversion);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment = super.onCreateView(inflater, container, savedInstanceState);

        init(fragment);
        setUpSpinner(mLeftSpinner);
        setUpSpinner(mRightSpinner);
        setUpEditTexts();

        return fragment;

    }

    private void init(View fragment){
        mConversion = (Conversion) getArguments().getSerializable(CONVERSION);
        mLeftEditText = fragment.findViewById(R.id.edit_text_to);
        mRightEditText = fragment.findViewById(R.id.edit_text_from);
        mLeftSpinner = fragment.findViewById(R.id.spinner_to);
        mRightSpinner = fragment.findViewById(R.id.spinner_from);
        if(mConversion == null) {
            mConversion = Conversion.LENGTH;
        }
        TextView mHeader = fragment.findViewById(R.id.text_view_label);
        mHeader.setText(mConversion.mLabelRes);
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


}
