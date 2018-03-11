package com.example.marku.taskorganizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marku on 11.3.2018.
 */

public class plan {
    private int planId;
    private Date planTaskDate;
    private int planTaskId;

    public plan(String planTaskDate, int planTaskId, int planId){

        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm");
        try{
            this.planTaskDate = format.parse(planTaskDate);
        }catch(ParseException e){
            e.printStackTrace();
        }
        this.planId = planId;
        this.planTaskId = planTaskId;

    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Date getPlanTaskDate() {
        return planTaskDate;
    }

    public void setPlanTaskDate(Date planTaskDate) {
        this.planTaskDate = planTaskDate;
    }

    public int getPlanTaskId() {
        return planTaskId;
    }

    public void setPlanTaskId(int planTaskId) {
        this.planTaskId = planTaskId;
    }
}
