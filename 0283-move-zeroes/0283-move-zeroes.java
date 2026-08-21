class Solution {
    public void moveZeroes(int[] nums) {
        int temp[] = new int[nums.length];

        int t = 0;

        for(int num : nums) {
            if (num != 0) {
                temp[t] = num;
                t++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}