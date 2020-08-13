package com.example.nirvanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPage extends AppCompatActivity {

    private Button addA,addV,addS,getA,getS,getV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        addV=(Button)findViewById(R.id.button9);
        addA=(Button)findViewById(R.id.button10);
        addS=(Button)findViewById(R.id.button11);
        getV=(Button)findViewById(R.id.button12);
        getA=(Button)findViewById(R.id.button13);
        getS=(Button)findViewById(R.id.button14);

        addV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,AddVolunteer.class);
                startActivity(it);
            }
        });
        addA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,AddAdmin.class);
                startActivity(it);
            }
        });
        addS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,AddStudent.class);
                startActivity(it);
            }
        });



    }
}
