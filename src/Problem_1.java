/*
 * Given a list of numbers and a number k, return whether any two numbers
 * from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 3, 7);
        int key = 17;
        System.out.println("Two index is: " + getTwoIndexSumOfK(numbers, key));
    }

    private static List<Integer> getTwoIndexSumOfK(List<Integer> numbers, int sum) {
        List<Integer> indexies = new ArrayList<>();

        Map<Integer, Integer> numStore = new HashMap<>();

        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (!numStore.containsKey(sum - number)) {
                numStore.put(number, index);
            } else {
                indexies.add(numStore.get(sum - number));
                indexies.add(index);
            }
        }

        return indexies;
    }
}