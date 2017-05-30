package com.mathrusoft.studentdatabase.model;

/**
 * Created by sharanangadi on 30/05/17.
 */

public class Student {
    String name;
    String branch;
    float age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
