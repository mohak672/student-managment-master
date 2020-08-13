package com.example.nirvanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity {
    private EditText fullName,fatherName,mobileNo,standard,groupNo,medium,school,rollNo;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        fullName=(EditText)findViewById(R.id.editText11);
        fatherName=(EditText)findViewById(R.id.editText12);
        mobileNo=(EditText)findViewById(R.id.editText13);
        standard=(EditText)findViewById(R.id.editText14);
        school=(EditText)findViewById(R.id.editText15);
        rollNo=(EditText)findViewById(R.id.editText16);
        groupNo=(EditText)findViewById(R.id.editText17);
        medium=(EditText)findViewById(R.id.editText18);
        add=(Button)findViewById(R.id.button15);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUserToFireStore(fullName.getText().toString(),
                        fatherName.getText().toString(),
                        mobileNo.getText().toString(),
                        standard.getText().toString(),
                        school.getText().toString(),
                        rollNo.getText().toString(),
                        groupNo.getText().toString(),
                        medium.getText().toString());
            }
        });
    }

    private void addUserToFireStore(String fullName, String fatherName, String mobileNo, String standard, String school, String rollNo, String groupNo, String medium) {
        Long time = System.currentTimeMillis();
        StudentModel studentModel = new StudentModel(time.toString(),fullName, fatherName, mobileNo, standard, school, rollNo, groupNo, medium);
        new FireStoreClass().registerStudentIntoFireStore(this,studentModel);
    }

    public void successfullyAddedStudent(){
        finish();
    }
}
