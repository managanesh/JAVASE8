package com.java.se8.lambda;

import java.lang.reflect.Method;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.*;

/**
 * Created by ganesh.vallabhaneni on 3/28/2014.
 */
public class MethodReferences {
    /**
     * If there is a method whose signature matches the signature of the method of a functional (SAM) interface,
     * then you can use Class::method (or something similar), rather than an explicit lambda.
     * @param args
     */
    private static String str ="";
    public PredicateNoArg<String> predWithArg = str::isEmpty;


    public static void main(String... args){
        //instance and instance method
        //here print signature is"public void  print(Object obj)" which exactly mathces.
        Consumer<Integer> fun = out::print;

        //example2 instance & instance method
        String str ="";
        Predicate<String> pred = String::isEmpty;
        PredicateNoArg<String> predNoArg = str::isEmpty; // str -> str
        PredicateWithArg<String> predWithArg = str::endsWith;

        System.out.println(pred.test(""));
        System.out.println(predNoArg.check());
        System.out.println(predWithArg.check(str));

        BiFunction<String,String,String> function = str::replaceAll;

        //Class and static method
        Function<Integer,Integer> mathAbs = Math::abs;  // x -> Math.abs(x);

    }

    interface PredicateNoArg<T>{
        public boolean check();
    }

    interface PredicateWithArg<T>{
        public boolean check(T t);
    }

}

