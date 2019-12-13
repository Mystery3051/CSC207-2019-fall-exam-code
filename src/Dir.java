import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * A directory in a file system, including the name of the directory and the
 * number of bytes used by the directory and its children.
 */
class Dir extends Node {

    /**
     * The list of directories contained in this directory.
     */
    private List<Dir> directories = new ArrayList<>();
    /**
     * The list of files contained in this directory.
     */
    private List<File> files = new ArrayList<>();

    public Dir(String name) {
        super(name, 100);
    }

    /**
     * Update the size of this node by sizeDelta, the size difference from
     * this observed child.
     */
    @Override
    public void update(Observable o, Object sizeDelta) {
        setByteSize(getByteSize() + (Integer) sizeDelta);
    }
}
