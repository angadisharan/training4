package com.mathrusoft.mydemolistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.mathrusoft.mydemolistview.adapter.MyStudentAdapter;
import com.mathrusoft.mydemolistview.model.ModelStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 29/06/17.
 */

public class ActivityDemoCustomList extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_custom_list);

        mListView = (ListView) findViewById(R.id.my_custom_list);


        MyStudentAdapter myStudentAdapter = new MyStudentAdapter(this, R.layout.student_item, getDummyStudentList());
        mListView.setAdapter(myStudentAdapter);

    }


    private List<ModelStudent> getDummyStudentList() {

        List<ModelStudent> modelStudentList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            ModelStudent modelStudent = new ModelStudent();

            modelStudent.setName("StdName : " + i);
            modelStudent.setAddress("Addr : " + i);
            modelStudent.setBranch("Branch : " + i);
            modelStudent.setAge(i);

            modelStudentList.add(modelStudent);
        }


        return modelStudentList;
    }


}
