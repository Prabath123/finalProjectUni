package com.example.ican;

public class customers {
    String usname;
    String pass;
    String email;
    String id;
    public customers() {

    }
    public customers(String usname, String pass, String email, String id) {
        this.usname = usname;
        this.pass = pass;
        this.email = email;
        this.id = id;
    }

    public String getUsname() {
        return usname;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
