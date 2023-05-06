package collections;

import java.util.Objects;

public class Student {
    int age;
    String name;
    Student(int age, String name){
        this.age=age;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
       if(this==o) return  true;
       if(!(o instanceof Student)) return false;
       return this.age== ((Student) o).age && this.name.equalsIgnoreCase(((Student) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name);
    }
}
