package main.java;

import java.util.ArrayList;
import java.util.Arrays;

/*
* A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
The number of semiprimes within each of these ranges is as follows:

(1, 26) is 10,
(4, 10) is 4,
(16, 20) is 0.
Write a function:

class Solution { public int[] solution(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
M is an integer within the range [1..30,000];
each element of arrays P and Q is an integer within the range [1..N];
P[i] ≤ Q[i].
* */
public class Semiprimes {
    public static void main(String[] args) {
        int[] firstArray = {1, 4, 16};
        int[] secondArray = {26, 10, 20};

        int[] result = solution(26, firstArray, secondArray);

        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        int[] primes = new int[N];
        int primeSize = 0;
        int sqrt = N /2;
        for (int i = 2; i <= sqrt; i++) {
            if(isPrime(i)){
                primes[primeSize] = i;
                primeSize++;
            }
        }

        ArrayList<Integer> semis = new ArrayList<>(primeSize * primeSize);

        for (int i = 0; i < primeSize; i++) {
            for (int j = i; j < primeSize - i; j++) {
                int semi = primes[i] * primes[j];
                if(semi <= N){
                    semis.add(semi);
                }
            }
        }
        semis.sort(Integer::compareTo);
        int[] sum = new int[N+1];
        int semiCounter = 1;

        for (int semi : semis) {
            sum[semi] = semiCounter;
            semiCounter++;
        }

        for (int i = 1; i < N+1; i ++) {
            if(sum[i] == 0) {
                sum[i] = sum[i-1];
            }
        }

        int[] res = new int [P.length];
        for (int i = 0; i < P.length; i++) {
            res[i] = sum[Q[i]] - sum[P[i]-1];
        }

        return res;
    }

    public static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
