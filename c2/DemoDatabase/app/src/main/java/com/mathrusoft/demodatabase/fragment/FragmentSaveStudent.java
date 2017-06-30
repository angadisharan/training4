package com.mathrusoft.demodatabase.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.demodatabase.R;
import com.mathrusoft.demodatabase.db.MyDatabase;
import com.mathrusoft.demodatabase.model.ModelStudent;

/**
 * Created by sharanangadi on 30/06/17.
 */

public class FragmentSaveStudent extends Fragment {


    EditText mEditTextName;
    EditText mEditTextBranch;
    Button mButtonSave;


    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_save_studnet, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        mEditTextName = (EditText) view.findViewById(R.id.name);
        mEditTextBranch = (EditText) view.findViewById(R.id.branch);

        mButtonSave = (Button) view.findViewById(R.id.save_student);
        mButtonSave.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            ModelStudent modelStudent = new ModelStudent();
            modelStudent.setBranch(mEditTextBranch.getText().toString());
            modelStudent.setName(mEditTextName.getText().toString());

            MyDatabase myDatabase = MyDatabase.getInstance(mContext);
            long id = myDatabase.saveStudent(modelStudent);

            Toast.makeText(mContext, "inserted " + id, Toast.LENGTH_SHORT).show();
        }
    };

}
