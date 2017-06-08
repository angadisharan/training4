package com.mathrusoft.studentdatabase.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.db.DataSource;
import com.mathrusoft.studentdatabase.model.Student;

import java.util.List;

/**
 * Created by sharanangadi on 30/05/17.
 */

public class FragmentSaveStudent extends Fragment {
    public static final String TAG = "MYAPP";


    Context mContext;

    TextView mTextViewMessage;

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

        mContext = getContext();

        View view = getView();
        mEditTextAge = (EditText) view.findViewById(R.id.student_age);
        mEditTextName = (EditText) view.findViewById(R.id.student_name);
        mEditTextBranch = (EditText) view.findViewById(R.id.student_branch);
        mTextViewMessage = (TextView) view.findViewById(R.id.message);

        mButtonSave = (Button) view.findViewById(R.id.button_save);
        mButtonSave.setOnClickListener(mOnClickListener);

    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (TextUtils.isEmpty(mEditTextName.getText().toString())){
                mEditTextName.setError("Name is empty");
                mEditTextName.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(mEditTextBranch.getText().toString())){
                mEditTextBranch.setError("Branch is empty");
                mEditTextBranch.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(mEditTextAge.getText().toString())){
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

            saveStudent(mStudent);

        }
    };

    private void saveStudent(Student mStudent) {
        DataSource dataSource = new DataSource(mContext);
        long insetId = dataSource.saveStudent(mStudent);
        Toast.makeText(mContext, " Student Saved Successfully ", Toast.LENGTH_SHORT).show();

        mTextViewMessage.setText(" Student Saved Successfully ");

        mEditTextAge.setText("");
        mEditTextName.setText("");
        mEditTextBranch.setText("");
    }


}
