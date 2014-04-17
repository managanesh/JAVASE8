package com.java.se8.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ganesh.vallabhaneni on 4/9/2014.
 */
public class LazyEvaluation {
    public static void main(String ...args){
        Stream<String> names = Stream.of("Ganesh1","Ramesh","Mahesh","Rajesh","Suresh","chandu");

        //Terminal Operations will initiate the rest of the operations
        names.filter(s->{
            System.out.println("Filter@String: "+s);
            return s.length()<7;
        }).map(s->{
            System.out.println("Map@String: "+s);
            return s;
        }).collect(Collectors.toList());
    }
}
