package com.mathrusoft.studentdatabase;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mathrusoft.studentdatabase.adapter.MyFragmentAdapter;
import com.mathrusoft.studentdatabase.fragment.FragmentSaveStudent;
import com.mathrusoft.studentdatabase.fragment.FragmentStudentList;
import com.mathrusoft.studentdatabase.fragment.FragmentStudentRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 07/06/17.
 */

public class ActivityPageViewer extends AppCompatActivity {

    MyFragmentAdapter myFragmentAdapter;

    ViewPager mViewPager;


    TabLayout mTabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page_viewer);


        mTabLayout = (TabLayout) findViewById(R.id.my_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.my_view_pager);

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), getFragmentList(), getTitles());

        mViewPager.setAdapter(myFragmentAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private List<String> getTitles() {
        List<String> titleList = new ArrayList<>();

        titleList.add("Add Student");
        titleList.add("Student List");
        titleList.add("Student Recycler View");

        return titleList;
    }


    private List<Fragment> getFragmentList() {

        List<Fragment> mFragmentList = new ArrayList<>();

        mFragmentList.add(new FragmentSaveStudent());
        mFragmentList.add(new FragmentStudentList());
        mFragmentList.add(new FragmentStudentRecyclerView());


        return mFragmentList;
    }
}
