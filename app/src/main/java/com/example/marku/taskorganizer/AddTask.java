package com.example.marku.taskorganizer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class AddTask extends AppCompatActivity {
    private Date deadline;
    private String description;
    private String deadlineText;
    private DataManager manager;
    private EditText descField;
    private static TextView deadlinelabel;
    private Button setDeadline;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        manager = new DataManager(getApplicationContext());
        descField = findViewById(R.id.description);
        setDeadline = findViewById(R.id.deadlineSet);
        save = findViewById(R.id.save);
        deadlinelabel = findViewById(R.id.deadlineLabel);
        deadline = new Date();

        setDeadline.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View v){
                DatePicker pick = new DatePicker();
                pick.show(getFragmentManager(),"");

            }
        });


    }
   public static class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        public Dialog onCreateDialog(Bundle savedInstanceState){

            final Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            return dialog;
        }

       public void onDateSet(android.widget.DatePicker view, int year, int month, int day){


            deadlinelabel.setText("Deadline: " + day+"."+month+"."+year);

       }

    }
}
