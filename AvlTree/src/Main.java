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
        BinaryTree<Integer> binaryTree;
        AvlTree<Integer> avlTree;
        PrintTree<Integer> printTree = new PrintTree<>();
        try {
            binaryTree = BinaryTree.fromString(getDataFromFile());
        } catch (InvalidTreeSequence e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        avlTree = binaryTree.toAVL();
        System.out.println("Бинарной дерево");
        printTree.printBinaryTree(binaryTree.getRoot());
        System.out.println("Прямой обход");
        binaryTree.directTraverse().showElements();
        System.out.println("АВЛ-дерево");
        printTree.printAvlTree(avlTree.getRoot());
        System.out.println("Прямой обход");
        avlTree.directTraverse().showElements();
        System.out.println("Центрированный обход");
        avlTree.centeredTraverse().showElements();
        System.out.println("Обратный обход");
        avlTree.reverseTraverse().showElements();
        System.out.println("Обход в ширину");
        avlTree.breadthTraverse().showElements();

    }
}
