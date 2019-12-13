import java.util.*;

/**
 * A node in a file system tree. Nodes contain the name of a directory
 * or file, and also the size of all the directories and files contained
 * in that directory.
 */
public abstract class Node extends Observable implements Observer {

    /**
     * The name of the directory or file.
     */
    private String name;
    /**
     * The size of the node and all its children, in bytes.
     */
    private int byteSize;

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
}

