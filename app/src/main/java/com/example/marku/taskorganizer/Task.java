package com.example.marku.taskorganizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marku on 11.3.2018.
 */

public class Task {
    private int id;
    private String task;
    private Date deadline;

    public Task(int id, String task, String date){
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm");
        try{
            deadline = format.parse(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
        this.id = id;
        this.task = task;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
