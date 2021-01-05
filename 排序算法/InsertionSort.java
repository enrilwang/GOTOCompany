
/*
插入排序: 要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
现在要把第n个数插到前面的有序数中，
使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
插入排序是稳定的排序算法
*/ 


public class InsertionSort{

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void insertSort(int[] array){

        int len = array.length;
        int insertNumber;
        //从index 1 开始，array中的第一个元素已经排好序了
        for(int i = 1;i < len; i++){
            insertNumber = array[i];
            //已经排好序的subarray的长度是i
            int j = i-1;
            //最多循环 i 次并在 array[j] 小于 array[i]的 时候终止
            while(j >=0  && array[j]>insertNumber){
                array[j + 1] = array[j];
                j--;
            }
            //将array[i]赋值给array[j+1]
            array[j + 1] = insertNumber;
        }
        printArray(array);
    }
    
    public static void main(String[] args){
        insertSort(new int[]{4,6,3,2,5,1});
    }

}