public class QueueCircular<E> implements Queueable<E> {
    private Node<E> last;

    public QueueCircular() {
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.last == null);
    }

    public boolean isSingleton() {
        if (this.isEmpty())
            return false;
        else {
            Node<E> first = this.last.getNext();
            return (first == this.last);
        }
    }

    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty!");

        Node<E> first = this.last.getNext();
        return first.getItem();
    }

    @Override
    public void enqueue(E item) {
        Node<E> node = new Node<E>(item);
        if (this.isEmpty()) {
            this.last = node;
            this.last.setNext(node);
        } else {
            Node<E> first = this.last.getNext();
            node.setNext(first);
            last.setNext(node);
            this.last = node;
        }
    }

    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty!");

        Node<E> first = this.last.getNext();
        if (this.isSingleton())
            this.last = null;
        else {
            Node<E> second = first.getNext();
            this.last.setNext(second);
        }
        return first.getItem();
    }

    @Override
    public void dequeueAll() {
        this.last = null;
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return "[]";
        else {
            String s = "[";
            Node<E> current = this.last.getNext(); // first
            while (current != this.last) {
                s = s + current.getItem() + ", ";
                current = current.getNext();
            }
            s = s + this.last.getItem().toString(); 
            return s + "]";
        }
    }
}
