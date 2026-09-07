class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        int pre = 0;

        map.put(0, 1);

        for (int num : nums) {
            pre += num;
            int need = pre - k;

            if (map.containsKey(need)) cnt += map.get(need);

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return cnt;
    }
}