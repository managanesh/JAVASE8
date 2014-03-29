package com.java.se8.lambda;

/**
 * Created by ganesh.vallabhaneni on 3/27/2014.
 */
interface VarAguments{
    public int test(Integer ...ints);

   /* default int test(Integer x,Integer ...y){
        return 1;
    }*/
}

public class FunctionalIfc {
  static  VarAguments var = (Integer ...ints) -> {
            return 0;
        };

    public  void main(String ...args){
        //below will give exception
        System.out.println(var.test(1,2));

    }

}
