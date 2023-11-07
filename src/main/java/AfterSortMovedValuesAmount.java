package main.java;

import java.util.*;

public class AfterSortMovedValuesAmount {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3, 3, 7};
        System.out.println(solution(array));
    }

    public static boolean solution(int[] A) {
        int[] newArray = cloneArray(A);
        
        Arrays.sort(A);

        int movementsAmount = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] != newArray[i]){
                movementsAmount++;
            }
        }

        if (movementsAmount < 3){
            return true;
        }

        return false;
    }

    public static int[] cloneArray(int[] A) {
        int[] newArray = new int[A.length];

        for (int i = 0; i < A.length; i++){
            newArray[i] = A[i];
        }

        return newArray;
    }
}
