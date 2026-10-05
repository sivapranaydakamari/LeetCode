class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else if(ch == ')'){
                int open = stack.pop();
                if(i - open == 1){
                    score += 1;
                }else{
                    int inside = 0;
                    int depth = 0;
                    for(int j = open + 1; j < i; j++){
                        if(s.charAt(j) == '('){
                            depth++;
                        }else{
                            if(s.charAt(j - 1) == '('){
                                inside += 1 << (depth - 1);
                            }
                            depth--;
                        }
                    }
                    score -= inside;
                    score += 2 * inside;
                }
            }
        }
        return score;
    }
}