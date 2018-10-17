package Arithmetic.Sort;

/**
 * 直接插入排序
 * @author JYH
 * 2018/10/4 10:13
 */
public class InsertSort {
    public static void getInsertSort(int[] arr){
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
        int[] array = {5,9,3,6};
        System.out.println("直接插入排序前：");
        for (int arr:array){
            System.out.print(arr);
        }
        System.out.println();
        getInsertSort(array);
        System.out.println("直接插入排序后：");
        for (int arr:array){
            System.out.print(arr);
        }
    }
}
