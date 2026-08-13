class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {

    }
    
    public void push(int x) {
        if(!q1.isEmpty())
        q1.add(x);
        else
        q2.add(x);
    }
    
    public int pop() {
        // if(q1.isEmpty())
        // return -1
        int val = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
            val = q1.remove();
            if(!q1.isEmpty())
            q2.add(val);
            }
        }
        else{
            while(!q2.isEmpty()){
            val = q2.remove();
            if(!q2.isEmpty())
            q1.add(val);
            }
        }
        return val;
    }
    
    public int top() {
          int val = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
            val = q1.remove();
            q2.add(val);
            }
        }
        else{
            while(!q2.isEmpty()){
            val = q2.remove();
            q1.add(val);
            }
        }
        return val;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */