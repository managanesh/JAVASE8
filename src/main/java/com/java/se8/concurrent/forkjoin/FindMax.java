package com.java.se8.concurrent.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by H.S.Lasya on 4/23/2014.
 */
public class FindMax extends RecursiveTask<Integer> {
    int[] array;
   public FindMax(int[] data) {
        this.array = data;

    }

    @Override
    protected Integer compute() {

        if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return Math.max(array[0], array[1]);
        } else {

            //Caliculating mid of the array and splitting
            int mid = Math.round(array.length / 2);
            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid, array.length);

            //create left task
            FindMax left = new FindMax(leftArray);
            System.out.println("Left Array::" + leftArray.length + "Start::" + 0 + "End::" + (mid - 1));

            //create right task
            FindMax right = new FindMax(rightArray);
            System.out.println("Right Array::" + rightArray.length + "Start::" + mid + "End::" + (array.length - 1));
            //Fork left task for new thread
            left.fork();

            // Compute right side array
            int rightVal = right.compute();

            return Math.max(left.join(),rightVal);
        }

    }

    public static void main(String... args) {
        int[] array = {1, 2, 13, 45, 66, 43, 23, 11, 99};

        FindMax task = new FindMax(array);
        ForkJoinPool pool = new ForkJoinPool(2);
        System.out.println(pool.invoke(task));
    }
}
