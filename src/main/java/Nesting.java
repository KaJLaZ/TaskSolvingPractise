package main.java;

import java.util.LinkedList;

/*A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S is made only of the characters '(' and/or ')'.*/

public class Nesting {
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(calculate(s));
    }

    public static int calculate(String S){
        char[] array = S.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        for(char i : array){
            if(i == '('){
                stack.add(i);
            }

            else {
                if(stack.isEmpty()){
                    return 0;
                }
            }

        }


        return stack.isEmpty() ? 1 : 0;
    }
}
