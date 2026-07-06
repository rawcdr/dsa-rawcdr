class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // sort it in asc - if 1st ele is same then for 2nd ele dsc
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int maxend = intervals[0][1];
        int covered = 0;

        // check for maxend interval if it can cover it or not
        for(int i=1;i<intervals.length;i++){
           if(intervals[i][1] <= maxend) covered++;
           else maxend = intervals[i][1]; 
        }

        return intervals.length - covered;
    }
}