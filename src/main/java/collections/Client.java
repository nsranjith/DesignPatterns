package collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Client {
    public static void main(String[] args) {
        Student student=new Student(1,"Ranjith");
        Student student1=new Student(3,"Ranjith");
        Student student2=new Student(2,"Ranjith");
        TreeSet<Student> studentSet=new TreeSet<>(new AgeComparator());
        studentSet.add(student);
        studentSet.add(student1);
        studentSet.add(student2);
        for(Student s: studentSet){
            System.out.println(s.age+"--"+s.name);
        }
        String s=new String("Ranjith");
        String s1=new String("Ranjith");
        System.out.println(s==s1);
        System.out.println(s.equals(s1));
        String s2="Ranjith";
        String s3="Ranjith";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3==s2);
        System.out.println(s3.equals(s2));



    }
static class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.age, o2.age);
    }
}
}

