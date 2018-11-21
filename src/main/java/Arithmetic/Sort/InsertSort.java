package Arithmetic.Sort;

/**
 * 直接插入排序
 * @author JYH
 * 2018/10/4 10:13
 */
public class InsertSort {
    public static void iSort(int[] arr){
        int temp;
        for (int i = 1; i < arr.length; i++) {
            //将待插入的关键字存与temp中
            temp = arr[i];
            int j = i -1;
            //从待排序的关键字之前的关键字的开始扫描，如果DAU待排序关键字，则后移一位
            while (j >= 0 && temp < arr[j]){
                arr[j+1]  = arr[j];
                j--;
            }
            //找到插入位置，将temp中暂存的待排序关键字插入
            arr[j+1] = temp;

        }
    }
        public static void main(String[] args) {
            int[] arr = {49,38,65,97,76,13,27};
            int length = arr.length;
            iSort(arr);
            for (int i : arr) {
                System.out.println(i);
            }
        }

}
