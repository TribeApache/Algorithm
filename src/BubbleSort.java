public class BubbleSort {
    static String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]).append(",");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    public static void main(String... args){
        int[] unsorted = {5,2,1,4,0};
        System.out.println("Sorting an array of Length "+unsorted.length);
        enhancedBubbleSort(unsorted);
        //dumbBubbleSort(unsorted);
        //bubbleSort(unsorted);
        //enhancedBubbleSort(unsorted);
        //enhancedBubbleSortBetterStructured(unsorted);
        System.out.println("Sorted Array: "+arrayToString(unsorted));

    }

    // this is the dumbest BubbleSort
    static int[] dumbBubbleSort(int[] array){
        for (int i = 0; i<array.length-1 ; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Just swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("After "+(i+1)+" pass: "+arrayToString(array));
        }
        return array;
    }

    //this "-i" in array.length - 1-i brings some improvement.
    // Then for making our bestcase scenario better ( o(n) , we will introduce isswapped flag) that's enhanced bubble sort

    static int[] bubbleSort(int[] array){
        for (int i = 0; i<array.length-1 ; i++) {
            for (int j = 0; j < array.length - 1-i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("After "+(i+1)+" pass: "+arrayToString(array));
        }
        return array;
    }

    static int[] enhancedBubbleSort(int[] array){
        int i=0;
        while (true) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped =true;
                }
            }
            i++;
            System.out.println("After "+(i)+" pass: "+arrayToString(array));
            if(!swapped){
                // Last iteration (of outer loop) didnot result in any swaps. so stopping here
                break;
            }
        }
        return array;
    }

    static int[] enhancedBubbleSortBetterStructured(int[] array){
        int i=0;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            i++;
            System.out.println("After "+(i)+" pass: "+arrayToString(array));
        }
        return array;
    }
}
