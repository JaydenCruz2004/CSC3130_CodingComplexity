// CSC 3130: Introduction to Algorithms
// Assignment 1: Coding and Complexity
// Created by: Jayden Cruz

import java.util.Arrays;

public class Main {

    // Problem 1: Common subsequence
    public static int commonSequence(String text1, String text2) {
        int count = 0; // 0 (1)
        //boolean is used to deal with error that comes when both inputs are diff. length
        boolean[] isLength = new boolean[text2.length()]; //0(1)

        for (int i = 0; i < text1.length(); i++) { // 0(n) where n is text1 length
            for (int j = 0; j < text2.length(); j++) { // 0(m) where  m is text 2 length
                if (text1.charAt(i) == text2.charAt(j) && !isLength[j]) { //0(1)
                    count++; //0(1)
                    isLength[j] = true; //0(1)
                    break; //stops the loop from double couting in some cases. if not the output is repeated for some char.
                }
            }
        }
        //System.out.println(count);
        return count;
    }

    //Problem 2: Common Substring(text)
    public static String commonString(String text1, String text2) {
        StringBuilder sb = new StringBuilder(); //a string is immutable, StringBuilder allow you to add results
        int maxLength = 0; //length of the longest substring

        //System.out.println(sb); //make sure that cS is empty
        //boolean[] isLength = new boolean[text2.length()];

        //reusing loops from problem1
        for (int i = 0; i < text1.length(); i++) { // 0(n)
            for (int j = 0; j < text2.length(); j++) { // 0(n)
                int length = 0;
                //check how far the substrings match
                while (i + length < text1.length() && j + length < text2.length() //0(amount times loops checks i and j)
                        && text1.charAt(i + length) == text2.charAt(j + length)) {
                    length++;
                }
                if (length > maxLength) {
                    maxLength = length;
                    sb = new StringBuilder(text1.substring(i, i + length));
                }
                //isLength[i] = true;
                // break; not need bc of while loop;
            }
        }
        return sb.toString();
    }

    //Problem 3: Not Fibonacci
    public static Long notFib(long n) {
        if (n <= 0) { // 0(1)
            return 0L; // 0 (1)
        }
        if (n <= 1) {
            return n;
        } else {
            return 3 * notFib(n - 1) + 2 * notFib(n - 2); // 0(2^n) exponential
        }
    }

    public static long[] notFibonacci(long n) {
        long[] resultArr = new long[(int) n];

        for (int i = 0; i < n; i++) {
            resultArr[i] = notFib(i);
            //System.out.println(notFib(i));
        }
        return resultArr;
    }

    // Problem 4: Where in Sequence
    public static int dondeInSequence(int n) {
        int i = 0;
        while (true) {
            notFib(i);
            if (notFib(i) > n) {
                return i + 1;
            }
            if (notFib(i) == n) {
                return i + 1;
            }
            i++;
        }
    }

    /*
    parameters are the array from the notFibonacci method and int n, the integer you want the position of
    public static long whereInSequence(long[] resultArr, int n) {
        int i = 0;
        for (i = 0; i < resultArr.length; i++) {
            if (resultArr[i] > n) {
                return i + 1;
            }
            if (resultArr[i] == n) {
                return i + 1;
            } else {
                i = i + 2;
            }
        }
        return whereInSequence(resultArr, i);
    }

     */

    //Problem 5: Remove Element
    public static int removeElement(int[] nums, int val) {
        //keep tracks of non target nums
        int nonVal = 0; //0(1)
        for (int i = 0; i < nums.length; i++) { //0(n) where n is the num of elements in nums array
            if (nums[i] != val) { //0 (1)
                nums[nonVal] = nums[i]; //0(1)
                nonVal++; //0(1)
            }
        }
        // number of elements not equal to val
        return nonVal;
    }
    // time complexity 0(n) best and worse case the same
    // so we can say big theta: 0(n)


    public static void main(String[] args) {
        //String text1 = "almanacs";
        //String text2 = "albatross";
        String text1 = "gears of war";
        String text2 = "History of warriors";

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        //Problem 1: Common Sequence
        System.out.println("Problem 1 Output: " + commonSequence(text1, text2));

        //Problem 2: Common String
        System.out.println("Problem 2 Output: " + commonString(text1, text2));

        //Problem 3: Not Fibonacci
        long[] answer = notFibonacci(10); // saves output into array to be used for problem 4
        System.out.println("Problem 3 Output: " + Arrays.toString(answer));

        //Problem 4: Where in Sequence
        System.out.println("Problem 4 Output: " + dondeInSequence(8));

        //Problem 5: Remove Element
        System.out.println("Problem 5 Output: " + removeElement(nums, val));

        /*
        //Problem: Extra Credit
        long[] extra = notFibonacci(1000);
        System.out.println("Extra Credit: " + Arrays.toString(extra));

         each time the notFib is called it creating the resucrive tree we saw in calss over and over again but 1000 time
         thats why it takes so long, the tree get bigger and bigger each time.
         also in comp org we learned about integer overflow when the int is larger than the max value the variable can hold
         java int (-2147483648 to 2147483647)
         java long (-9223372036854775808 to 9223372036854775807)
        */
    }
}
