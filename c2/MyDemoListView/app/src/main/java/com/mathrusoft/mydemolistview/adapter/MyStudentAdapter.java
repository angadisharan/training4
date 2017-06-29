package com.mathrusoft.mydemolistview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.mydemolistview.R;
import com.mathrusoft.mydemolistview.model.ModelStudent;

import java.util.List;

/**
 * Created by sharanangadi on 29/06/17.
 */

public class MyStudentAdapter extends ArrayAdapter<ModelStudent> {

    List<ModelStudent> mModelStudentList;
    Context mContext;
    int mItemResource = -1;

    public MyStudentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ModelStudent> list) {
        super(context, resource, list);

        mItemResource = resource;
        mContext = context;
        mModelStudentList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mItemResource, null);
        }

        ModelStudent modelStudent = mModelStudentList.get(position);


        ((TextView) convertView.findViewById(R.id.student_title)).setText(modelStudent.getName());
        ((TextView) convertView.findViewById(R.id.student_branch)).setText(modelStudent.getBranch());
        ((TextView) convertView.findViewById(R.id.student_address)).setText(modelStudent.getAddress());


        return convertView;
    }

    @Override
    public int getCount() {
        return mModelStudentList.size();
    }
}
