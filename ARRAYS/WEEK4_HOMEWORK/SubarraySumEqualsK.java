import java.util.HashMap;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSums = new HashMap<>();

        prefixSums.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int number : nums) {

            currentSum = currentSum + number;

            if (prefixSums.containsKey(currentSum - k)) {
                count = count + prefixSums.get(currentSum - k);
            }

            prefixSums.put(
                    currentSum,
                    prefixSums.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}