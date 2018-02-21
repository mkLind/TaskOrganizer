package com.example.marku.taskorganizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by marku on 18.2.2018.
 */

public class Storage extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TaskData";
    private static final String TASKS_TABLE = "Tasks";
    private static final String PLAN_TABLE = "Plans";
    private static final String TASK_ID="Task_id";
    private static final String PLAN_ID="Plan_id";
    private static final String TASK="task";
    private static final String DEADLINE="Deadline";
    private static final String PLAN_TASK_DAY="Planned_day";
    private static final String PLAN_TASK_ID="Task_id_of_Plan";

    public Storage(Context cont){
        super(cont, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public void onCreate(SQLiteDatabase database){
        String CREATE_TASK_TABLE = "CREATE TABLE " + TASKS_TABLE + "("
                + TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TASK + " TEXT, "
                + DEADLINE + " TEXT "
                + ")";
        String CREATE_PLAN_TABLE = "CREATE TABLE " + PLAN_TABLE + "("
                + PLAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PLAN_TASK_DAY + " TEXT, "
                + PLAN_TASK_ID + " TEXT "
                + ")";

        database.execSQL(CREATE_PLAN_TABLE);
        database.execSQL(CREATE_TASK_TABLE);


    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        database.execSQL("DROP TABLE IF EXISTS CREATE_TASK_TABLE");
        database.execSQL("DROP TABLE IF EXISTS CREATE_PLAN_TABLE");
        this.onCreate(database);

    }

    public void addTask(String task, String deadline){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(TASK, task);
        val.put(DEADLINE, deadline);
        database.insert(TASKS_TABLE, null,val);
        database.close();

    }
    public void addPlan(String task_day, String task_id){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put(PLAN_TASK_DAY, task_day);
        val.put(DEADLINE, task_id);

        database.insert(PLAN_TABLE, null,val);
        database.close();

    }
    public ArrayList<String> getTasks(){
        SQLiteDatabase base = this.getReadableDatabase();
        ArrayList<String> tasks = new ArrayList<>();
        Cursor cursor = base.rawQuery("SELECT Task, Deadline FROM Tasks",null);
        if(cursor != null && cursor.getCount()>0){

            cursor.moveToFirst();
            do{
                String task = cursor.getString(0) + ":" + cursor.getString(1);
                tasks.add(task);
            }
            while(cursor.moveToNext());
            return tasks;

        }
        return tasks;

    }
    public ArrayList<String> getPlans(){
        SQLiteDatabase base = this.getReadableDatabase();
        ArrayList<String> plans = new ArrayList<>();
        Cursor cursor = base.rawQuery("SELECT Planned_day, Task_id_of_Plan FROM Tasks",null);
        if(cursor != null && cursor.getCount()>0){

            cursor.moveToFirst();
            do{
                String plan = cursor.getString(0) + ":" + cursor.getString(1);
                plans.add(plan);
            }
            while(cursor.moveToNext());
            return plans;

        }
        return plans;

    }

}
