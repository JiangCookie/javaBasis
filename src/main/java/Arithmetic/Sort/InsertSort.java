package Arithmetic.Sort;

/**
 * 直接插入排序
 * @author JYH
 * 2018/10/4 10:13
 */
public class InsertSort {
    public static void iSort(int[] arr){
        for(int i = 2;i < arr.length; i ++){
            if(arr[i] < arr[i - 1]){
                int temp = arr[i];
                int j;
                for(j = i-1;j >= 0 && arr[j] > temp ;j --){
                    arr[j+1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        public static void main(String[] args) {
            int[] arr = {49,38,65,97,76,13,27};
            int length = arr.length;
            iSort(arr);
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }
}
