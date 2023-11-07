package main.java;

public class Chairs {
    public static void main(String[] args) {
        int n = 6;
        int sum = 1;
        int prev = 1;
        for(int i = 1; i < n ;i ++){
            int temp = sum;
            sum = prev + sum;
            prev = temp;
        }
        System.out.println(sum);

    }
}
