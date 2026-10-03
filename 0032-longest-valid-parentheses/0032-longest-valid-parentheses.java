class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int maxValid = 0;
        int len = 0;
        stack.push(-1);
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else if(ch == ')'){
                if(!stack.isEmpty()){
                    if(stack.peek() == -1 || s.charAt(stack.peek()) == ')'){
                        stack.pop();
                        stack.push(i);
                        continue;
                    }
                    if(s.charAt(stack.peek()) == '('){
                        stack.pop();
                        maxValid = Math.max(maxValid, i - stack.peek());
                    }
                }
            }

        }
        return maxValid;
    }
}