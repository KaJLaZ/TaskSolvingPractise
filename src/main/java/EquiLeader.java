package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/*
* A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].*/

public class EquiLeader {
    public static void main(String[] args) {
        int[] array = {4, 3, 4, 4, 4, 2};
        System.out.println(solution(array));
    }
    public static int solution(int[] A) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            list.addFirst(A[i]);
            if(list.size() > 1 && !Objects.equals(list.get(0), list.get(1))){
                list.removeFirst();
                list.removeFirst();
            }
        }
        if(list.isEmpty()){
            return 0;
        }
        int leader = list.getFirst();
        int overallLeaderCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == leader){
                overallLeaderCounter++;
            }
        }
        int equi = 0;
        int rightLeaderCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == leader) {
                rightLeaderCounter++;
            }
            if(rightLeaderCounter > (i+1)/2 && (overallLeaderCounter - rightLeaderCounter) > ((A.length - i -1)/2)){
                equi++;
            }
        }

        return equi;
    }
}
