package com.java.se8.concurrent.forkjoin;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;

/**
 * Created by ganesh.vallabhaneni on 7/22/2014.
 */
public class CallFJPInternal {
    public static void main(String... args) {
        System.out.println("Executing on Processors:" + Runtime.getRuntime().availableProcessors());
        Date started = new Date();
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Future future = pool.submit(new FLPTask("abcdefghijklmnopqrstuvwxyz"));

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Date end = new Date();
        System.out.println("Execution Time ::" +  (-started.getTime() + end.getTime())/1000.0);
    }
}

class FLPTask extends RecursiveAction {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FLPTask(String str) {
        name = str;
    }



    @Override
    protected void compute() {
        int length = name.length();
        if (length > 1) {

            int mid = length / 2;
            String str1= name.substring(0, mid);
            String str2 = (mid <= name.length() - 1)?name.substring(mid,length):"";
            RecursiveAction left = new FLPTask(str1);
            //Initiate one more thread with half data
            left.fork();

            RecursiveAction right =  new FLPTask(str2);

            if(!str2.isEmpty())right.fork();


            System.out.println(Thread.currentThread().getName() +"String after split::"+str1+"::"+str2);
            left.join();
            if(right!= null) right.join();

        } else {
            System.out.println(Thread.currentThread().getName() + "@Compute:" + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
