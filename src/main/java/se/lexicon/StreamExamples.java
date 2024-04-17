package se.lexicon;

import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        ex8();

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

    // Terminal Operation
    // findFirst()
    public static void ex3() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charls", "David", "Eve");
        Optional<String> optionalFirstElement = names.stream().findFirst();
        if (optionalFirstElement.isPresent()) System.out.println("First Element is:" + optionalFirstElement.get());
        else System.out.println("No element found.");
    }

    // Terminal Operation
    // allMatch(), anyMatch(), noneMatch()
    public static void ex4() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 12, 13);
        boolean isAllMatch = numbers.stream().allMatch(n -> n % 2 == 0); // false
        boolean isAnyMatch = numbers.stream().anyMatch(n -> n % 2 == 0); // true
        boolean isNoneMatch = numbers.stream().noneMatch(n -> n % 2 == 0); // false

    }

    // Terminal Operation
    // forEach()
    public static void ex5() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charls", "David", "Eve");
        names.stream().forEach(System.out::println);
    }

    // Terminal Operation
    // collect()
    public static void ex6() {
        List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Fredrik");
        Set<String> stringSet = names.stream().collect(Collectors.toSet());
        System.out.println(stringSet.size()); // 5
    }

    // Intermediate Operation
    // filter()
    public static void ex7() {
        List<Integer> numbers = Arrays.asList(1, -7, 10, 26, -123, 32, 11, 7, 19);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        numbers.stream()
                .filter(n -> n > 0)
                .filter(isEven)
                .forEach(System.out::println);

        System.out.println("---------");
        numbers.stream().filter(isEven.negate()).forEach(System.out::println);

    }

    public static List<Person> createPersonList() {

        return List.of(
                new Person("Alice", "Johnsson", Gender.F, LocalDate.parse("1990-05-15"), true),
                new Person("Bob", "Smith", Gender.M, LocalDate.parse("1985-08-20"), false),
                new Person("Emily", "Davis", Gender.F, LocalDate.parse("1993-02-10"), true),
                new Person("John", "Doe", Gender.M, LocalDate.parse("1988-11-30"), false),
                new Person("Olivia", "Brown", Gender.F, LocalDate.parse("1987-04-25"), true),
                new Person("Michael", "Williams", Gender.M, LocalDate.parse("1991-09-05"), true),
                new Person("Sophia", "Martinez", Gender.F, LocalDate.parse("1989-07-12"), false),
                new Person("Daniel", "Johnson", Gender.M, LocalDate.parse("1995-03-18"), true),
                new Person("Ella", "Taylor", Gender.F, LocalDate.parse("1992-06-28"), false),
                new Person("William", "Anderson", Gender.M, LocalDate.parse("1986-12-03"), true),
                new Person("Ava", "Garcia", Gender.F, LocalDate.parse("1994-01-08"), false),
                new Person("Alexander", "Brown", Gender.M, LocalDate.parse("1984-10-17"), true),
                new Person("Charlotte", "Miller", Gender.F, LocalDate.parse("1990-08-22"), false),
                new Person("James", "Wilson", Gender.M, LocalDate.parse("1983-06-14"), true),
                new Person("Isabella", "Moore", Gender.F, LocalDate.parse("1988-04-07"), false)
        );
    }

    // Intermediate Operation
    // map() & sort()
    public static void ex8() {
        List<Person> people = createPersonList();

        //Function<Person, LocalDate> dateFunction = (person) -> person.getBirthDate();
        //Function<Person, LocalDate> dateFunctionMethodReference = Person::getBirthDate;

        /*List<LocalDate> dates = people
                .stream()
                .map(Person::getBirthDate)
                .collect(Collectors.toList());

        dates.forEach(System.out::println);*/

        people.stream().map(Person::getBirthDate).forEach(System.out::println);
        System.out.println("----------------");

        // How to Sort by birthDate and map to full name.
        // create stream
        // sort the sequence of data
        // map to full name
        // print

        people.stream()
                //.sorted( (p1,p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()))
                .sorted(Comparator.comparing(Person::getBirthDate))
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .forEach(System.out::println);
    }


}
