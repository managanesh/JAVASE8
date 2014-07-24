package com.java.se8.concurrent.forkjoin;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by ganesh.vallabhaneni on 7/24/2014.
 */
public class MergeSort {

    public static void main(String... args) {
        ForkJoinPool pool = new ForkJoinPool();
        Random randomNum = new Random();
        int max = 1000000;
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int index = 0; index < max; index++) {
            randomList.add(randomNum.nextInt(max));
        }
        Integer[] intArray = randomList.toArray(new Integer[randomList.size()]);
        Integer[] processArray = new Integer[intArray.length];
        Integer[] forLegacy =intArray.clone();
        Integer[] forParallel =intArray.clone();
        long startLegacy =(new Date()).getTime();
        Arrays.sort(forLegacy);
        long endLegacy =(new Date()).getTime();
       // System.out.println(Arrays.asList(forLegacy));
        System.out.println("Legacy Time::"+(endLegacy-startLegacy));

        long startTime =(new Date()).getTime();
        //Arrays.parallelSort(forParallel);
        pool.invoke(new MergeTask(intArray, 0, intArray.length, processArray));

        long endTime =(new Date()).getTime();
        System.out.println("Parallel Time::"+(endTime-startTime));
       // System.out.println(Arrays.asList(processArray));
    }

}

class MergeTask extends RecursiveAction {

    private Integer[] data = null;
    private Integer[] processData = null;
    private int beg;
    private int end;

    public MergeTask(Integer[] data, int beg, int end, Integer[] processData) {
        this.data = data;
        this.beg = beg;
        this.end = end;
        this.processData = processData;
    }

    @Override
    protected void compute() {

        int middle = (beg + end) / 2;

        if (end - beg < 2) {
            return;
        } else {

            MergeTask lTask = new MergeTask(data, beg, middle, processData);
            MergeTask rTask = new MergeTask(data, middle, end, processData);
            invokeAll(lTask, rTask);

            merge(data, beg, middle, end, processData);

        }

    }

    protected void merge(Integer[] data, int beg, int middle, int end, Integer[] processData) {
        int leftHead = beg;
        int rightHead = middle;

        for (int j = beg; j < end; j++) {
            if (leftHead < middle && (rightHead >= end || (data[leftHead] <= data[rightHead]))) {
                processData[j] = data[leftHead];
                ++leftHead;
            } else {
                processData[j] = data[rightHead];
                ++rightHead;
            }
        }

        for (int i = beg; i < end; i++) {
            data[i] = processData[i];
        }
    }


}
