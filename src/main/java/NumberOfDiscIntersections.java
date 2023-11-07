package main.java;/*
* We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
* */

public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 1, 4, 0};
        System.out.println(solution(array));
    }

    public static int solution(int[] A) {
        int right = 0;
        int[] rightDist = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if( A[i] >= A.length -i -1){
                right = A.length -1;
            }
            else {
                right = i + A[i];
            }
            rightDist[right]++;
        }

        for (int i = 1; i < rightDist.length; i++) {
            rightDist[i] += rightDist[i-1];
        }

        long n = A.length;
        long intersections = n * (n - 1) / 2;

        int left = 0;
        for (int i = 0; i < A.length; i++) {
            if(i - A[i] < 0){
                left = 0;
            }
            else {
                left = i - A[i];
            }

            if(left > 0){
                intersections -= rightDist[left -1];
            }
        }

        if (intersections > 10000000){
            return -1;
        }

        return (int)intersections;
    }
}
