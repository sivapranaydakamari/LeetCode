class StockSpanner {
    public record Pair(Integer price, Integer span){};
    Stack<Pair> stack;
    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        if(stack.isEmpty()){
            stack.push(new Pair(price, count));
        }else{
            while(!stack.isEmpty() && stack.peek().price() <= price){
                count += stack.pop().span();
            }
            stack.push(new Pair(price, count));
        }
        return stack.peek().span();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */