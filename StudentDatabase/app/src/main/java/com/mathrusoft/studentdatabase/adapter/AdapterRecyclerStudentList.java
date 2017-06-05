package com.mathrusoft.studentdatabase.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.db.DataSource;
import com.mathrusoft.studentdatabase.model.Student;

import java.util.List;

/**
 * Created by sharanangadi on 05/06/17.
 */

public class AdapterRecyclerStudentList extends RecyclerView.Adapter<AdapterRecyclerStudentList.ViewHolder> {

    List<Student> mStudentList;

    public AdapterRecyclerStudentList(List<Student> list) {
        mStudentList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_card, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = mStudentList.get(position);

        holder.mTextViewName.setText(student.getName());
        holder.mTextViewBranch.setText(student.getBranch());
        holder.mTextViewAge.setText(student.getAge() + "");
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewName;
        TextView mTextViewBranch;
        TextView mTextViewAge;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextViewName = (TextView) itemView.findViewById(R.id.name);
            mTextViewBranch = (TextView) itemView.findViewById(R.id.branch);
            mTextViewAge = (TextView) itemView.findViewById(R.id.age);

        }
    }



}
