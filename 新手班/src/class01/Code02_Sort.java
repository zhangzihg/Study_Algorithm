package class01;

import java.util.Arrays;

/**
 *  选择排序
 */
public class Code02_Sort {
    public static void main(String[] args) {
        int[] arr = {2,35,4,11,5,9,22,10,6,3};
        int [] arr2 = {2,35,4,11,5,9,22,10,6,3};
        int [] arr3 = {2,35,4,11,5,9,22,10,6,3};
        int [] arr4 = {2,35,4,11,5,9,22,10,6,3};
        printArr(arr);
//        Arrays.sort(arr2);
//        System.out.println(Arrays.toString(arr2));
        System.out.println("=========选择排序开始=========");
        selectSort(arr);
        printArr(arr);
        System.out.println("========冒泡排序===========");
        bubbleSort(arr2);
        printArr(arr2);
        System.out.println("==========插入排序=============");
        insertSort(arr3);
        printArr(arr3);
        System.out.println("=========插入排序2==============");
        insertSort2(arr4);
        printArr(arr4);
    }

    public static void printArr (int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    public static  void  selectSort(int[] arr){
//        处理边界条件
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        /*
        *  1~N  找最小值 交换到第1个位置
        *   2 ~N找最小值  交换到第2个位置
        *   3 ~N找最小值 交换到第3个位置
        *  ...
        * */

        for (int i=0; i<N; i++){
            int minValueIndex = i;
            for(int j=i+1; j<N; j++) {
                //找出最小值
                minValueIndex = arr[minValueIndex] > arr[j] ? j : minValueIndex;
            }
            //交换最小值到i的位置
            swap(arr,i,minValueIndex);
        }
    }

    public static  void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //冒泡排序
    public static  void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int N = arr.length;

        //0~N-1
        //0~N-2
        //0~N-3
        //...   end代表要进行几次冒泡
        for (int end=N-1;end>0; end--){
            // 0 1 | 1 2 | 2 3 | ... end-1 end  比较大小，然后交换
            // second代表第二个数字
            for(int second=1;second <= end; second++){
                if(arr[second-1] > arr[second]){
                    swap(arr,second-1,second);
                }
            }
        }

    }

    /**
     * 插入排序
     * 把数据集合分为左边右边两部分，左边长度要保证有序，然后从右边去除第一数放到左边中并保持左边有序
     * 依次循环直到左边长度等于数据集合的长度并且有序
     * @param arr
     */
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int N = arr.length;
        // 0~0 变成有序 完成
        //0~1 变成有序
        //0~2 变成有序
        //0~3 变成有序
        //0~n-1 变成有序

        for (int end=1; end<N; end++){
            int newNumIndex = end;
            while(newNumIndex -1 > 0 && arr[newNumIndex] < arr[newNumIndex-1]){
                swap(arr,newNumIndex,newNumIndex-1);
                newNumIndex--;
            }
        }
    }

    public static void insertSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int N = arr.length;
        // 0~0 变成有序 完成
        //0~1 变成有序
        //0~2 变成有序
        //0~3 变成有序
        //0~n-1 变成有序

        for (int end=1; end<N; end++){
            for(int pre=end-1; pre>0 && arr[pre] > arr[pre + 1]; pre--){
                swap(arr,pre,pre+1);
            }
        }
    }
}
