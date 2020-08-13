package com.example.nirvanaapp;

public class StudentModel {
    public String id = "";
    public String fullName = "";
    public String fatherName="";
    public String mobileNo="";
    public String standard="";
    public String school="";
    public String rollNo="";
    public String groupNo="";
    public String medium="";

    public StudentModel(String id, String fullName, String fatherName, String mobileNo, String standard, String school, String rollNo, String groupNo, String medium) {
        this.id = id;
        this.fullName = fullName;
        this.fatherName = fatherName;
        this.mobileNo = mobileNo;
        this.standard = standard;
        this.school = school;
        this.rollNo = rollNo;
        this.groupNo = groupNo;
        this.medium = medium;
    }
}
