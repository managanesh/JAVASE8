package com.java.se8.lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Simple Lambda Expressions
 * <p>
 * Created by H.S.Lasya on 3/25/2014.
 */
public class SimpleLambda {

   /* class People{
        int id;

        String  lastName;

        String firstName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }*/

    public static void strFunction(String str){

    }

    public static void fileFunction(File str){

    }


    public static void main(String... args) {

        //Normal notation of Lambda expressions;
        /**
         n -> n % 2 != 0;
         (char c) -> c == 'y';
         (x, y) -> x + y;
         (int a, int b) -> a * a + b * b;
         () -> 42
         () -> { return 3.14 };
         (String s) -> { System.out.println(s); };
         () -> { System.out.println("Hello World!"); };
         */

        //Has an argument list and return type and a body
        Comparator<String> strComprtr = (s1,s2) -> s1.compareToIgnoreCase(s2);
        Comparator<String> stringComparator = ( String s1,String s2) -> s1.compareToIgnoreCase(s2);

        //Has no argument  with void method
        Runnable run = () -> System.out.println(Thread.currentThread().getName() + "::Thread");
        run.run();

        //Lambda is a function
        Function<String,String> function = (s) -> {return "Its a Funtion";};

        //A function is a computation takes parameters and returns a value
        Predicate<String> predicateFunction = (s) -> {return true;};
        //-- Here predicateFunction is an object implemented for 'test' method with lambda((s) -> return true;)
        predicateFunction.test("String");

        //A Lambda is used to passed around or stored like a data.
        Collections.sort(Collections.EMPTY_LIST,strComprtr);

        //
        File current = new File(".");
        File[] files = current.listFiles();

        List<String> stingList = new ArrayList<>();

        Stream.of(files).forEach(file -> fileFunction(file));
        Stream.of(files).forEach(SimpleLambda::fileFunction);

      //  Stream.of(stingList).forEach(SimpleLambda::strFunction);

    }
}
