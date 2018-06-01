package com.example.tanvi.digitalsecurity;

/**
 * Created by Tanvi on 11/8/2017.
 */

public class Details {
    String id;
    String name;
    String pass;
    String mobile;
    String adhaar;

    public Details(String id, String name, String pass, String mobile,String adhaar) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
        this.adhaar=adhaar;
    }

    public String getId() {

        return id;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public String getName() {

        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getMobile() {
        return mobile;
    }

    public Details(String name, String pass, String mobile) {
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
    }


}
