class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals; // base case check

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // sort based in start

        List<int []> merged = new ArrayList<>();

        int curr[] = intervals[0]; // add the 1st interval
        merged.add(curr);

        for (int[] interval : intervals) {
            int currend = curr[1]; 
            int nextst = interval[0];
            int nextend = interval[1];

            if (nextst <= currend) {
                curr[1] = Math.max(currend, nextend);
            } else {
                curr = interval; // add the new one as it doesn't match
                merged.add(curr);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}