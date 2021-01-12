public class BubbleSort {
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void bubbleSort(int[] array) {

        for(int x = 0 ;x<array.length - 1;x++) {
            for (int y = 0; y < array.length - 1 - x; y++) {
                if(array[y] > array[y + 1]) {
                    int temp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = temp;
            }
        }
        }
        printArray(array);
    }
    public static void main(String[] args){
        bubbleSort(new int[]{4,6,3,2,5,1});
    }

}
