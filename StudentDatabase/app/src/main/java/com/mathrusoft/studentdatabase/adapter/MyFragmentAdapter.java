package com.mathrusoft.studentdatabase.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by sharanangadi on 07/06/17.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragmentList;
    List<String> mTitleList;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        mFragmentList = fragmentList;
        mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
