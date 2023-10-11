public class QueueFirstLast<E> implements Queueable<E> {

    private Node<E> first;
    private Node<E> last;

    public QueueFirstLast() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.first == null);
    }

    @Override
    public void dequeueAll() {
        this.first = null;
        this.last = null;
    }

    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is Empty!");

        return this.first.getItem();
    }

    @Override
    public void enqueue(E item) {
        Node<E> node = new Node<E>(item);

        if (this.isEmpty())
            this.first = node;
        else
            this.last.setNext(node);

        this.last = node;
    }

    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is Empty!");

        E returnValue = this.first.getItem(); // this.peek();

        Node<E> secondNode = this.first.getNext();
        this.first = secondNode;
       //this.first = this.first.getNext();
        return returnValue;
    }

    @Override
    public String toString() {
        String s = "[";
        Node<E> current = this.first;
        while (current != null) {
            s = s + current.getItem();
            current = current.getNext();

            if (current != null)
                s = s + ", ";
        }
        return s + "]";
    }

}
