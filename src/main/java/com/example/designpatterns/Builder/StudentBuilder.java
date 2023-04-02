package com.example.designpatterns.Builder;

import lombok.Getter;
import lombok.Setter;

public class StudentBuilder {
    private int age;
    private String name;
    private int marks;


    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setMarks(int marks) {
        this.marks = marks;
        return this;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
    public StudentBuilder() {
    }
}
