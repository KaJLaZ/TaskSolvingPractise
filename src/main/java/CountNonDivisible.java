package main.java;

import java.util.Arrays;
    import java.util.HashMap;
import java.util.HashSet;

public class CountNonDivisible {
    public static void main(String[] args) {
        int[] array1 = {3, 1, 2, 3, 6};
        array1 = solution(array1);

        for (int i : array1) {
            System.out.println(i);
        }

        System.out.println("////");

        int[] array2 = {4, 4};
        array2 = solution(array2);

        for (int i : array2) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] A) {
        int[][] array = new int[A.length*2+1][2];

        for (int i = 0; i < A.length; i++) {
            array[A[i]][0]++;
            array[A[i]][1] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            if(array[A[i]][1] !=-1){
                continue;
            }
            array[A[i]][1] = 0;
            for (int j = 1; j <= Math.sqrt(A[i]); j++) {
                if(A[i] % j == 0 && A[i] / j != j) {
                    array[A[i]][1] += array[j][0];
                    array[A[i]][1] += array[A[i]/j][0];
                }
                else if (A[i] % j == 0 && A[i] / j == j) {
                    array[A[i]][1] += array[j][0];
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - array[A[i]][1];
        }
        return A;
    }
}
