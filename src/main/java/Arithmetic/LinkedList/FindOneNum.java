package Arithmetic.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JYH
 * 2018/9/22 16:49
 */
public class FindOneNum {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //  int diff = 0;
        //  for(int num :  array)
        //      diff ^=num;
        List<String> list =new ArrayList<String>();
        for(int num: array){
            if(!list.contains(String.valueOf(num))){
                list.add(String.valueOf(num));
            }else{
                list.remove(String.valueOf(num));
            }
        }
        if(list.size()!=0) {
            num1[0] =Integer.valueOf(list.get(0)) ;
            num2[0] = Integer.valueOf(list.get(1));
        }



    }

    public static void main(String[] args) {
        int[] array = {2,3,2,4};
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
