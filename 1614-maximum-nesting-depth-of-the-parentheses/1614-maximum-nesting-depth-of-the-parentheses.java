class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') stack.push(ch);
            else if(ch == ')'){
                int length = stack.size();
                maxDepth = Math.max(maxDepth, length);
                stack.pop();
            }
        }
        return maxDepth;
    }
}