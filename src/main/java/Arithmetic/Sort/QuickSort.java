package Arithmetic.Sort;

/**
 * 快速排序
 * @author JYH
 * 2018/11/20 16:11
 */
public class QuickSort {

    public  static  void qSort(int[] arr, int low, int high){
        int i = low;
        int j = high;
        int temp = arr[low];
        //下面这个循环完成一趟排序，即数组中小于temp的关键字放在左边，大于temp的关键字放在右边
        while(i<j){

            //从右往左扫描，找到一个小于temp的关键字
            while (j>i && temp < arr[j]){
                j--;
            }
            if(i<j){
                //放在temp的左边
                arr[i] = arr[j];
                //i++右移一位
                i ++;
            }
            //从左往右扫描，找到一个大于temp的关键字
            while (i<j && temp > arr[i]){
                i++;
            }
            if(i<j){
                //放在temp的右边
                arr[j] = arr[i];
                //i++左移一位
                j--;
            }
        }
        //将temp放在最终的位置
        arr[i] = temp;
        if(low < j){
            qSort(arr,low,j-1);
        }
        if(high > i){
            qSort(arr,j+1,high);
        }



    }

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27};
        int length = arr.length;
        qSort(arr, 0, length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
