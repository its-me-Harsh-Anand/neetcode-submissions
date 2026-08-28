class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int minl = Math.min(len1, len2);
        String ans = "";
        for(int i=0; i<minl; i++){
            ans += word1.charAt(i);
            ans += word2.charAt(i);
        }
        if(len1==len2) return ans;

        if(minl == len1){
            ans += word2.substring(minl, len2);
        } else {
            ans += word1.substring(minl, len1);
        }
        return ans;
    }
}