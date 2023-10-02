public interface Stackable<E> {
    public boolean isEmpty();
    public void push(E newItem);
    public E pop() throws StackException;
    public void popAll();
    public E peek() throws StackException;
}
