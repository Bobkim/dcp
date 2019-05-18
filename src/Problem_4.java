import java.util.HashMap;
import java.util.Map;

/* [leet code 41] https://leetcode.com/problems/first-missing-positive/
 *
 * Given an array of integers, find the first missing positive integer
 * in linear time and constant space. In other words, find the lowest
 * positive integer that does not exist in the array. The array can contain
 * duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0]
 * should give 3. You can modify the input array in-place.
 * */
public class Problem_4 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 0};
        int[] nums = {3, 2, 1};
//        int[] nums = {7,8,9,11,12};
//        int[] nums = {3, 4, -1, 1};
        System.out.println("the number is: " + firstMissingPositive(nums));
    }

    // it comes from https://leetcode.com/problems/first-missing-positive/discuss/17126/Beat-100-Fast-Elegant-Java-Index-Based-Solution-with-Explanation
    public static int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            // If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        int k = 1;

        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n && nums[k] == k) {
            k++;
        }

        // If it breaks because of empty array or reaching the end. K must be the
        // first missing number.
        if (n == 0 || k < n) {
            return k;
        } else {  // If k is hiding at position 0, K+1 is the number.
            return nums[0] == k ? k + 1 : k;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int firstMissingPositiveNonConstantSpace(int[] nums) {

        int theNumber = -1;

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = 1;
        Map<Integer, String> store = new HashMap<>(10);
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] <= 0) {
                continue;
            }
            minNumber = Math.min(minNumber, nums[index]);
            maxNumber = Math.max(maxNumber, nums[index]);
            store.put(nums[index], "");
        }
        int index = minNumber;
        if (index > 1) {
            theNumber = 1;
        } else {

            for (; index <= maxNumber; index++) {
                if (!store.containsKey(index)) {
                    theNumber = index;
                    break;
                }
            }

            if (index > maxNumber) {
                theNumber = index;
            }
        }

        return theNumber;
    }
}
