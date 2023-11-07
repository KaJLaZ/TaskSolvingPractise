package main.java;

import java.util.TreeSet;

/*Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].*/

public class MissingInteger {
    public static void main(String[] args) {
        int array[] = {-1, -3};
        System.out.println(solution(array));
    }
    public static int solution(int[] A){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i] > 0){
                set.add(A[i]);
            }
        }

        if(set.isEmpty()){
            return 1;
        }

        int last = set.first();

        if(last > 1){
            return 1;
        }

        for (int pool: set) {
            if(pool - last > 1){
                return last + 1;
            }
            last = pool;
        }

        return set.last() + 1;
    }
}
