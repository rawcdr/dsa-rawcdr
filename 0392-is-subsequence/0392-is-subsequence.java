class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Advance pointer in s when characters match
            }
            j++; // Always advance pointer in t
        }
        
        // If i reached s.length(), all characters were found in order
        return i == s.length();
    }
}