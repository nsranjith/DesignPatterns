package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (i)-> (i*i)<20;
        Predicate<Integer> predicate2 = (i)-> (i*i)>0;
        Function<Integer,Integer> function = (num)->(num*2);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.stream().min(Comparator.comparingInt(a -> a));
        System.out.println(function.apply(12));
        System.out.println(predicate.test(12));

    }
}
