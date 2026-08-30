class StockSpanner {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int i = 0;
    public StockSpanner() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public int next(int price) {    
        int ans = 0;
        while(!s1.isEmpty() && !s2.isEmpty() && s2.peek() <= price){
            s1.pop();
            s2.pop();
             
        }
        if(s1.isEmpty())
        ans = i+1;
        else
        ans = i - s1.peek();

        s1.push(i);
        s2.push(price);
        i++;

        return ans;
    }
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */