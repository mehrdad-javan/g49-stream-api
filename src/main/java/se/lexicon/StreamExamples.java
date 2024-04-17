package se.lexicon;

import java.util.*;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        ex2();

    }

    // Terminal Operation
    // count()
    public static void ex1() {
        Stream<String> skills = Stream.of("Java", "C#", "ReactJS", "Python");
        long count = skills.count();
        System.out.println("count = " + count);
    }

    // Terminal Operation
    // max() & min()
    public static void ex2() {
        List<Integer> numbers = Arrays.asList(2, 100, 12, 100000, 20000);
        //    int compare(T o1, T o2);
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
        Comparator<Integer> comparatorMethodReference = Integer::compareTo;

        Optional<Integer> optionalMax = numbers.stream().max(comparator);
        if (optionalMax.isPresent()) {
            System.out.println("Max number is: " + optionalMax.get());
        } else {
            System.out.println("No Max number found");
        }


        Optional<Integer> optionalMin = numbers.stream().min(comparator);
        if (optionalMin.isPresent()) {
            System.out.println("Min number is: " + optionalMin.get());
        } else {
            System.out.println("No Min number found");
        }

    }


}
