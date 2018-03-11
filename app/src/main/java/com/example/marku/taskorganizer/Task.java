package com.example.marku.taskorganizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by marku on 11.3.2018.
 */

public class Task implements Comparable<Task>{
    private int id;
    private String task;
    private Date deadline;
    private Date currentDate;
    private Date timeLeft;

    public Task(int id, String task, String date){
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm");
        try{
            deadline = format.parse(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
        this.id = id;
        this.task = task;
        currentDate = Calendar.getInstance().getTime();

        timeLeft = new Date(deadline.getTime() - currentDate.getTime());

    }
public String toString(){

        return ""+task +"\n" +"Time Left" + timeLeft.toString();
}
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Date timeLeft) {
        this.timeLeft = timeLeft;
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


    @Override
    public int compareTo(Task t){
        int result = 0;
        if(t.getTimeLeft()==null||t.getTimeLeft()==null){
        return result;


        }else{
        result = getTimeLeft().compareTo(t.getTimeLeft());


        }
        return result;


    }
}
