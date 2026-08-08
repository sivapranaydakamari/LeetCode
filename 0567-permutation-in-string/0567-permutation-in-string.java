class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for(char ch: s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int windowSize = s1.length();
        for(int i = 0; i < windowSize; i++){
            char c = s2.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        if(s1Map.equals(windowMap)) return true;
        if(s2.length() == windowSize) return false;

        int start = 0;
        for(int end = s1.length(); end < s2.length(); end++){
            char next = s2.charAt(end);
            windowMap.put(next, windowMap.getOrDefault(next, 0) + 1);

            char first = s2.charAt(start);
            windowMap.put(first, windowMap.get(first) - 1);
            if(windowMap.get(first) == 0){
                windowMap.remove(first);
            }
            start++;

            if(s1Map.equals(windowMap)) return true;
        }
        return false;
    }
}