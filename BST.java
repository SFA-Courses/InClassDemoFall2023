public class BST<T extends Comparable<T>> {























    
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

}