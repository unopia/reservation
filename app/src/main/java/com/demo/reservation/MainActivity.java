package com.demo.reservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_today, tv_year, tv_month, tv_day, tv_hour, tv_min;
    RadioButton rd_date, rd_time;
    CalendarView cal;
    TimePicker time;
    Button bt_reserve;
    String date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_today = (TextView) findViewById(R.id.tv_today);
        tv_year = (TextView) findViewById(R.id.tv_year);
        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_day = (TextView) findViewById(R.id.tv_day);
        tv_hour = (TextView) findViewById(R.id.tv_hour);
        tv_min = (TextView) findViewById(R.id.tv_min);
        rd_date = (RadioButton) findViewById(R.id.rd_date);
        rd_time = (RadioButton) findViewById(R.id.rd_time);
        cal = (CalendarView) findViewById(R.id.cal);
        time = (TimePicker) findViewById(R.id.time);
        bt_reserve = (Button) findViewById(R.id.bt_reserve);

        rd_date.setOnClickListener(this);
        rd_time.setOnClickListener(this);
        bt_reserve.setOnClickListener(this);

       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String today = sdf.format(d);*/
        tv_today.setText("TODAY : " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                date = year + "-" + (month+1) + "-" + day;
            }
        });
        time.setVisibility(View.INVISIBLE);
        cal.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rd_date :
                time.setVisibility(View.INVISIBLE);
                cal.setVisibility(View.VISIBLE);
                break;
            case R.id.rd_time :
                time.setVisibility(View.VISIBLE);
                cal.setVisibility(View.INVISIBLE);
                break;
            case R.id.bt_reserve :
                String arr[] = date.split("-");
                tv_year.setText(arr[0]);
                tv_month.setText(arr[1]);
                tv_day.setText(arr[2]);
                tv_hour.setText(Integer.toString(time.getHour()));
                tv_min.setText(Integer.toString(time.getMinute()));
                break;
        }
    }
}
