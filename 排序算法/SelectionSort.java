/** 
选择排序：每一次从待排序的数据元素中选出最小（或最大）的一个元素，
存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
然后放到已排序序列的末尾。以此类推，直到全部待排序的数据元素排完。 
选择排序是不稳定的排序方法。
*/
 


public class SelectionSort {
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void selectionSort(int[] array) {

       for(int i = 0; i < array.length; i++){
           //从未排序序列中找到最小值
           int min = i;
           for(int j = i + 1; j < array.length; j++){
                if(array[min] > array[j]){
                    min = j;
                }
           }
           //如果最小值不是 i，则交换 index min 和 i
           if(min != i){
               int temp = array[i];
               array[i] = array[min];
               array[min] = temp;
           }
       }
        printArray(array);
    }
    public static void main(String[] args){
        selectionSort(new int[]{4,6,3,2,5,1});
    }
}
