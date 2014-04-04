package com.java.se8.streams;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ganesh.vallabhaneni on 4/4/2014.
 */
public class WordCount {
    public static void main(String ...args){

        Stream<String> wordStream = Stream.of("a","b","a","c","a","b");

        Map<String,Integer> countMap = wordStream.collect(Collectors.toMap(s->s,s->1,(i,j) -> i+j));

        System.out.println(countMap);

    }
}
