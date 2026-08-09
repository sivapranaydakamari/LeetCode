class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                char operator = str.charAt(0);
                int second = stack.pop();
                int first = stack.pop();
                int result = switch(operator) {
                    case '+' -> first + second;
                    case '-' -> first - second;
                    case '*' -> first * second;
                    case '/' -> first / second;
                    default -> 0;
                };
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}