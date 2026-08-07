class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0;
        int cnt = 0;

        for (int num : nums) {
            if (cnt == 0) cand = num;

            cnt += (num == cand) ? 1 : -1;
        }

        return cand;
    }
}