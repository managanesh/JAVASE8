package com.java.se8.concurrent.forkjoin;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;

/**
 * Created by ganesh.vallabhaneni on 7/22/2014.
 *
 * 	Call from non-fork/join clients
 */
public class CallFJPInMain {
    public static void main(String... args){
        ForkJoinPool pool = new ForkJoinPool();

        // Arrange async execution
        pool.execute(new FJTask("Executing Task"));

        //Arrange exec and obtain Future
        Future task = pool.submit(new FJTask("Submitted task"));
        System.out.println(task.isDone());

        //Await and obtain result
        pool.invoke(new FJTask("Invoking Task"));
        System.out.println(task.isDone());
    }
}

class FJTask extends RecursiveAction{

    String str;

    public FJTask(String name){
        str= name;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName()+"@Compute" + str);
        try{
            Thread.sleep(1000l);
        } catch(Exception e){
            e.printStackTrace();
        }


    }
}