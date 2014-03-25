package com.java.se8.lambda;

/**
 * Simple Lambda Expressions
 * <p>
 * Created by H.S.Lasya on 3/25/2014.
 */
public class SimpleLambda {

    public static void main(String... args) {
        //Has an argument list and return type and a body
        Runnable run = () -> System.out.println(Thread.currentThread().getName() + "::Thread");

        run.run();
    }
}
