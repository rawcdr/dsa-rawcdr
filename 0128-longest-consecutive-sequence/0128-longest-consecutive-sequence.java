class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int max = 1;
        int cnt = 1;

        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i+1] == nums[i] + 1) {
                cnt++;
                max = Math.max(cnt, max);
            } else {
                cnt = 1;
            }
        }

        max = Math.max(max, cnt);
        return max;
    }
}