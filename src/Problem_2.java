/*For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 *[120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output
 * would be [2, 3, 6].
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> numbers = Arrays.asList(3, 2, 1);
        System.out.println("The new list: " + makeNewList(numbers));
    }

    private static List<Long> makeNewList(List<Integer> numbers) {
        List<Long> newList = new ArrayList<>();

        long product = 1;
        for (int index = 0; index < numbers.size(); index++) {
            product = product * numbers.get(index);
        }

        for (int index = 0; index < numbers.size(); index++) {
            newList.add(product / numbers.get(index));
        }

        return newList;
    }
}
