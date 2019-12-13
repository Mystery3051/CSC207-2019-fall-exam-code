import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * A directory in a file system, including the name of the directory and the
 * number of bytes used by the directory and its children.
 */
class Dir extends Node implements Observer {

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
     * Make info a child of this directory and notify any observers of the
     * size change. Also make this node observe info.
     *
     * @param info the new child
     */
    @Override
    public void addChild(Node info) {
        super.addChild(info);
        info.addObserver(this);
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
