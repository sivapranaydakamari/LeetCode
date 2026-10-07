class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> brackets = new Stack<>(); 
        Stack<Integer> star = new Stack<>(); 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                brackets.push(i);
            }else if(ch == '*'){
                star.push(i);
            }else{
                if(!brackets.isEmpty()){
                    brackets.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else return false;
            }
        }
        while(!brackets.isEmpty() && !star.isEmpty()){
            int openIdx = brackets.pop();
            int starIdx = star.pop();
            if(starIdx < openIdx) return false;
        }
        return brackets.isEmpty();
    }
}