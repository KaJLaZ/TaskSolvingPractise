package main.java;

import java.util.ArrayList;

public class Peaks {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int[] array2 = {1, 2, 1};
        int[] array3 = {1, 2, 3};
        int[] array4 = {0, 1, 0, 0, 1, 0, 0, 1, 0};
        int[] array6 = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
       // System.out.println(solution(array1)); //3
        System.out.println(solution(array2)); //1
        System.out.println(solution(array3)); //0
        System.out.println(solution(array4)); //3
        System.out.println(solution(array6)); //3
    }

    public static int solution(int[] A) {
        if(A.length < 3){
            return 0;
        }

        ArrayList<Integer> picksIndexes = new ArrayList<>(A.length/2);
        for (int i = 1; i < A.length-1; i++) {
            if(A[i] > A[i-1] && A[i] > A[i+1]) {
                picksIndexes.add(i);
            }
        }

        for (int blockSize = 1; blockSize <= A.length; blockSize++) {
            if(A.length % blockSize != 0) {
                continue;
            }

            int blocksAmount = 0;
            for (int pickIndex : picksIndexes) {
                if(pickIndex / blockSize == blocksAmount){
                    blocksAmount++;
                }
            }
            if(blocksAmount == A.length / blockSize) {
                return blocksAmount;
            }
        }
        return 0;
    }
}
