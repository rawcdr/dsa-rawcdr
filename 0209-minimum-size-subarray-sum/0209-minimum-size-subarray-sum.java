class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        int left = 0;
        int runsum = 0;

        for(int i=0;i<nums.length;i++){
            runsum += nums[i];

            while(runsum >= target){
                res = Math.min(res, i+1-left);
                runsum -= nums[left];
                left++;
            }
        }

        return (res != Integer.MAX_VALUE) ? res : 0;
    }
}