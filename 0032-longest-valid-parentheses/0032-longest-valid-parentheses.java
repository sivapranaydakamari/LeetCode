class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int maxValid = 0;
        int len = 0;
        int lastValid = -1;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else if(ch == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    if(stack.isEmpty()){
                        maxValid = Math.max(maxValid, i - lastValid);
                    }else{
                        maxValid = Math.max(maxValid, i - stack.peek());
                    }
                }else{
                    lastValid = i;
                }
            }
        }
        return maxValid;
    }
}