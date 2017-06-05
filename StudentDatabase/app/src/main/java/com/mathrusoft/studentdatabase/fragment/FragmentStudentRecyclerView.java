package com.mathrusoft.studentdatabase.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.adapter.AdapterRecyclerStudentList;
import com.mathrusoft.studentdatabase.db.DataSource;
import com.mathrusoft.studentdatabase.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 05/06/17.
 */

public class FragmentStudentRecyclerView extends Fragment {

    Context mContext;
    RecyclerView mRecyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_recycler_view, null);
    }

    AdapterRecyclerStudentList mAdapterRecyclerStudentList;
    List<Student> mStudentList = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView = (RecyclerView) getView().findViewById(R.id.student_recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapterRecyclerStudentList = new AdapterRecyclerStudentList(mStudentList);
        mRecyclerView.setAdapter(mAdapterRecyclerStudentList);

        getDataFromDB();
    }


    private void getDataFromDB() {
        new AsyncFetchStudentList().execute();
    }


    ProgressDialog mProgressDialog;

    class AsyncFetchStudentList extends AsyncTask<Void, Void, List<Student>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Please wait...");
            mProgressDialog.show();
        }

        @Override
        protected List<Student> doInBackground(Void... voids) {
            DataSource mDataSource = new DataSource(mContext);
            return mDataSource.getAllStudents();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<Student> students) {
            super.onPostExecute(students);
            mStudentList.clear();
            mStudentList.addAll(students);
            mAdapterRecyclerStudentList.notifyDataSetChanged();
            mProgressDialog.cancel();
        }

    }


}
