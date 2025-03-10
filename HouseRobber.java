class Solution {
    public int rob(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        int skip = 0;
        int take = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }

        return Math.max(skip, take);
    }
}
