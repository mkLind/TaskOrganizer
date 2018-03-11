package com.example.marku.taskorganizer;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by marku on 11.3.2018.
 */

public class DataManager {
    private Storage s;

    public DataManager(Context cont){
        s = new Storage(cont);
    }




    public ArrayList<Task> loadTasks(){
        ArrayList<String> raw_task = s.getTasks();
        ArrayList<Task> tasks = new ArrayList<>();
        if(raw_task.size()>0) {
            for (int i = 0; i < raw_task.size(); i++) {
                String[] splitTask = raw_task.get(i).split(":");
                tasks.add(new Task(Integer.parseInt(splitTask[0]), splitTask[1], splitTask[2]));
            }
        }
        return tasks;
    }





    public ArrayList<plan> loadPlans(){
    ArrayList<String> raw_plan = s.getPlans();
    ArrayList<plan> plans = new ArrayList<>();
    if(raw_plan.size()>0){
        for(int i = 0; i<raw_plan.size();i++){
            String[] splitPlan = raw_plan.get(i).split(":");
            plans.add(new plan(splitPlan[0],Integer.parseInt(splitPlan[1]), Integer.parseInt(splitPlan[2])));

        }

    }
    return plans;

    }

    public void addTask( String task, String deadline){
        s.addTask(task, deadline);
    }
    public void addPlan(String plan_task_date, String task_id){
        s.addPlan(plan_task_date,task_id);
    }

    public void deleteTask(String task_id){
    s.deleteTask(task_id);

    }
    public void deletePlan(String task_id){
s.deletePlan(task_id);

    }

}
