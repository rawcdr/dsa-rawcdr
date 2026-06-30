class Solution {
    public int numberOfSubstrings(String s) {
        int lp[] = new int[] {-1, -1, -1};
        int cnt = 0;

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            lp[curr-'a'] = i;
            int l = Math.min(lp[0], Math.min(lp[1], lp[2]));
            cnt += l + 1;
        }
        
        return cnt;
    }
}