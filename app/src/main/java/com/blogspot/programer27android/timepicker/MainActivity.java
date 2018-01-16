package com.blogspot.programer27android.timepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int hourOfDay,minute;
    Calendar cal = Calendar.getInstance();
    Button setT;
    TextView tv;
    public static int Dialog=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tvtimer);
        hourOfDay=cal.get(Calendar.HOUR_OF_DAY);
        minute=cal.get(Calendar.MINUTE);
        clickbtn();
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id ==Dialog)
            return new TimePickerDialog(MainActivity.this,tpicker,hourOfDay,minute,true);
        return null;
    }

    public void clickbtn(){
        setT= (Button) findViewById(R.id.timepick);
        setT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Dialog);
            }
        });
    }


    private  TimePickerDialog.OnTimeSetListener tpicker
            = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourDay, int minutes) {
            hourOfDay=hourDay;
            minute=minutes;
            Toast.makeText(MainActivity.this, hourOfDay+" : "+minute, Toast.LENGTH_LONG).show();
            tv.setText(hourOfDay+" : "+minute);
        }
    };
}
