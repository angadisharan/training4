package com.mathrusoft.studentdatabase.db;

import android.content.Context;

import com.mathrusoft.studentdatabase.model.Student;

import java.util.List;

/**
 * Created by sharanangadi on 01/06/17.
 */

public class DataSource {

    MySqiteHelper mMySqiteHelper;

    public DataSource(Context context) {
        mMySqiteHelper = MySqiteHelper.getInstance(context);
    }


    public long saveStudent(Student student) {
        return mMySqiteHelper.saveStudent(student);
    }

    public List<Student> getAllStudents() {
        return mMySqiteHelper.getAllStudents();
    }

}
