import org.w3c.dom.traversal.NodeIterator;

import java.util.*;

/**
 * A node in a file system tree. Nodes contain the name of a directory
 * or file, and also the size of all the directories and files contained
 * in that directory.
 */
public abstract class Node extends Observable implements Iterable<Node> {

    /**
     * The name of the directory or file.
     */
    private String name;
    /**
     * The size of the node and all its children, in bytes.
     */
    private int byteSize;

    /**
     * The children of this node.
     */
    private List<Node> children = new ArrayList<>();

    /**
     * A new Node representing a file or directory name of size byteSize.
     *
     * @param name     the name of the file or directory.
     * @param byteSize the size of the file or the directory and all its children.
     */
    public Node(String name, int byteSize) {
        this.name = name;
        this.byteSize = byteSize;
    }

    /**
     * Make info a child of this directory and notify any observers of the
     * size change.
     *
     * @param info the new child
     */
    public void addChild(Node info) {
        children.add(info);
        setByteSize(getByteSize() + info.getByteSize());
    }

    /**
     * Return the name of the file or directory.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the size in bytes of the file or the directory and all its children.
     *
     * @return the size in bytes
     */
    public int getByteSize() {
        return byteSize;
    }

    /**
     * Set the size of this node to byteSize and notify any observers.
     *
     * @param byteSize
     */
    public void setByteSize(int byteSize) {
        int oldSize = this.byteSize;
        this.byteSize = byteSize;
        setChanged();
        notifyObservers(byteSize - oldSize);
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator();
    }

    /**
     * Iterator over the children of this node. Replacement for getChildren() method.
     */
    class NodeIterator implements Iterator<Node> {

        int i = 0;

        @Override
        public boolean hasNext() {
            return i < children.size();
        }

        @Override
        public Node next() {
            Node oldNode = children.get(i);
            if (hasNext()) { i++;}
            return oldNode;
        }
    }
}

