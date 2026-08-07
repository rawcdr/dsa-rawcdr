class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maj = nums.length / 2;

        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);

            if (cnt > maj) return num;
        }

        return -1;
    }
}