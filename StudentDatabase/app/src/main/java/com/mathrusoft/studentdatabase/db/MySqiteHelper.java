package com.mathrusoft.studentdatabase.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mathrusoft.studentdatabase.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 01/06/17.
 */

public class MySqiteHelper extends SQLiteOpenHelper {

    private static final String TAG = "MYAPP:MySqiteHelper";


    private static final String DB_NAME = "student_db";
    private static final int VERSION = 3;

    private static final String TABLE_STUDENT = "student";

    private static final String CREATE_STUDENT = " create table " + TABLE_STUDENT + " ( _id INTEGER PRIMARY KEY autoincrement, name text, branch text, age double ); ";

    private static MySqiteHelper mMySqiteHelper;

    public static MySqiteHelper getInstance(Context context) {
        if (mMySqiteHelper == null) {
            mMySqiteHelper = new MySqiteHelper(context);
        }
        return mMySqiteHelper;
    }

    private MySqiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        Log.d(TAG, "MySqiteHelper inside MySqiteHelper constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "MySqiteHelper inside onCreate ");
        sqLiteDatabase.execSQL(CREATE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_STUDENT + " ; ");
        Log.d(TAG, "MySqiteHelper inside onUpgrade ");
        onCreate(sqLiteDatabase);
    }


    public long saveStudent(Student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", student.getName());
        contentValues.put("age", student.getAge());
        contentValues.put("branch", student.getBranch());

        SQLiteDatabase db = getWritableDatabase();
        long insetId = db.insert(TABLE_STUDENT, null, contentValues);
        db.close();
        return insetId;
    }


    public List<Student> getAllStudents() {

        List<Student> studentList = new ArrayList<>();

        String sql = " select * from  " + TABLE_STUDENT + " ; ";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor != null) {
            cursor.move(-1);
            while (cursor.moveToNext()) {
                Student student = new Student();

                student.setAge(cursor.getFloat(cursor.getColumnIndex("age")));
                student.setName(cursor.getString(cursor.getColumnIndex("name")));
                student.setBranch(cursor.getString(cursor.getColumnIndex("branch")));
                studentList.add(student);
            }
            cursor.close();
        }

        db.close();
        return studentList;
    }


}
