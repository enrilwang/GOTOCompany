/**
 * 快速排序（递归）
 *
 * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
 * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @param arr   待排序数组
 * @param low   左边界 
 * @param high  右边界
 */
public class QuickSort {
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    
    public static void quickSort(int[] array, int low, int high) {
       if(low >= high){
           return;
       }

       int left = low;
       int right = high;

       int pivot = array[left];
       while(left < right){
            //从后向前找小于pivot的元素
            while(left < right &&array[right] >= pivot){
                right--;
            }
            array[left] = array[right];
            //从前向后找大于pivot的元素
            while(left < right &&array[left] <= pivot){
                left++;
            }
            array[right] = array[left];
       }
       array[left] = pivot;
       quickSort(array, low, left - 1);
       quickSort(array, left + 1, high);       
    }
    public static int[] Partition(int[] arr1, int[] arr2){
        return null;
    }
    public static void main(String[] args) {
        int[] array = new int[]{4,6,3,2,5,1};
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }
}
