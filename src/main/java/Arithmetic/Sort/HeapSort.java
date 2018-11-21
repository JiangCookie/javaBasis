package Arithmetic.Sort;

/**
 * @author JYH
 * 2018/11/21 14:43
 */
public class HeapSort {

    public static void hSort(int[] arr){

        //1.构建大顶堆
        for(int i = arr.length/2-1;i >= 0; i --){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i ,arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }

    }

    public static void adjustHeap(int[] arr,int i ,int lenght){
        int temp = arr[i];
        for(int k = i*2 +1;k < lenght; k = k*2+1){
            if(k+1 < lenght && arr[k+1] > arr[k]){
                k++;
            }
            if(temp < arr[k]){
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }

    /**
     * 交换元素
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27};
        int length = arr.length;
        hSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
