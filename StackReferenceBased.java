public class StackReferenceBased<E> implements Stackable<E> {
    private Node<E> top;

    public StackReferenceBased() {
        this.top = null; 
    }

    @Override
    public boolean isEmpty() {
        return (this.top == null);
    }

    @Override
    public void popAll() {
        this.top = null;
    }

    @Override
    public void push(E newItem) {
        Node<E> newTop = new Node<E>(newItem);
        newTop.setNext(this.top);
        this.top = newTop;
    }

    @Override
    public E peek() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty.");
        
        return this.top.getItem();
    }
    @Override
    public E pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty.");

        E item = this.top.getItem();
        this.top = this.top.getNext();
        return item;
    }

    @Override
    public String toString() {
        String s = "[";
        Node<E> current = this.top;
        while (current != null) {
            s = s + current.getItem().toString();
            current = current.getNext();
            if (current != null)
                s = s + ", ";
        }
        return s + "]";
    }
    

   
}
