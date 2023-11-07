package main.java;

public class Sorts {
    public static void main(String[] args) {
        quick(new int[]{10, 2, 5, 20, 8, 1}, 0, 3);
    }
    public void insert(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i; j >= 0 && A[j] > A[j + 1]; j--) {
                int temp = A[j];
                A[j] = A[j + 1];
                A[j + 1] = temp;
            }
        }
    }

    private static void quick(int[] array, int begin, int end){
        if(begin < end){
            int pivot = array[end];
            int bigElemIndex = begin -1;
            for (int i = begin; i < end; i++) {
                if(array[i] < pivot){
                    bigElemIndex++;

                    int temp = array[bigElemIndex];
                    array[bigElemIndex] = array[i];
                    array[i] = temp;
                }
            }
            int partIndex = bigElemIndex +1;
            int temp = array[partIndex];
            array[partIndex] = array[end];
            array[end] = temp;

            quick(array, begin, partIndex-1);
            quick(array, partIndex+1, end);
        }
    }
}
