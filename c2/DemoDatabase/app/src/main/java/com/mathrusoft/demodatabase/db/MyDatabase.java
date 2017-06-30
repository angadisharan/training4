package com.mathrusoft.demodatabase.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mathrusoft.demodatabase.model.ModelStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 30/06/17.
 */

public class MyDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME = "MYDB";
    private static final int VERSION = 1;

    private static final String NAME = "name";

    private static final String CREATE_STUDENT = " create table student ( _id integer primary key autoincrement, " + NAME + " text, branch text );  ";


    static private MyDatabase myDatabase;

    static public MyDatabase getInstance(Context context) {
        if (myDatabase == null) {
            myDatabase = new MyDatabase(context);
        }
        return myDatabase;
    }

    private MyDatabase(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS student ");
        onCreate(sqLiteDatabase);
    }


    public long saveStudent(ModelStudent modelStudent) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        long insertId = -1;

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, modelStudent.getName());
        contentValues.put("branch", modelStudent.getBranch());

        insertId = sqLiteDatabase.insert("student", null, contentValues);

        sqLiteDatabase.close();
        return insertId;
    }

    public List<ModelStudent> getAllStudents() {

        List<ModelStudent> modelStudentList = new ArrayList<>();
        String sql = " select * from student ";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor != null) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {

                ModelStudent modelStudent = new ModelStudent();
                modelStudent.setBranch(cursor.getString(cursor.getColumnIndex("branch")));
                modelStudent.setName(cursor.getString(cursor.getColumnIndex("name")));

                modelStudentList.add(modelStudent);
            }
            cursor.close();
        }


        db.close();

        return modelStudentList;
    }


}
