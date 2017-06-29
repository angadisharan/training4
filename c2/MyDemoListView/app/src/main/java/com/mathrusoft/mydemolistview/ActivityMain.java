package com.mathrusoft.mydemolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity {


    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.my_simple_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.my_simple_item, R.id.text1, getDummyStings());
        mListView.setAdapter(arrayAdapter);

    }


    private List<String> getDummyStings() {
        List<String> mStringList = new ArrayList<>();

        mStringList.add("Android");
        mStringList.add("PHP");
        mStringList.add("NodeJS");
        mStringList.add("ANgularJS");
        mStringList.add("Java/J2EE");
        mStringList.add("Android");
        mStringList.add("PHP");
        mStringList.add("NodeJS");
        mStringList.add("ANgularJS");
        mStringList.add("Java/J2EE");
        mStringList.add("Android");
        mStringList.add("PHP");
        mStringList.add("NodeJS");
        mStringList.add("ANgularJS");
        mStringList.add("Java/J2EE");
        mStringList.add("Android");
        mStringList.add("PHP");
        mStringList.add("NodeJS");
        mStringList.add("ANgularJS");
        mStringList.add("Java/J2EE");

        return mStringList;
    }


}
