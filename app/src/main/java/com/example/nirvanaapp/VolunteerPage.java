package com.example.nirvanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VolunteerPage extends AppCompatActivity {
    private Button about,see,addwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_page);

        about=(Button)findViewById(R.id.button);
        see=(Button)findViewById(R.id.button2);
        addwork=(Button)findViewById(R.id.button5);

        addwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(VolunteerPage.this,AddWork.class);
                startActivity(it);
            }
        });




    }
}
