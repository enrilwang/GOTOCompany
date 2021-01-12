/** 
 堆排序：
 * 1. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
 * 2. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
 * 3. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
 * @param arr  待排序数组
*/

public class HeapSort {
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void heapSort(int[] array) {
        for(int i = array.length;i > 0; i--){
            max_heapify(array, i);
            int temp = array[0];
            array[0] = array[i - 1];
            array[i - 1] = temp;
        }
        printArray(array);
    }
    public static void max_heapify(int[] array, int limit){
        if(array.length <= 0||array.length < limit){
            return;
        }
        int parent_Idx = limit / 2;
        for(; parent_Idx >= 0; parent_Idx--){
            //如果子节点超出或者等于limit，则跳过循环，防止越界访问
            if(parent_Idx * 2 >= limit) continue;
            //决定左孩子和右孩子以及最大的孩子
            int left = parent_Idx * 2;
            int right = left + 1 >= limit ? left:(left + 1);
            int maxChildId = array[left] >= array[right]? left : right;
            //如果左右子节点中的最大值大于父亲，则进行交换
            if(array[maxChildId] > array[parent_Idx]){
                int temp = array[maxChildId];
                array[maxChildId] = array[parent_Idx];
                array[parent_Idx] = temp;
            }

        }
    }
    public static void main(String[] args){
        heapSort(new int[]{4,6,3,2,5,1});
    }
}
