/**
 * Demonstrate the directory and file sizes.
 */
public abstract class FileSystemSizes {

    /**
     * Demonstrate the process of creating a few directories and files
     * and making a file system size tree.
     * @param args
     */
    public static void main(String[] args) {

        Node root = new Dir("root");
        Node child1 = new Dir("dir1");
        Node child2 = new Dir("dir2");
        Node child3 = new File("f1.txt", 10);
        Node grandchild1 = new Dir("dirdir");
        Node grandchild2 = new File("g1.txt", 20);

        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);
        child2.addChild(grandchild1);
        child2.addChild(grandchild2);

        System.out.println("--------------------------------");
        printTree(root, "");
        File newLeaf = new File("leaf.txt", 100);
        grandchild1.addChild(newLeaf);

        System.out.println("--------------------------------");
        printTree(root, "");
        newLeaf.changeSize(200);

        System.out.println("--------------------------------");
        printTree(root, "");
    }

    /**
     * Print the names and sizes of all nodes in a file system size tree.
     * @param node the root of the current subtree
     * @param indent the prefix of spaces to print before node
     */
    public static void printTree(Node node, String indent) {
        System.out.println(
                String.format("%s %s %d bytes",
                        indent, node.getName(), node.getByteSize()));

        for (Node child : node.getChildren()) {
                printTree(child, indent + "  ");
            }
    }
}