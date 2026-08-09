class MinStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        s1.push(value);
        if(s2.isEmpty() || value <= s2.peek()){
            s2.push(value);
        }
    }
    
    public void pop() {
        if(s1.peek().equals(s2.peek())){
            s2.pop();
        }
        s1.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */