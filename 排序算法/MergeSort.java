/**
 * 归并排序：1.将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
 *       2. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
 *       3. 重复步骤 2，直到所有元素排序完毕。
 */

import java.util.Arrays;

public class MergeSort {

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static int[] mergeSort(int[] array) {
        if(array.length <= 1) return array;
        int num = array.length/2;
        int[] leftArr = Arrays.copyOfRange(array, 0, num);
        int[] rightArr = Arrays.copyOfRange(array, num, array.length);
        System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];
        while(i < arr1.length && j< arr2.length){
            if(arr1[i] > arr2[j]){
                result[k++] = arr2[j++];
            }else{
                result[k++] = arr1[i++];
            }
        }
        while(i < arr1.length){
            result[k++] = arr1[i++];
        }
        while(j < arr2.length){
            result[k++] = arr2[j++];
        }
        System.out.println("Merging: " + Arrays.toString(result));
        return result;
    }
    public static void main(String[] args) {
        int[] array = new int[]{4,6,3,2,5,1};
        System.out.println(Arrays.toString(mergeSort(array))); 
    }
}
