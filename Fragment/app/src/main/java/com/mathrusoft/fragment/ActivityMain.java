package com.mathrusoft.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mathrusoft.fragment.fragment.FragmentCamera;
import com.mathrusoft.fragment.fragment.FragmentGallery;

public class ActivityMain extends AppCompatActivity {

    FragmentCamera mFragmentCamera = new FragmentCamera();
    FragmentGallery mFragmentGallery = new FragmentGallery();


    Button mButtonGallery;
    Button mButtonCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButtonCamera = (Button) findViewById(R.id.button_camera);
        mButtonGallery = (Button) findViewById(R.id.button_gallery);


        mButtonCamera.setOnClickListener(mOnClickListener);
        mButtonGallery.setOnClickListener(mOnClickListener);

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_camera:
                    replaceFragment(mFragmentCamera);
                    break;
                case R.id.button_gallery:
                    replaceFragment(mFragmentGallery);
                    break;
            }
        }
    };


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_holder, fragment);
        fragmentTransaction.commit();

    }
}
