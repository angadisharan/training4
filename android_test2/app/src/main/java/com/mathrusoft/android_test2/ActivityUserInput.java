package com.mathrusoft.android_test2;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by sharanangadi on 20/06/17.
 */

public class ActivityUserInput extends AppCompatActivity {

    EditText mEditTextUserName;
    EditText mEditTextUserPassword;

    RadioGroup mRadioGroupGender;

    CheckBox mCheckBoxAndroid;
    CheckBox mCheckBoxNodejs;
    CheckBox mCheckBoxReacjs;

    Button mButtonSubmit;

    String mGender = "";
    String mCourse = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_input);

        mEditTextUserName = (EditText) findViewById(R.id.user_name);
        mEditTextUserPassword = (EditText) findViewById(R.id.password);

        mRadioGroupGender = (RadioGroup) findViewById(R.id.gender);
        mRadioGroupGender.setOnCheckedChangeListener(mOnCheckedChangeListener);

        mCheckBoxAndroid = (CheckBox) findViewById(R.id.android);
        mCheckBoxNodejs = (CheckBox) findViewById(R.id.nodejs);
        mCheckBoxReacjs = (CheckBox) findViewById(R.id.reactjs);

        mCheckBoxAndroid.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);
        mCheckBoxNodejs.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);
        mCheckBoxReacjs.setOnCheckedChangeListener(mOnCheckboxCheckedChangeListener);

        mButtonSubmit = (Button) findViewById(R.id.submit);
        mButtonSubmit.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String userName = mEditTextUserName.getText().toString();
            String password = mEditTextUserPassword.getText().toString();


            String tostString = userName + " : " + password + ":gender=" + mGender + " : mCourse = " + mCourse;

            Toast.makeText(ActivityUserInput.this, tostString, Toast.LENGTH_SHORT).show();
        }
    };

    RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
            switch (id) {
                case R.id.male:
                    mGender = "MALE";
                    break;
                case R.id.female:
                    mGender = "FEMALE";
                    break;
            }
        }
    };


    CompoundButton.OnCheckedChangeListener mOnCheckboxCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()) {
                case R.id.android:
                    mCourse = mCourse + "ANDROID,";
                    break;
                case R.id.nodejs:
                    mCourse = mCourse + "NODEJS,";
                    break;
                case R.id.reactjs:
                    mCourse = mCourse + "REACTJS,";
                    break;
            }
        }
    };


}
