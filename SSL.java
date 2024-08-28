package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue; // Skip duplicates

            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue; // Skip duplicates

                int left = b + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int currSum = nums[a] + nums[b] + nums[left] + nums[right];
                    if (currSum == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                        while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                        left++;
                        right--;
                    } else if (currSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Sum solver = new Sum();
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println(solver.fourSum(nums1, target1)); // Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println(solver.fourSum(nums2, target2)); // Output: [[2,2,2,2]]
    }
}

