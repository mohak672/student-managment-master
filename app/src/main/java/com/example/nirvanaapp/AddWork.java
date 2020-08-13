package com.example.nirvanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class AddWork extends AppCompatActivity {
    private Button b1;
    private TextView dateText;
    static int day1,year1,month1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);

        b1=(Button)findViewById(R.id.button19);
        dateText=(TextView)findViewById(R.id.e23);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String date=day+"/"+month+"/"+year;
                        dateText.setText(date);
                        day1=day;
                        year1=year;
                        month1=month;
                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }


}
