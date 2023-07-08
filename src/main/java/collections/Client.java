package collections;

import java.util.*;
import java.util.stream.Collectors;

public class Client{
    public static void main(String[] args) {
//        List<Integer> list=Arrays.asList(1,2,3,4);
////        List<Integer> out=list.stream().filter(a->a%2==0).collect(Collectors.toList());
////        System.out.println(out);
        Student student = new Student(1, "Ajith");
        Student student1 = new Student(3, "cRanjith");
        Student student2 = new Student(2, "Ranjith");
        TreeSet<Student> studentSet = new TreeSet<>(new AgeComparator());
////        List<Student> studentArrayList=new ArrayList(new NameComparator());
        studentSet.add(student);
        studentSet.add(student1);
        studentSet.add(student2);

//        Collections.sort(studentSet, new AgeComparator());

//        for (Student s : studentSet) {
//            System.out.println(s.age + "--" + s.name);
//        }
//        String s = new String("Ranjith");
//        String s1 = new String("Ranjith");
//        System.out.println(s.equals(s1));
//        System.out.println(s.equals(s1));
//        String s2 = "Ranjith";
//        String s3 = "Ranjith";
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s2));
//        System.out.println(s3.equals(s2));
//        System.out.println(s3.equals(s2));
//
////        ArrayList<Integer> arrayList=new ArrayList<>();
////        arrayList.add(1);
////        arrayList.add(2);
////        arrayList.add(0);
////        List<Student> res = studentSet.stream().sorted((a, b) -> b.name.compareTo(a.name)).collect(Collectors.toList());
//         studentSet.forEach(a->System.out.println(a.name));



    }
    static class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
static class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.age, o2.age);
    }
}
}

