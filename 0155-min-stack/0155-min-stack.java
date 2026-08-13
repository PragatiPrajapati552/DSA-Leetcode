class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;

    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value) {
        s.push(value);

        if (min.isEmpty() || value <= min.peek()) {
            min.push(value);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}