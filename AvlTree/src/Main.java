import exceptions.InvalidTreeSequence;
import trees.AvlTree;
import trees.BinaryTree;

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
        BinaryTree<Integer> binaryTree = null;
        AvlTree<Integer> avlTree = null;
        PrintTree<Integer> printTree = new PrintTree<>();
        try {
            binaryTree = BinaryTree.fromString(getDataFromFile());
        } catch (InvalidTreeSequence e) {
            throw new RuntimeException(e);
        }
        avlTree = binaryTree.toAVL();
        printTree.printBinaryTree(binaryTree.getRoot());
        printTree.printAvlTree(avlTree.getRoot());
    }
}
