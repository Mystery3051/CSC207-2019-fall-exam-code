import java.util.Observable;

/**
 * A directory in a file system, including the number of bytes used
 * by the file.
 */
class File extends Node {

    /**
     * A file named name with size bytes.
     *
     * @param name the name
     * @param size the size in bytes
     */
    public File(String name, int size) {
        super(name, size);
    }

    /**
     * Change the size of a file and update any observers.
     *
     * @param newSize
     */
    public void changeSize(int newSize) {
        setByteSize(newSize);
    }

    @Override
    public void update(Observable o, Object arg) {
        // File objects do not observe any other objects so
        // this should never be reached.
        throw new UnsupportedOperationException();
    }
}
