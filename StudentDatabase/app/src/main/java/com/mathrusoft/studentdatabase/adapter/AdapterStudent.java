package com.mathrusoft.studentdatabase.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.model.Student;

import java.util.List;

/**
 * Created by sharanangadi on 02/06/17.
 */

public class AdapterStudent extends ArrayAdapter<Student> {

    List<Student> mStudentList;
    Context mContext;

    public AdapterStudent(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        mStudentList = objects;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mStudentList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_student, null);
        }

        Student student = mStudentList.get(position);

        ((TextView) convertView.findViewById(R.id.name)).setText(student.getName());
        ((TextView) convertView.findViewById(R.id.branch)).setText(student.getBranch());
        ((TextView) convertView.findViewById(R.id.age)).setText(student.getAge() + "");

        return convertView;
    }
}
