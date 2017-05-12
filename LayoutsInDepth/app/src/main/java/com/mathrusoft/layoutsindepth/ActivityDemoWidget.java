package com.mathrusoft.layoutsindepth;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by sharanangadi on 12/05/17.
 */

public class ActivityDemoWidget extends AppCompatActivity {


    RadioGroup mRadioGroup;

    CheckBox mCheckBoxAndroi;
    CheckBox mCheckBoxPython;
    CheckBox mCheckBoxPHP;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_widget);


        mCheckBoxAndroi = (CheckBox) findViewById(R.id.checkbox_android);
        mCheckBoxPython = (CheckBox) findViewById(R.id.checkbox_python);
        mCheckBoxPHP = (CheckBox) findViewById(R.id.checkbox_php);


        mCheckBoxAndroi.setOnCheckedChangeListener(mOnCheckedChangeListenerCheckbox);
        mCheckBoxPython.setOnCheckedChangeListener(mOnCheckedChangeListenerCheckbox);
        mCheckBoxPHP.setOnCheckedChangeListener(mOnCheckedChangeListenerCheckbox);


        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group_gender);
        mRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
            switch (id) {
                case R.id.radio_female:
                    Toast.makeText(ActivityDemoWidget.this, "Female selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radio_male:
                    Toast.makeText(ActivityDemoWidget.this, "Male selected", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    CompoundButton.OnCheckedChangeListener mOnCheckedChangeListenerCheckbox = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()) {
                case R.id.checkbox_android:
                    Toast.makeText(ActivityDemoWidget.this, "ANdorid selected " + b, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_php:
                    Toast.makeText(ActivityDemoWidget.this, "PHP selected " + b, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_python:
                    Toast.makeText(ActivityDemoWidget.this, "Python selected " + b, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


}
