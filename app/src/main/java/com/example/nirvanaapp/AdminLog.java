package com.example.nirvanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLog extends AppCompatActivity {
    private EditText e1;
    private EditText e2;
    private Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log);

        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        log=(Button)findViewById(R.id.button3);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(e1.getText().toString(),e2.getText().toString());
            }
        });



    }

    private void validate(String name,String pass) {
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "please enter username", Toast.LENGTH_LONG).show();
            return;
        }
        else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
            e1.setText("");
            return;
        }

        else if (name.equals("nirvana") && pass.equals("12345")) {

            Intent it = new Intent(AdminLog.this, AdminPage.class);
            startActivity(it);
            e1.setText("");
            e2.setText("");
            return;
        } else {
            e2.setText("");
            Toast.makeText(this,"incorrect username or password",Toast.LENGTH_LONG).show();
            return;
        }
    }


}
