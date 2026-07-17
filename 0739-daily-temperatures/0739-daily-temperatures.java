class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty()) stack.push(i);
            else{
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    int topIdx = stack.pop();
                    ans[topIdx] = i - topIdx; 
                }
                stack.push(i);
            }
        }
        return ans;
    }
}