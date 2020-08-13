package com.example.nirvanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddAdmin extends AppCompatActivity {

    private EditText name,pass1,pass2;
    private Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);

        name=(EditText)findViewById(R.id.editText19);
        pass1=(EditText)findViewById(R.id.editText20);
        pass2=(EditText)findViewById(R.id.editText21);
        add=(Button)findViewById(R.id.button17);

    }



}
