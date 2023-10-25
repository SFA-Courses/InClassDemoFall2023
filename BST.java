public class BST<T extends Comparable<T>> {
    private T root;
    private BST<T> left;
    private BST<T> right;

    public BST() {
        this.root = null;
    }

    public BST(T root) {
        this.root = root;
        this.left = new BST<T>();
        this.right = new BST<T>();
    }

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void removeAll() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public int numElements() {
        if (this.isEmpty())
            return 0;
        else
            return 1 + this.left.numElements() + this.right.numElements();
    }

    public int height() {
        if (this.isEmpty())
            return 0;
        else
            return 1 + Math.max(this.left.height(), this.right.height());
    }

    public void add(T item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = new BST<T>();
            this.right = new BST<T>();
        } else {
            int compare = item.compareTo(this.root);
            if (compare < 0)
                this.left.add(item);
            else
                this.right.add(item);
        }
    }

    public void remove(T item) {
        if (this.isEmpty())
            throw new TreeException("Tree is Empty!");

        // recursive stuff
        int result = item.compareTo(this.root);
        if (result < 0)
            this.left.remove(item);
        else if (result > 0)
            this.right.remove(item);
        else {// item is the current root

            // if the item is a leaf
            if (this.left.isEmpty() && this.right.isEmpty())
                this.root = null;
            else if (this.left.isEmpty()) {
                this.root = this.right.root;
                this.left = this.right.left;
                this.right = this.right.right;
            } else if (this.right.isEmpty()) {
                this.root = this.left.root;
                this.left = this.left.left;
                this.right = this.left.right;
            } else {
                T newRoot = this.right.min();
                this.root = newRoot;
                this.right.remove(newRoot);
            }
        }

    }

    public T max() {
        if (this.isEmpty())
            throw new TreeException("Tree is empty!");

        if (this.right.isEmpty())
            return this.root;
        else
            return this.right.max();
    }

    public T min() {
        if (this.isEmpty())
            throw new TreeException("Tree is empty!");

        if (this.left.isEmpty())
            return this.root;
        else
            return this.left.max();
    }

    public String preorder() {
        String s = "";
        if (!this.isEmpty()) {
            s += " " + this.root.toString() + " ";
            s += this.left.preorder();
            s += this.right.preorder();
        }
        return s;
    }

    public String inorder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.inorder();
            s += " " + this.root.toString() + " ";
            s += this.right.inorder();
        }
        return s;
    }

    public String postorder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.postorder();
            s += this.right.postorder();
            s += " " + this.root.toString() + " ";
        }
        return s;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        if (!this.isEmpty())
            buildTreeString(buffer, "", "");
        return buffer.toString();
    }

    private void buildTreeString(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.root.toString());
        buffer.append('\n');
        if (!this.left.isEmpty())
            if (!this.right.isEmpty())
                left.buildTreeString(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            else
                left.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");

        if (!this.right.isEmpty())
            right.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
    }

    public boolean contains(T item) {
        if (this.isEmpty())
            return false;
        else {

            int result = item.compareTo(this.root);
            if (result == 0)
                return true;
            else if (result < 0)
                return this.left.contains(item);
            else // result > 0
                return this.right.contains(item);
        }
    }

}
