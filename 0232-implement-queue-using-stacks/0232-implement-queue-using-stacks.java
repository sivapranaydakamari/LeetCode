class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int top = 0;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(s1.isEmpty()) top = x;
        s1.push(x);
    }
    
    public int pop() {
        int n = s1.size();
        for(int i = 0; i < n - 1; i++) s2.push(s1.pop());
        if(!s2.isEmpty()) top = (int) s2.peek();
        int peek = s1.pop();
        n = s2.size();
        for(int i = 0; i < n; i++){
            s1.push(s2.pop());
        }
        return peek;
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */