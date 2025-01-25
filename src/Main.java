import java.util.Arrays;

public class Main {

    // Problem 1: Common subsequence
    public static int commonSequence(String text1, String text2) {
        int count = 0;
        //boolean is used to deal with error that comes when both inputs are diff. sizes
        boolean[] isLength = new boolean[text2.length()];

        for (int i = 0; i < text1.length(); i++) { // 0(n)
            for (int j = 0; j < text2.length(); j++) { // 0(n)

                if (text1.charAt(i) == text2.charAt(j) && !isLength[j]) {
                    count++;
                    isLength[i] = true;
                    break; //stops the loop from repeating. if not the output is doubled.
                }
            }
        }
        //System.out.println(count);
        return count;
    }

    //Problem 2: Common Substring(text)
    public static String commonString(String text1, String text2) {
        StringBuilder sb = new StringBuilder(); //a string is immutable StringBuilder.
        int maxLength = 0;
        //System.out.println(sb); //make sure that cS is empty
        //boolean[] isLength = new boolean[text2.length()];

        //reusing loops from problem1
        for (int i = 0; i < text1.length(); i++) { // 0(n)
            for (int j = 0; j < text2.length(); j++) { // 0(n)
                int length = 0;
                while (i + length < text1.length() && j + length < text2.length() && text1.charAt(i + length) == text2.charAt(j + length)) {
                    length++;
                }
                if (length > maxLength) {
                    maxLength = length;
                    sb = new StringBuilder(text1.substring(i, i + length));
                }
                //isLength[i] = true;
                // break; //stops the loop from repeating. if not the output is doubled.
            }
        }
        return sb.toString();
    }

    //Problem 3: Not Fibonacci
    public static Long notFib(long n) {
        if (n < 0) { // 0(1)
            return 0L; // 0 (1)
        }
        if (n <= 1) {
            return n;
        } else {
            return 3 * notFib(n - 1) + 2 * notFib(n - 2); // 0(3/2^2) exponential
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
    //parameters are the array from the notFibonacci method and int n, the integer you want the position of
    public static long whereInSequence(long[] resultArr, int n) {
        int i = 0;
        for (i = 0; i < resultArr.length; i++) {
            if (resultArr[i] > n) {
                return i - 1;
            }
            if (resultArr[i] == n) {
                return i + 1;
            } else {
                i = i + 2;
            }
        }
        return whereInSequence(resultArr, i);
    }

    public static long dondeInSequence(long n) {
        int i = 0;
        for (i = 0; i < 10; i++) {
            while (true) {
                notFib(i);
                if (notFib(i) == n) {
                    return i + 1;
                }

                if (notFib(i) > n) {
                    return i;
                }

            }
        }
        return n;
    }

    //Problem 5: Remove Element
    public static int removeElement(int[] nums, int val) {
        int index = 0;  // This will keep track of where to place non-`val` elements
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // If current element is not equal to `val`, copy it to the `index` position
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;  // Increment index to move to the next available position
            }
        }
        // `index` now represents the new length of the array with `val` removed
        return index;
    }


    public static void main(String[] args) {
        //String text1 = "almanacs";
        //String text2 = "albatross";
        String text1 = "spy family";
        String text2 = "jujutsu kaisen";

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        System.out.println("Problem 1 Output: " + commonSequence(text1, text2));
        System.out.println("Problem 2 Output: " + commonString(text1, text2));

        //Problem 3: Not Fibonacci
        long[] answer = notFibonacci(10);
        System.out.println("Problem 3 Output: " + Arrays.toString(answer));

        //Problem 4: Where in Sequence
        System.out.println("Problem 4 Output: " + dondeInSequence(8));

        //Problem 5: Remove Element
        System.out.println("Problem 5 Output: " + removeElement(nums, val));
    }
}
