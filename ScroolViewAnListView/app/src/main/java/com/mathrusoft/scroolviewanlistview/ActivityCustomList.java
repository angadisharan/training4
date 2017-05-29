package com.mathrusoft.scroolviewanlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.mathrusoft.scroolviewanlistview.adapter.AdapterStudent;
import com.mathrusoft.scroolviewanlistview.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 29/05/17.
 */

public class ActivityCustomList extends AppCompatActivity {
    ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        initDummyContent();

        mListView = (ListView) findViewById(R.id.my_list_view);
        AdapterStudent mAdapterStudent = new AdapterStudent(this, -1, mStudentList);
        mListView.setAdapter(mAdapterStudent);

    }


    List<Student> mStudentList = new ArrayList<>();

    private void initDummyContent() {
        for (int i = 0; i < 100; i++) {
            Student mStudent = new Student();
            mStudent.setName("Name" + i);
            mStudent.setBranch("Branch" + i);
            mStudent.setAge(i);

            mStudentList.add(mStudent);
        }

    }

}
