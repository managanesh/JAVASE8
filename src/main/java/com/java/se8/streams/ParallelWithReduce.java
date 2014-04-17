package com.java.se8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ganesh.vallabhaneni on 4/17/2014.
 */
public class ParallelWithReduce {

    public static void main(String ...args){
        List<String> list = Arrays.asList("1","2","3","4","5","6","7","8","9","10");

        System.out.println(list.stream().parallel().reduce((a, b) -> {
            try {
                Thread.sleep(Integer.parseInt(a)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a + b;
        }).get());
    }
}
