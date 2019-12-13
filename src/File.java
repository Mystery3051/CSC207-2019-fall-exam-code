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
}
