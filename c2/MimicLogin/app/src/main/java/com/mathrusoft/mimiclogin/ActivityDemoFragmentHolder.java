package com.mathrusoft.mimiclogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mathrusoft.mimiclogin.fragment.FragmentHome;

/**
 * Created by sharanangadi on 27/06/17.
 */

public class ActivityDemoFragmentHolder extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_frag_holder);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_holder, new FragmentHome());
        fragmentTransaction.commit();



    }
}
