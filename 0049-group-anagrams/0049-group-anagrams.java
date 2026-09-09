class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String key = new String(c);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }

            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }
}