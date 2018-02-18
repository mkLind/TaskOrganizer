package com.example.marku.taskorganizer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                + PLAN_TASK_ID + " INTEGER "
                + ")";

        database.execSQL(CREATE_PLAN_TABLE);
        database.execSQL(CREATE_TASK_TABLE);


    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        database.execSQL("DROP TABLE IF EXISTS CREATE_TASK_TABLE");
        database.execSQL("DROP TABLE IF EXISTS CREATE_PLAN_TABLE");
        this.onCreate(database);

    }


}
