import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static String getDataFromFile() {
        try {
            return Files.readAllLines(Path.of("resources\\data.txt")).get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        System.out.println(getDataFromFile());
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.insert(3);
        avlTree.insert(5);
        PrintTree.printBinaryTree(avlTree.getRoot());
    }
}
