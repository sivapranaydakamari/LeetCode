class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int moves = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(stack.isEmpty()) moves++;
                else{
                    stack.pop();
                    continue;
                }
            }else if(ch == '('){
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            moves++;
            stack.pop();
        }
        return moves;
    }
}