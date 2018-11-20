package Arithmetic.Sort;

/**
 * 归并排序
 * @author JYH
 * 2018/11/20 16:11
 */
public class MergeSort {

    public  static  void mSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mSort(arr,low,mid);
            mSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }


    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] leftArray = new int[mid - low +1];
        int[] rightArray = new int[high-mid];

        for (int i = low; i <= mid; i++) {
            leftArray[i-low] = arr[i];
        }
        for (int i = mid +1; i <= high; i++) {
            rightArray[i-mid-1] = arr[i];
        }

        int i=0;
        int j=0;
        int k = low;

        while (i <leftArray.length && j < rightArray.length){
            if(leftArray[i] < rightArray[j]){
                arr[k] = leftArray[i];
                k++;
                i++;
            }else {
                arr[k] = rightArray[j];
                k++;
                j++;
            }
        }

        while (i<leftArray.length){
            arr[k] = leftArray[i];
            k ++;
            i ++;
        }

        while (j<rightArray.length){
            arr[k] = rightArray[j];
            k ++;
            j ++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27};
        int length = arr.length;
        mSort(arr, 0, length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
