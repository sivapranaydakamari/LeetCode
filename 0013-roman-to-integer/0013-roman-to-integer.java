class Solution {
    public int romanToInt(String s) {
        List<Character> symbols = Arrays.asList('M', 'D', 'C', 'L', 'X', 'V', 'I');
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        int result = 0;
        int size = s.length();
        for(int i = 0; i < size - 1; i++){
            char c1 = s.charAt(i);
            int current = values[symbols.indexOf(c1)];
            char c2 = s.charAt(i + 1);
            int next = values[symbols.indexOf(c2)];
            if(current < next) result -= current;
            else result += current;
        }
        int last = values[symbols.indexOf(s.charAt(size - 1))];
        result += last;
        return result;
    }
}