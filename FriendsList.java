public class FriendsList extends ListADT<Friend> {
    private int numFriends;
    private Node<Friend> head;

    // for an empty list
    public FriendsList() {
        this.numFriends = 0;
        this.head = null;
    }

    // for a list with a starting item (friend)
    public FriendsList(Friend firstFriend) {
        this.numFriends = 1;
        this.head = new Node<Friend>(firstFriend);
    }

    @Override
    public int size() {
        return this.numFriends;
    }

    @Override
    public boolean isEmpty() {
        return (this.numFriends == 0);
    }

    @Override
    public void removeAll() {
        this.numFriends = 0;
        this.head = null;
    }

    private Node<Friend> getNodeAt(int index) {
        Node<Friend> n = this.head; // index 0
        // n.getNext() // index 1
        // n.getNext().getNext() // index 2

        // automate this
        for (int k = 1; k <= index; k++)
            n = n.getNext();

        return n;
    }

    @Override
    public Friend get(int index) throws ListException {
        if (index < 0 || index >= this.size())
            throw new ListException("Index " + index +
                    " is invalid for a list of size " + this.size());

        Node<Friend> node = this.getNodeAt(index);
        return node.getItem();
    }

    @Override
    public void add(int index, Friend item) throws ListException {
          if (index < 0 || index > this.size())
            throw new ListException("Index " + index +
                    " is invalid for a list of size " + this.size());


        Node<Friend> newFriend = new Node<Friend>(item);
        if (index == 0) { // start of the list
            newFriend.setNext(this.head);
            this.head = newFriend;
        } else {
            Node<Friend> previous = this.getNodeAt(index-1);
            Node<Friend> currentAtIndex = previous.getNext();

            previous.setNext(newFriend);
            newFriend.setNext(currentAtIndex);
        }
        this.numFriends++; // nice
    }

    @Override
    public void remove(int index) throws ListException {
        if (index < 0 || index >= this.size())
            throw new ListException("Index " + index +
                    " is invalid for a list of size " + this.size());

        if (index == 0) { // remove the first element
            this.head = this.head.getNext();
        } else { // removing an element from the middle or end of the list
            Node<Friend> previous = this.getNodeAt(index - 1);
            Node<Friend> nodeToRemove = previous.getNext();
            Node<Friend> successor = nodeToRemove.getNext();

            previous.setNext(successor);
            nodeToRemove.setNext(null);
        }

        this.numFriends--;
    }

    @Override
    public String toString() {
        String s = "[";
        if (this.size() > 0) {
            Node<Friend> current = this.head;
            for (int i = 0; i < this.size() - 1; i++) {
                s = s + current.getItem().toString() + ", ";
                current = current.getNext();
            }
            s = s + current.getItem().toString(); 
        }
        return s + "]";
    }
}
