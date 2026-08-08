class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            boolean dies = false;
            while(!stack.isEmpty() && stack.peek() > 0 && current < 0){
                int top = stack.peek();
                if(top > Math.abs(current)){
                    dies = true;
                    break;
                }
                else if(top == Math.abs(current)){
                    stack.pop();
                    dies = true;
                    break;
                }else{
                    stack.pop();
                }
            }
            if(!dies) stack.push(current);
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        for(int num: stack){
            ans[i++] = num;
        }
        return ans;
    }
}