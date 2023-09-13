public abstract class ListADT<E> {
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract void removeAll();
    public abstract void add(int index, E item) throws ListException;
    public abstract E get(int index) throws ListException;
    public abstract void remove(int index) throws ListException;
}
