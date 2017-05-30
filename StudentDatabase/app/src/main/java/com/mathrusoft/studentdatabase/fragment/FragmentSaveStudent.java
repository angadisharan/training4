package com.mathrusoft.studentdatabase.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.model.Student;

/**
 * Created by sharanangadi on 30/05/17.
 */

public class FragmentSaveStudent extends Fragment {
    public static final String TAG = "MYAPP";


    EditText mEditTextName;
    EditText mEditTextAge;
    EditText mEditTextBranch;

    Button mButtonSave;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_save_student, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        mEditTextAge = (EditText) view.findViewById(R.id.student_age);
        mEditTextName = (EditText) view.findViewById(R.id.student_name);
        mEditTextBranch = (EditText) view.findViewById(R.id.student_branch);

        mButtonSave = (Button) view.findViewById(R.id.button_save);
        mButtonSave.setOnClickListener(mOnClickListener);


    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
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

            saveStudent(mStudent);
            
        }
    };

    private void saveStudent(Student mStudent) {

    }

}
