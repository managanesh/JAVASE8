package com.java.se8.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by ganesh.vallabhaneni on 7/23/2014.
 */
public class FJPInvokeAll {
    public static void main(String... args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        pool.invoke(new InvokeAllTask("a"));

    }
}

class InvokeAllTask extends RecursiveAction {
    private String data = "";

    public InvokeAllTask(String data) {
        this.data = data;
    }

    @Override
    protected void compute() {
        if (data.length() == 1) {
            System.out.println(Thread.currentThread().getName() + "@::" + data);
        } else {
            InvokeAllTask lTask = new InvokeAllTask(data.substring(0, data.length() / 2));
            InvokeAllTask rTask = new InvokeAllTask(data.substring((data.length() / 2), data.length()));
            /**
             public static void invokeAll(ForkJoinTask<?> t1, ForkJoinTask<?> t2) {
             int s1, s2;
             ***t2.fork();
             ***if ((s1 = t1.doInvoke() & DONE_MASK) != NORMAL)
             t1.reportException(s1);
             ***if ((s2 = t2.doJoin() & DONE_MASK) != NORMAL)
             t2.reportException(s2);
             }
             */
            invokeAll(lTask, rTask);
        }


    }
}