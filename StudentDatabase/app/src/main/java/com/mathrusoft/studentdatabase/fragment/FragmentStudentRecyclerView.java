package com.mathrusoft.studentdatabase.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.adapter.AdapterRecyclerStudentList;
import com.mathrusoft.studentdatabase.callback.CallbackStudentItemAction;
import com.mathrusoft.studentdatabase.db.DataSource;
import com.mathrusoft.studentdatabase.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 05/06/17.
 */

public class FragmentStudentRecyclerView extends Fragment {

    private static final String TAG = "MYAPP:FragmentRecyclerV";

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

        mAdapterRecyclerStudentList = new AdapterRecyclerStudentList(mStudentList, mCallbackStudentItemAction);
        mRecyclerView.setAdapter(mAdapterRecyclerStudentList);

        getDataFromDB();
    }

    CallbackStudentItemAction mCallbackStudentItemAction = new CallbackStudentItemAction() {
        @Override
        public void editStudent(int position) {
            showEditDialog(position);
            Toast.makeText(mContext, " position edit " + position, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void deleteStudent(int position) {
            new AsyncTaskDeleteStudent().execute(mStudentList.get(position));
        }
    };


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


    class AsyncTaskDeleteStudent extends AsyncTask<Student, Void, Void> {

        Student mTempStudent;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Please wait...");
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Student... student) {
            mTempStudent = student[0];
            DataSource mDataSource = new DataSource(mContext);
            mDataSource.deleteStudent(student[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgressDialog.dismiss();
            mStudentList.remove(mTempStudent);
            mAdapterRecyclerStudentList.notifyDataSetChanged();

            Toast.makeText(mContext, " Student deleted ", Toast.LENGTH_SHORT).show();
        }
    }


    private void showEditDialog(final int position) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_save_student);

        final EditText mEditTextName;
        final EditText mEditTextAge;
        final EditText mEditTextBranch;

        Button mButtonSave;

        mEditTextAge = (EditText) dialog.findViewById(R.id.student_age);
        mEditTextName = (EditText) dialog.findViewById(R.id.student_name);
        mEditTextBranch = (EditText) dialog.findViewById(R.id.student_branch);


        Student student = mStudentList.get(position);

        mEditTextAge.setText(student.getAge() + "");
        mEditTextName.setText(student.getName());
        mEditTextBranch.setText(student.getBranch());

        mButtonSave = (Button) dialog.findViewById(R.id.button_save);

        View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

                if (TextUtils.isEmpty(mEditTextName.getText().toString())) {
                    mEditTextName.setError("Name is empty");
                    mEditTextName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(mEditTextBranch.getText().toString())) {
                    mEditTextBranch.setError("Branch is empty");
                    mEditTextBranch.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(mEditTextAge.getText().toString())) {
                    mEditTextAge.setError("Age is empty");
                    mEditTextAge.requestFocus();
                    return;
                }

                Student mStudent = new Student();
                float age = 0;
                try {
                    age = Float.parseFloat(mEditTextAge.getText().toString());
                } catch (Exception e) {
                    Log.d(TAG, " exception " + e.getMessage());
                }

                mStudent.setAge(age);
                mStudent.setBranch(mEditTextBranch.getText().toString());
                mStudent.setName(mEditTextName.getText().toString());

                updateDatabase(mStudent, position);

            }
        };

        mButtonSave.setOnClickListener(mOnClickListener);

        dialog.show();

    }

    private void updateDatabase(Student student, int position) {

        Student actualStudent = mStudentList.get(position);
        actualStudent.setAge(student.getAge());
        actualStudent.setName(student.getName());
        actualStudent.setBranch(student.getBranch());

        DataSource mDataSource = new DataSource(mContext);
        long result = mDataSource.updateStudent(actualStudent);

        Toast.makeText(mContext, " result " + result, Toast.LENGTH_SHORT).show();


        mAdapterRecyclerStudentList.notifyDataSetChanged();
    }


}
