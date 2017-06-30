package com.mathrusoft.demodatabase.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mathrusoft.demodatabase.R;
import com.mathrusoft.demodatabase.db.MyDatabase;
import com.mathrusoft.demodatabase.model.ModelStudent;

import java.util.List;

/**
 * Created by sharanangadi on 30/06/17.
 */

public class FragmentGetStudentList extends Fragment {


    ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_get_student_list, null);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        View view = getView();
        mListView = (ListView) view.findViewById(R.id.my_list);

        new MyAsyncTaskFetchSrtudentList().execute();

    }


    ProgressDialog progressDialog;

    class MyAsyncTaskFetchSrtudentList extends AsyncTask<Void, Integer, List<ModelStudent>> {


        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());

            progressDialog.setMessage("Plase wait");
            progressDialog.show();

            super.onPreExecute();
        }

        @Override
        protected List<ModelStudent> doInBackground(Void... voids) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return fetchStudents();
        }


        @Override
        protected void onPostExecute(List<ModelStudent> aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.hide();
        }
    }


    private List<ModelStudent> fetchStudents() {

        MyDatabase myDatabase = MyDatabase.getInstance(getActivity());
        List<ModelStudent> modelStudentList = myDatabase.getAllStudents();

        for (ModelStudent modelStudent : modelStudentList) {
            Log.d("MYAPP", modelStudent.getBranch() + " " + modelStudent.getName());
        }

        return modelStudentList;

    }

}
