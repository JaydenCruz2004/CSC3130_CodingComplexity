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

    //Problem 2: Common Substring
    public static String commonString(String text1, String text2) {
        StringBuilder sb = new StringBuilder(); //a string is immutable stringbuilder.
        int maxLength = 0;
        //System.out.println(sb); //make sure that cS is empty
        //boolean[] isLength = new boolean[text2.length()];

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
    public static Long notFibonacci(long n) {
        if (n < 0) { // 0(1)
            return 0L; // 0 (1)
        }
        if (n <= 1) {
            return n;
        } else {
            return 3 * notFibonacci(n - 1) + 2 * notFibonacci(n - 2); // 0(3/2^2) exponential
        }
    }

    // Problem 4: Where in Sequence
    public static long whereInSequence(long n) {
        //long[] track = new long[(int) (n + 1)];
        int count = 0;

        if (n < 0) { // 0(1)
            return 0L; // 0 (1)
        }
        if (n <= 1) {
            return n;
        } else {
            //for (int i = 0; i < track.length; i++) {}
            //n = 3 * whereInSequence(n - 1) + 2 * whereInSequence(n - 2);
            //track[count] = n;
            //count ++;
            return n; // 0(3/2^2) exponential
        }
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

        System.out.println(commonSequence(text1, text2));
        System.out.println(commonString(text1, text2));

        //Problem 3: Not Fibonacci
        long n = 11;
        for (int i = 0; i < n; i++) {
            System.out.println(notFibonacci(i));
        }
        //System.out.println(notFibonacci(10));

        //Problem 4: Where in Sequence
        System.out.println(whereInSequence(10));

        //Problem 5: Remove Element
        System.out.println(removeElement(nums, val));
    }
}
