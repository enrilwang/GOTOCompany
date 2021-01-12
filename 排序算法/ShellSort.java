/*
希尔排序：递减增量排序算法
1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
2.按增量序列个数k，对序列进行k 趟排序；
3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
  分别对各子表进行直接插入排序。
  仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
*/ 



public class ShellSort {

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void shellSort(int[] array){
        int len = array.length;
        while(len!=0){
            //增量为 len/2 len/4 len/8.....1
            len = len/2;
            for(int i = 0; i < len; i++){//每次进行排序的元素数量为len个
                for(int j = i + 1;j < array.length; j+=len){//每次比较的步长为len
                    int k = j - len;
                    int temp = array[j];
                    while(k >= 0 && temp < array[k]){
                        array[k + len] = array[k];
                        k -= len;
                    }
                    array[k + len] = temp;
             }
         }
        }
        printArray(array);
    }
    public static void main(String[] args){
        shellSort(new int[]{4,6,3,2,5,1});
    }
}
