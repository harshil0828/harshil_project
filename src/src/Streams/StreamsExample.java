package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {

        /*Remove duplicates, sort, and collect into a list*/
        List<Integer> nums = Arrays.asList(5, 1, 2, 2, 4, 3);

        List<Integer> result = nums.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(result); //1,2,3,4,5

        //Flatten a list of lists
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );

        List<String> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flat); // [A, B, C, D]

        //Collect all names to a single comma-separated string.
        List<String> employees = Arrays.asList("Harshil","Bhakti","Kashvi");
        String names = employees.stream()
                .collect(Collectors.joining(", "));

        System.out.println(names);

        //Selects elements that match a condition
        List<String> nameList = List.of("Tom", "John", "Jerry");
        nameList.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(System.out::println); // John, Jerry

        //Transforms each element

        List<String> stringList = List.of("a", "bb", "ccc");
        stringList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println); // A, BB, CCC

        //Sorts using a custom comparator
        List<String> words = List.of("apple", "pear", "banana");
        words.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println); // pear, apple, banana

        //peek(Consumer)
        Stream.of("a", "b", "c")
                .peek(x -> System.out.println("Processing: " + x))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5)
                .limit(3)
                .forEach(System.out::println); // 1, 2, 3

        //Skips the first n elements
        Stream.of(1, 2, 3, 4, 5)
                .skip(2)
                .forEach(System.out::println); // 3, 4, 5

    //      mapToInt, mapToLong, mapToDouble
    //✅ Convert object stream to primitive stream for performance

        List<String> list = List.of("a", "ab", "abc");
        int sumLength = list.stream()
                .mapToInt(String::length)
                .sum(); // 6

        System.out.println("String length sum " + sumLength); // 6 (2+4)*/

        //
       List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int sum = numbers.stream()        // create a stream
                .filter(n -> n % 2 == 0)  // keep only even numbers
                .mapToInt(n -> n)         // convert Integer → int
                .sum();                   // terminal operation

        System.out.println(sum); // 6 (2+4)


        //Given number square,filer greater than 100, average
        List<Integer>numbersList = List.of(1, 5, 12, 10, 15);

        OptionalDouble t = numbersList.stream().mapToInt(n->n*n).filter(n->n>100).average();
        System.out.println("square,filer greater than 100, average " + t);


    }
}
