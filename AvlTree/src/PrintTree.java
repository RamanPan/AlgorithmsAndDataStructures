import trees.AvlNode;
import trees.TreeNode;

import java.util.LinkedList;

public class PrintTree<T> {
    private void printSpace(double n, TreeNode<T> removed) {
        for (; n > 0; n--) {
            System.out.print("\t");
        }
        if (removed == null) {
            System.out.print(" ");
        } else {
            System.out.print(removed.getData());
        }
    }

    private int heightOfTree(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return 1
                + Math.max(heightOfTree(root.getLeftChild()),
                heightOfTree(root.getRightChild()));
    }

    public void printBinaryTree(TreeNode<T> root) {
        LinkedList<TreeNode<T>> treeLevel = new LinkedList<>();
        treeLevel.add(root);
        LinkedList<TreeNode<T>> temp = new LinkedList<>();
        int counter = 0;
        int height = heightOfTree(root) - 1;
        double numberOfElements
                = (Math.pow(2, (height + 1)) - 1);
        while (counter <= height) {
            TreeNode<T> removed = treeLevel.removeFirst();
            if (!temp.isEmpty()) printSpace(numberOfElements / Math.pow(2, counter), removed);
            else printSpace(numberOfElements / Math.pow(2, counter + 1), removed);
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            } else {
                temp.add(removed.getLeftChild());
                temp.add(removed.getRightChild());
            }
            if (treeLevel.isEmpty()) {
                System.out.println("");
                System.out.println("");
                treeLevel = temp;
                temp = new LinkedList<>();
                counter++;
            }
        }
    }

    private void printSpace(double n, AvlNode<T> removed) {
        for (; n > 0; n--) {
            System.out.print("\t");
        }
        if (removed == null) {
            System.out.print(" ");
        } else {
            System.out.print(removed.getData());
        }
    }

    private int heightOfTree(AvlNode<T> root) {
        if (root == null) {
            return 0;
        }
        return 1
                + Math.max(heightOfTree(root.getLeftChild()),
                heightOfTree(root.getRightChild()));
    }

    public void printAvlTree(AvlNode<T> root) {
        LinkedList<AvlNode<T>> treeLevel = new LinkedList<>();
        treeLevel.add(root);
        LinkedList<AvlNode<T>> temp = new LinkedList<>();
        int counter = 0;
        int height = heightOfTree(root) - 1;
        double numberOfElements
                = (Math.pow(2, (height + 1)) - 1);
        while (counter <= height) {
            AvlNode<T> removed = treeLevel.removeFirst();
            if (temp.isEmpty()) {
                printSpace(numberOfElements / Math.pow(2, counter + 1), removed);
            } else {
                printSpace(numberOfElements / Math.pow(2, counter), removed);
            }
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            } else {
                temp.add(removed.getLeftChild());
                temp.add(removed.getRightChild());
            }

            if (treeLevel.isEmpty()) {
                System.out.println("");
                System.out.println("");
                treeLevel = temp;
                temp = new LinkedList<>();
                counter++;
            }
        }
    }
}
