package com.java.se8.streams;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by ganesh.vallabhaneni on 3/30/2014.
 */
public class MapReduce {

    public static void main(String... args) {
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            lists.addAll(strArray);
        }
        System.out.println("Started @" + LocalTime.now());

        MapObj obj = lists.stream().map(

                s -> new MapObj(s ))

                .reduce((MapObj o1, MapObj o2) -> {
                    String[] str = o1.key.split(",");
                    Stream.of(str).forEach( s -> {
                        String[] map = s.split("::");
                    });

                    return o1;

                }).get();
       obj.map.forEach((x, y) -> System.out.println(x + "::" + y.size()));

        System.out.println("Started @" + LocalTime.now());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1l; i++) {
            list.add(i);
        }
        System.out.println(list.stream().parallel().reduce(MapObj::sum).get());
        System.out.println("Started @" + LocalTime.now());

    }    //Split string into array

    static List<String> strArray = Arrays.asList("G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G",
            "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G", "G", "S", "G", "K", "R", "T", "G"
    );

}

class MapObj {
    HashMap<String,List<Integer>> map = new HashMap<>();

    MapObj(String key) {
        this.key = key;
        this.values = new ArrayList<>(1);
        this.values.add(1);
        map.put(key,values);

    }

    String key;
    List<Integer> values;

    static Integer sum(Integer i1, Integer i2) {
        // System.out.println(i1+"::"+i2);
        return i1 + i2;
    }


}