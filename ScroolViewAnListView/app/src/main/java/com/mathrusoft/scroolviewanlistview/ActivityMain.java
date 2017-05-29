package com.mathrusoft.scroolviewanlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActivityMain extends AppCompatActivity {

    ListView mListView;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_list_view_holder);

        mContext = this.getApplicationContext();

        initDummyContent();

        mListView = (ListView) findViewById(R.id.my_list_view);

        ArrayAdapter simpleAdapter = new ArrayAdapter(mContext, R.layout.simple_item, R.id.my_text, mData);
        mListView.setAdapter(simpleAdapter);
    }

    String[] mData = new String[100];

    private void initDummyContent() {
        for (int i = 0; i < 100; i++) {
            mData[i] = "Data " + i;
        }
    }


}
