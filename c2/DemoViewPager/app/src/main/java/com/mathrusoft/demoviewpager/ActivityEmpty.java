package com.mathrusoft.demoviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mathrusoft.demoviewpager.adapter.MyPagerAdapter;
import com.mathrusoft.demoviewpager.fragment.FragmentFour;
import com.mathrusoft.demoviewpager.fragment.FragmentOne;
import com.mathrusoft.demoviewpager.fragment.FragmentThree;
import com.mathrusoft.demoviewpager.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class ActivityEmpty extends AppCompatActivity {

    ViewPager mViewPager;

    MyPagerAdapter myPagerAdapter;

    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList(), fragmentTitles());

        mViewPager = (ViewPager) findViewById(R.id.my_view_pager);
        mViewPager.setAdapter(myPagerAdapter);


        mTabLayout = (TabLayout) findViewById(R.id.my_tablayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private List<Fragment> fragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());

        return fragmentList;
    }

    private List<String> fragmentTitles() {
        List<String> titleList = new ArrayList<>();

        titleList.add("Fragment One");
        titleList.add("Fragment Two");
        titleList.add("Fragment Three");
        titleList.add("Fragment Four");
        return titleList;
    }
}
