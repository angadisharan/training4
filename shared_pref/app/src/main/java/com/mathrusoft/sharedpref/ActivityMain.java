package com.mathrusoft.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    EditText mEditTextData;
    Button mButtonSave;
    Button mButtonFetchData;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();

        mEditTextData = (EditText) findViewById(R.id.edittext_data);
        mButtonSave = (Button) findViewById(R.id.button_save);
        mButtonFetchData = (Button) findViewById(R.id.button_fetch_data);

        mButtonSave.setOnClickListener(mOnClickListener);
        mButtonFetchData.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.button_fetch_data:
                    fetchAction();
                    break;
                case R.id.button_save:
                    saveAction();
                    break;
            }

        }
    };

    private void saveAction() {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String data = mEditTextData.getText().toString();

        editor.putString("data", data);
        editor.commit();

        mEditTextData.setText("");
        Toast.makeText(mContext, "Saved to Pref ", Toast.LENGTH_SHORT).show();
    }

    private void fetchAction() {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);

        String data = sharedPreferences.getString("data", "No Data");

        Toast.makeText(mContext, "Pref data " + data, Toast.LENGTH_SHORT).show();

    }
}
