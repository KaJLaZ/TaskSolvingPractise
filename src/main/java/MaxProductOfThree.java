package main.java;/*A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].*/


public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] array = {-5, 5, -5, 4};
        System.out.println(solution(array));
    }
    public static int solution(int[] A) {
        int fMax = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE +1;
        int tMax = Integer.MIN_VALUE +2;
        int fMin = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE- 1;
        int tMin = Integer.MAX_VALUE- 2;

        for(int i = 0; i < A.length; i++){
            if(A[i] > fMax){
                if(A[i] > fMax){
                    if(A[i] > sMax){
                        if(A[i] > tMax){
                            fMax = sMax;
                            sMax = tMax;
                            tMax = A[i];
                        }
                        else {
                            fMax = sMax;
                            sMax = A[i];
                        }
                    }
                    else {
                        fMax = A[i];
                    }
                }
            }
            if(A[i] < fMin){
                if(A[i] < sMin){
                    if(A[i] < tMin){
                        fMin = sMin;
                        sMin = tMin;
                        tMin = A[i];
                    }
                    else {
                        fMin = sMin;
                        sMin = A[i];
                    }
                }
                else {
                    fMin = A[i];
                }
            }
        }

        int first = fMax * sMax * tMax;
        int second = sMin * tMin * tMax;

        
        return Math.max(first, second);
    }

    static void quick(int[] array, int beg, int end){
        if(beg < end){
            int pivot = end;
            int bigNum = beg-1;
            for(int i = beg; i < end; i++){
                if(array[i] < array[pivot]){
                    bigNum++;

                    int temp = array[i];
                    array[i] = array[bigNum];
                    array[bigNum] = temp;
                }
            }
            bigNum++;
            int temp = array[bigNum];
            array[bigNum] = array[pivot];
            array[pivot] = temp;

            quick(array, 0, bigNum-1);
            quick(array, bigNum+1, end);
        }
    }
}
