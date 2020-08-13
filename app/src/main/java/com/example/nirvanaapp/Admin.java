package com.example.nirvanaapp;

public class Admin {
    String name,pass,id;

    public Admin(String id,String name, String pass) {
        this.id=id;
        this.name = name;
        this.pass = pass;
    }
public String getName(){return name;}
public String getPass(){return pass;}
public String getId(){return id;}

}
