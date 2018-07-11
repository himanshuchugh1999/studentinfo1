package com.brillicaservices.studentinfo;

/**
 * Created by HIMANSHU CHUGH on 10-07-2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    /*
    * Database details*/
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student_db";

    /*
    * Student_Record table details*/
    private static final String TABLE_NAME = "student_record";
    private static final String STUDENT_NAME = "student_name";
    private static final String STUDENT_ID = "student_id";
    private static final String STUDENT_COLLEGE = "student_college";
    private static final String STUDENT_ADDRESS = "student_address";
    private static final String STUDENT_PHONE_NUMBER = "student_phone";
    private static final String STUDENT_PASSWORD = "student_password";
    /*
    * Table structure*/
    private static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + " ( " +
            STUDENT_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " TEXT, " +
            STUDENT_COLLEGE + " TEXT, " + STUDENT_ADDRESS
            + " TEXT, " + STUDENT_PHONE_NUMBER + " INTEGER, " + STUDENT_PASSWORD + " TEXT  ); ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }


    public long addNewStudent(student studentModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENT_NAME, studentModel.studentName);
        contentValues.put(STUDENT_COLLEGE, studentModel.collegeName);
        contentValues.put(STUDENT_ADDRESS, studentModel.addName);
        contentValues.put(STUDENT_PHONE_NUMBER, studentModel.ph);
        contentValues.put(STUDENT_PASSWORD, studentModel.passwords);

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();

        return id;
    }

    public student getSingleStudentDetails(long id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{STUDENT_ID, STUDENT_NAME, STUDENT_COLLEGE, STUDENT_ADDRESS,
                        STUDENT_PHONE_NUMBER}, STUDENT_ID + "=?", new String[]{String.valueOf(id)}, null, null,
                null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        student studentModel = new student(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)),
                cursor.getString(cursor.getColumnIndex(STUDENT_NAME)), cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE)), cursor.getLong(cursor.getColumnIndex(STUDENT_PHONE_NUMBER)),
                cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS)), cursor.getString(cursor.getColumnIndex(STUDENT_PASSWORD)));

        cursor.close();

        return studentModel;
    }

    public List<student> allStudentsDetails() {
        List<student> studentsList = new ArrayList<>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                student studentModel = new student();
                studentModel.setId(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)));
                studentModel.setName(cursor.getString(cursor.getColumnIndex(STUDENT_NAME)));
                studentModel.setCollegeName(cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE)));
                studentModel.setAddress(cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS)));
                studentModel.setPhoneNumber(cursor.getLong(cursor.getColumnIndex(STUDENT_PHONE_NUMBER)));

                studentsList.add(studentModel);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();

        return studentsList;
    }

    public int getStudentsCount() {

        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        int totalStudentsCount = cursor.getCount();
        cursor.close();

        return totalStudentsCount;
    }

    public int updateIndividualStudentDetails(student studentModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STUDENT_NAME, studentModel.getName());
        values.put(STUDENT_COLLEGE, studentModel.getCollegeName());
        values.put(STUDENT_ADDRESS, studentModel.getAddress());
        values.put(STUDENT_PHONE_NUMBER, studentModel.getPhoneNumber());
        values.put(STUDENT_PASSWORD, studentModel.getPasswords());

        // updating row
        return sqLiteDatabase.update(TABLE_NAME, values, STUDENT_ID + " = ?",
                new String[]{String.valueOf(studentModel.getId())});
    }
    public boolean name(String name,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(" Select * FROM "+ TABLE_NAME +" where " + STUDENT_NAME + " = "+ name +" AND " + STUDENT_PASSWORD + " = "+ password, null);
        if(cursor.getCount() <= 0) {
            cursor.close();
            db.close();
            return false;
        } else {
            cursor.close();
            db.close();
            return true;
        }

}}
