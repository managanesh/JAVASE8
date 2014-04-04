package com.java.se8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ganesh.vallabhaneni on 3/29/2014.
 */
public class SimpleStreams {
    public static void main(String ...args){
        List<String> strings = Arrays.asList("Ganesh","Ramesh","Suresh","vignesh");

      boolean present =   strings.stream().map(
                s -> {
                    System.out.println("In For Each...."+s);
                    return s.length();
                }
        ).filter(
                i -> {
                    System.out.println("In filter..."+i);
                    return i > 1;
                }).findFirst().isPresent()
        ;

        System.out.println(present);

        int noProcessor = Runtime.getRuntime().availableProcessors();

        System.out.println(noProcessor);


    }
}
