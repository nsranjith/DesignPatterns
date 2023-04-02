package com.example.designpatterns.Builder;

public class Client {
    public static void main(String[] args) {
        Student student=Student.getBuilder()
                        .setAge(1)
                        .setName("Ranjith")
                        .build();
        System.out.println(student.age);
        System.out.println(student.name);
        System.out.println(student.marks);
        Student student1=Student.getBuilder()
                .setAge(1)
                .setName("Ranjith")
                .setMarks(100)
                .build();
        System.out.println(student1.age);
        System.out.println(student1.name);
        System.out.println(student1.marks);
    }
}
