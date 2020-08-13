package com.example.nirvanaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AddVolunteer extends AppCompatActivity {
    private EditText name,admissionNo,mobileNo,email,password,state;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_volunteer);

        name=(EditText)findViewById(R.id.editText5);
        admissionNo=(EditText)findViewById(R.id.editText6);
        mobileNo=(EditText)findViewById(R.id.editText7);
        email=(EditText)findViewById(R.id.editText8);
        state=(EditText)findViewById(R.id.editText9);
        password=(EditText)findViewById(R.id.editText10);
        add=(Button)findViewById(R.id.button6);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addVolunteerToFireStore(name.getText().toString(),
                        admissionNo.getText().toString(),
                        mobileNo.getText().toString(),
                        email.getText().toString(),
                        state.getText().toString(),
                        password.getText().toString());
            }
        });
    }

    private void addVolunteerToFireStore(final String name, final String admissionNo, final String mobileNo, String email, final String state, String password) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                        FirebaseUser firebaseVolunteer = task.getResult().getUser();
                        if(firebaseVolunteer != null){
                            String registeredEmail = firebaseVolunteer.getEmail();
                            VolunteerModel volunteerModel = new VolunteerModel(firebaseVolunteer.getUid(),name,admissionNo,mobileNo,state,registeredEmail);
                            new FireStoreClass().registerVolunteerIntoFireStore(AddVolunteer.this,volunteerModel);
                        }
                }else{
                    Toast.makeText(AddVolunteer.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                    System.out.println("Error" + task.getException().getMessage());
                }
            }
        });
    }

    public void successfullyAddedVolunteer(){
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}
