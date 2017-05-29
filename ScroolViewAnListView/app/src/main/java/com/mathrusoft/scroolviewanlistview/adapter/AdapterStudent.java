package com.mathrusoft.scroolviewanlistview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.scroolviewanlistview.R;
import com.mathrusoft.scroolviewanlistview.model.Student;

import java.util.List;

/**
 * Created by sharanangadi on 29/05/17.
 */

public class AdapterStudent extends ArrayAdapter<Student> {

    List<Student> mDataList;
    Context mContext;

    public AdapterStudent(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        mContext = context;
        mDataList = objects;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listitem_student, null);
        }

        Student student = mDataList.get(position);

        ((TextView) convertView.findViewById(R.id.name)).setText(student.getName());
        ((TextView) convertView.findViewById(R.id.age)).setText(student.getAge() + "");
        ((TextView) convertView.findViewById(R.id.branch)).setText(student.getBranch());


        return convertView;

    }
}
