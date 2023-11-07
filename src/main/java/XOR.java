package main.java;

public class XOR {
    public static void main(String[] args) {
        System.out.println("swap");
        swap();
        System.out.println("missingNumber");
        findMissingNumber();
    }

    public static void swap(){
        int a = 4;
        int b = 7;

        System.out.println("a " + a);
        System.out.println("b " + b);

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println("a " + a);
        System.out.println("b " + b);
    }

    public static void findMissingNumber(){
        int[] arr = { 1, 2, 3, 4, 5, 6, 8};

        int arrSum = 0;
        int normSum = arr.length ^ arr.length + 1;
        for(int i = 0; i < arr.length; i++){
            arrSum ^= arr[i];
            normSum ^= i;
        }

        System.out.println(arrSum ^ normSum);
    }
}
