package com.example.nirvanaapp;

import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import androidx.annotation.NonNull;

class FireStoreClass {
    private FirebaseFirestore mFireStore = FirebaseFirestore.getInstance();

    public void registerStudentIntoFireStore(final AddStudent addStudent, StudentModel studentModel){
        mFireStore.collection(Constants.STUDENT).document(String.valueOf(studentModel.id)).set(studentModel, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                System.out.println("Successfully added new student into the database");
                Toast.makeText(addStudent,"Success add student",Toast.LENGTH_SHORT).show();
                addStudent.successfullyAddedStudent();
            }
        }).addOnFailureListener(new OnFailureListener(){

            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(addStudent,"Failed",Toast.LENGTH_SHORT).show();
                System.out.println("Error" + e.getMessage());
            }
        });
    }

    public void registerVolunteerIntoFireStore(final AddVolunteer addVolunteer, VolunteerModel volunteerModel){
        mFireStore.collection(Constants.VOLUNTEERS).document(getCurrentUserID()).set(volunteerModel, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                System.out.println("Successfully added new volunteer into the database");
                Toast.makeText(addVolunteer,"Success add volunteer",Toast.LENGTH_SHORT).show();
                addVolunteer.successfullyAddedVolunteer();
            }
        }).addOnFailureListener(new OnFailureListener(){

            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(addVolunteer,"Failed",Toast.LENGTH_SHORT).show();
                System.out.println("Error" + e.getMessage());
            }
        });
    }

    public void getStudentsFromFireStore(){
        
    }

    public String getCurrentUserID(){
         FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentUserUID = "";
        if(user != null){
            currentUserUID = user.getUid();
        }
        return currentUserUID;
        //this function will return the current user id who is currently logged into the app
    }
}
