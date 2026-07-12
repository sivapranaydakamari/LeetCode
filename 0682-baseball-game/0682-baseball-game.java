class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(String str: operations){
            if(str.equals("C")){ 
                sum -= stack.pop();
            }
            else if(str.equals("D")){
                int val = 2 * stack.peek();
                sum += val;
                stack.push(val);
            }else if(str.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                int val = first + second;
                sum += val;
                stack.push(val);
            }else{
                int val = Integer.parseInt(str);
                sum += val;
                stack.push(val);
            }
        }
        return sum;
    }
}