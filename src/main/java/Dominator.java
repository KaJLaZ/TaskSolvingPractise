package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
* */

public class Dominator {
    public static void main(String[] args) {
        int[] array = {3, 4, 3, 2, 3, -1, 3, 3};

        System.out.println(solution(array));

    }

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> IndMap = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            int j = A[i];
            if(map.containsKey(j)){
                map.put(j, map.get(j)+1);
            }
            else {
                map.put(j, 1);
                IndMap.put(j, i);
            }
        }

        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        Set<Integer> keys = map.keySet();
        for(int key : keys) {
            int temp = map.get(key);
            if(temp > maxValue){
                maxValue = temp;
                maxKey = key;
            }
        }

        if(maxValue < Math.floor(A.length / 2) +1){
            return -1;

        }

        return IndMap.get(maxKey);
    }
}
