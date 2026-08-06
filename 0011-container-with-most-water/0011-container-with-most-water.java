class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxh = Integer.MIN_VALUE;

        while (l < r){
            maxh = Math.max(maxh, (Math.min(height[l], height[r]) * (r - l)));

            if (height[l] > height[r]) r--;
            else l++;
        }

        return maxh;
    }
}