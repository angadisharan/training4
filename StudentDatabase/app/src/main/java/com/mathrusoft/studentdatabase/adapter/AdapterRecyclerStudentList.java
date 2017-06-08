package com.mathrusoft.studentdatabase.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mathrusoft.studentdatabase.R;
import com.mathrusoft.studentdatabase.callback.CallbackStudentItemAction;
import com.mathrusoft.studentdatabase.model.Student;

import java.util.List;

/**
 * Created by sharanangadi on 05/06/17.
 */

public class AdapterRecyclerStudentList extends RecyclerView.Adapter<AdapterRecyclerStudentList.ViewHolder> {

    List<Student> mStudentList;
    CallbackStudentItemAction mCallbackStudentItemAction;

    public AdapterRecyclerStudentList(List<Student> list, CallbackStudentItemAction callbackStudentItemAction) {
        mStudentList = list;
        mCallbackStudentItemAction = callbackStudentItemAction;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_card, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Student student = mStudentList.get(position);

        holder.mTextViewName.setText(student.getName());
        holder.mTextViewBranch.setText(student.getBranch());
        holder.mTextViewAge.setText(student.getAge() + "");

        View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.image_edit:
                        mCallbackStudentItemAction.editStudent(position);
                        break;
                    case R.id.image_delete:
                        mCallbackStudentItemAction.deleteStudent(position);
                        break;
                }
            }
        };

        holder.mImageViewEdit.setOnClickListener(mOnClickListener);
        holder.mImageViewDelete.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewName;
        TextView mTextViewBranch;
        TextView mTextViewAge;

        ImageView mImageViewEdit;
        ImageView mImageViewDelete;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextViewName = (TextView) itemView.findViewById(R.id.name);
            mTextViewBranch = (TextView) itemView.findViewById(R.id.branch);
            mTextViewAge = (TextView) itemView.findViewById(R.id.age);

            mImageViewEdit = (ImageView) itemView.findViewById(R.id.image_edit);
            mImageViewDelete = (ImageView) itemView.findViewById(R.id.image_delete);
        }
    }


}
