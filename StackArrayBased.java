public class StackArrayBased<E> implements Stackable<E> {

    // array to hold the elements of the stack
    private Object[] items; // Java does not allow Generic arrays
    private int top; // index of the top
    private static final int MAX = 50; // arbitrary choice

    public StackArrayBased() {
        this.items = new Object[MAX];
        this.top = -1; // not a valid index -- tells us the stack is empty
    }

    @Override
    public boolean isEmpty() {
        return (this.top == -1); // this.top < 0
    }

    public boolean isFull() {
        return (this.top == MAX - 1);
    }

    @Override
    public void popAll() {
        this.top = -1;
        this.items = new Object[MAX];
    }

    @Override
    public void push(E newItem) throws StackException {
        if (this.isFull())
            throw new StackException("Stack is at maximum capacity.");

        this.top++;
        this.items[top] = newItem;

    }

    @Override
    public E pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty!");

        E item = (E) this.items[this.top];

        // optional free memory
        this.items[this.top] = null;

        this.top--;
        return item;
    }

    @Override
    public E peek() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty!");

        return (E) this.items[this.top];
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = top; i >= 0; i--) {
            s = s + this.items[i].toString();
            if (i != 0)
                s = s + ", ";
        }
        s = s + "]";
        return s;        
    }

}
