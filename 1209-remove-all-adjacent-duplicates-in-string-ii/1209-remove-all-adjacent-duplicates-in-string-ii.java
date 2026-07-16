class Solution {
    record Pair(char character, int count){}
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new Pair(ch, 1));
            }else{
                Pair top = stack.pop();
                if(ch == top.character()){
                    stack.push(new Pair(ch, top.count() + 1));
                }else{
                    stack.push(new Pair(top.character(), top.count()));
                    stack.push(new Pair(ch, 1));
                }
            }
            if(stack.peek().count() == k){
                stack.pop();
            }
        }

        StringBuilder ans = new StringBuilder();
        for(Pair p: stack){
            for(int i = 0; i < p.count(); i++){
                ans.append(p.character());
            }
        }
        return ans.toString();
    }
}