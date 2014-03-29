package com.java.se8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by ganesh.vallabhaneni on 3/27/2014.
 */
public class FunctionalInterfaces {


    public static void main(String... args) {

        List<String> strings = Arrays.<String>asList("Ganesh", "Ramesh", "Suresh", "Ravi", "Manasa");

        //Predicate -
        Predicate<String> longStr = s -> s.length() > 5;

        System.out.println(strings.stream().filter(s -> longStr.test(s)).collect(Collectors.toList()));

        Predicate<String> endWithEsh = s -> s.endsWith("esh");
        System.out.println(strings.stream().filter(longStr.and(endWithEsh)).collect(Collectors.toList()));

        //Function
        Function<String, String> appendFunc = s -> s.concat(":String added");
        System.out.println(strings.stream().map(appendFunc).collect(Collectors.toList()));

        Function<String, Integer> getLenthFun = s -> s.length();
        System.out.println(strings.stream().map(getLenthFun.compose(appendFunc)).collect(Collectors.toList()));
        System.out.println(strings.stream().map(appendFunc.andThen(getLenthFun)).collect(Collectors.toList()));

        //BinaryOperator
        BinaryOperator<String> stringBinary = (str1, str2) -> str1 + "_" + str2.length();
        System.out.println(stringBinary.apply("Ganesh", "Ganesh2"));
        System.out.println(stringBinary.andThen(appendFunc).andThen(getLenthFun).apply("Ganesh", "Ganesh2"));

        //Consumer
        Consumer<Integer> sysout = x -> System.out.println("::" + x);
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        intList.stream().forEach(sysout);

    }
}
