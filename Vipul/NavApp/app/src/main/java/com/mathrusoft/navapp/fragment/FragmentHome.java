package com.mathrusoft.navapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mathrusoft.navapp.R;

/**
 * Created by sharanangadi on 24/06/17.
 */

public class FragmentHome extends Fragment {


    @Override
    public void onStart() {
        Log.d("MYAPP", "onStart");
        super.onStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("MYAPP", "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        Log.d("MYAPP", "onAttach");
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Log.d("MYAPP", "onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.d("MYAPP", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("MYAPP", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("MYAPP", "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("MYAPP", "onCreateView");
        return inflater.inflate(R.layout.fragment_home, null);
    }
}
