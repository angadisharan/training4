package com.mathrusoft.studentdatabase.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.adapter.AdapterStudent;
import com.mathrusoft.studentdatabase.db.DataSource;
import com.mathrusoft.studentdatabase.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 02/06/17.
 */

public class FragmentStudentList extends Fragment {


    Context mContext;

    ListView mListView;

    AdapterStudent mAdapterStudent;
    List<Student> mStudentList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_list, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mContext = getContext();

        View view = getView();
        mListView = (ListView) view.findViewById(R.id.student_list);
        mAdapterStudent = new AdapterStudent(mContext, -1, mStudentList);
        mListView.setAdapter(mAdapterStudent);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = mStudentList.get(i);
                Toast.makeText(mContext, student.getName() + " " + student.getAge(), Toast.LENGTH_SHORT).show();
            }
        });

        initStudentList();
    }

    private void initStudentList() {
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

//            SHould not assign
//            mStudentList = mDataSource.getAllStudents();

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

            mAdapterStudent.notifyDataSetChanged();
            mProgressDialog.cancel();


        }

    }


}
