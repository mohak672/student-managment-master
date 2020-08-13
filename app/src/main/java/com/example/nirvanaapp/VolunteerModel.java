package com.example.nirvanaapp;

public class VolunteerModel {
    public String id = "";
    public String name = "";
    public String admissionNo = "";
    public String mobileNo="";
    public String state="";
    public String email="";

    public VolunteerModel(String id, String name, String admissionNo, String mobileNo, String state, String email) {
        this.id = id;
        this.name = name;
        this.admissionNo = admissionNo;
        this.mobileNo = mobileNo;
        this.state = state;
        this.email = email;
    }
}
