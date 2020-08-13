package com.example.nirvanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name,pass;
    private Button admin,log,skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        log=(Button)findViewById(R.id.btn);
        admin=(Button)findViewById(R.id.button1);
        skip=(Button)findViewById(R.id.button2);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,AdminLog.class);
                startActivity(it);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),pass.getText().toString());
            }
        });


    }
    public void validate(String n,String p){
        if (TextUtils.isEmpty(n)) {
            Toast.makeText(this, "please enter username", Toast.LENGTH_LONG).show();
            return;
        }
        else if (TextUtils.isEmpty(p)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
            name.setText("");
            return;
        }

        else if (n.equals("nirvana") && p.equals("12345")) {

            Intent it = new Intent(MainActivity.this, VolunteerPage.class);
            startActivity(it);
            name.setText("");
            pass.setText("");
            return;
        } else {
            pass.setText("");
            Toast.makeText(this,"incorrect username or password",Toast.LENGTH_LONG).show();
            return;
        }
    }



}
