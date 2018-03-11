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
        for(int i = 0; i<raw_task.size();i++){
            String[] splitTask = raw_task.get(i).split(":");
            tasks.add(new Task(Integer.parseInt(splitTask[0]),splitTask[1],splitTask[2]));
        }
        return tasks;
    }
    public ArrayList<plan> loadPlans(){


    }

    public void addTask(){



    }
    public void addPlan(){

    }

    public void deleteTask(){


    }
    public void deletePlan(){


    }

}
