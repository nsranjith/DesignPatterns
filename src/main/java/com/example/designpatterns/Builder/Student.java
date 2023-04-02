package com.example.designpatterns.Builder;


public class Student {
    public int age;
    public String name;
    public int marks;
    public static class StudentBuilder {
        private int age;
        private String name;
        private int marks;
        public Student build() {
            return new Student(this);
        }

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

        private StudentBuilder() {
        }
    }
    public static StudentBuilder getBuilder(){
        return new StudentBuilder();
    }
    Student(StudentBuilder studentBuilder){
        //if you need to validations on fields do that here
        this.age=studentBuilder.getAge();
        this.name=studentBuilder.getName();
        this.marks=studentBuilder.getMarks();
    }
}
