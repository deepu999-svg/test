package Test;

public class Jump {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length && i <= maxReach; ++i) {
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }

    public static void main(String[] args) {
        Jump solver = new Jump();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solver.canJump(nums1)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solver.canJump(nums2)); // Output: false
    }
}

