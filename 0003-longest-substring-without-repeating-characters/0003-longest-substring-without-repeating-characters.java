class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0, start = 0, end = 0;
        while(end < s.length() && start <= end){
            char ch = s.charAt(end);
            if(!set.contains(ch)){
                set.add(ch);
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            }else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength; 
    }
}