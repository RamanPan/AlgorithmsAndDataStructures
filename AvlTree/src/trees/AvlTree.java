package trees;

import structures.ArrayListByRoman;
import structures.LinkedListByRoman;
import structures.StackByRoman;

public class AvlTree<T extends Comparable<T>> {
    private AvlNode<T> root;

    private AvlNode<T> rotateRight(AvlNode<T> node) {
        AvlNode<T> left = node.leftChild;
        node.leftChild = left.rightChild;
        left.rightChild = node;
        node.fixHeight();
        left.fixHeight();

        return left;
    }

    private AvlNode<T> rotateLeft(AvlNode<T> node) {
        AvlNode<T> right = node.rightChild;
        node.rightChild = right.leftChild;
        right.leftChild = node;
        node.fixHeight();
        right.fixHeight();

        return right;
    }

    private AvlNode<T> balance(AvlNode<T> node) {
        node.fixHeight();
        int nodeBalanceFactor = AvlNode.balanceFactor(node);
        if (nodeBalanceFactor == 2) {
            if (AvlNode.balanceFactor(node.rightChild) < 0)
                node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        } else if (nodeBalanceFactor == -2) {
            if (AvlNode.balanceFactor(node.leftChild) > 0)
                node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        } else
            return node;
    }

    private AvlNode<T> getMinimal(AvlNode<T> node) {
        return node.leftChild != null ? getMinimal(node.leftChild) : node;
    }

    private AvlNode<T> removeMinimal(AvlNode<T> node) {
        if (node.leftChild == null)
            return node.rightChild;
        node.leftChild = removeMinimal(node.leftChild);
        return balance(node);
    }

    public AvlNode<T> find(T needle) {
        return findNode(root, needle);
    }

    private AvlNode<T> findNode(AvlNode<T> root, T needle) {
        if (root == null || root.data.equals(needle))
            return root;
        else
            return findNode(
                    needle.compareTo(root.data) < 0 ? root.leftChild : root.rightChild,
                    needle
            );
    }

    public void remove(T needle) {
        remove(getRoot(), needle);
    }

    private AvlNode<T> remove(AvlNode<T> root, T needle) {
        if (root == null) return null;
        int comparatorResult = needle.compareTo(root.data);
        if (comparatorResult < 0)
            root.leftChild = remove(root.leftChild, needle);
        else if (comparatorResult > 0)
            root.rightChild = remove(root.rightChild, needle);
        else {
            AvlNode<T> left = root.leftChild;
            AvlNode<T> right = root.rightChild;
            root.rightChild = root.leftChild = null;

            if (right == null)
                return left;

            AvlNode<T> minimal = getMinimal(right);
            minimal.rightChild = removeMinimal(right);
            minimal.leftChild = left;

            return balance(minimal);
        }

        return balance(root);
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    private AvlNode<T> insert(T data, AvlNode<T> root) {
        if (root == null)
            return new AvlNode<>(data);
        else if (data.compareTo(root.data) < 0)
            root.leftChild = insert(data, root.leftChild);
        else
            root.rightChild = insert(data, root.rightChild);
        return balance(root);
    }

    public AvlNode<T> getRoot() {
        return root;
    }

    public ArrayListByRoman<T> directTraverse() {
        return directTraverse(root, new ArrayListByRoman<>());
    }

    public ArrayListByRoman<T> directTraverse(AvlNode<T> node, ArrayListByRoman<T> array) {
        if (node == null)
            return null;

        StackByRoman<AvlNode<T>> treeNodeStackByRoman = new StackByRoman<>();
        treeNodeStackByRoman.push(node);
        while (!treeNodeStackByRoman.isEmpty()) {
            AvlNode<T> n = treeNodeStackByRoman.pop();
            array.add(n.data);
            if (n.rightChild != null) treeNodeStackByRoman.push(n.rightChild);
            if (n.leftChild != null) treeNodeStackByRoman.push(n.leftChild);
        }

        return array;
    }

    public ArrayListByRoman<T> centeredTraverse() {
        return centeredTraverse(root, new ArrayListByRoman<>());
    }

    public ArrayListByRoman<T> centeredTraverse(AvlNode<T> node, ArrayListByRoman<T> array) {

        StackByRoman<AvlNode<T>> stack = new StackByRoman<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.pop();
            array.add(node.data);
            node = node.rightChild;
        }
        return array;
    }

    public ArrayListByRoman<T> reverseTraverse() {
        return reverseTraverse(root, new ArrayListByRoman<>());
    }

    public ArrayListByRoman<T> reverseTraverse(AvlNode<T> node, ArrayListByRoman<T> array) {
        if (node == null)
            return null;
        StackByRoman<AvlNode<T>> stack = new StackByRoman<>();
        StackByRoman<AvlNode<T>> resultStack = new StackByRoman<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            AvlNode<T> current = stack.pop();
            resultStack.push(current);
            if (current.leftChild != null) {
                stack.push(current.leftChild);
            }

            if (current.rightChild != null) {
                stack.push(current.rightChild);
            }
        }
        while (!resultStack.isEmpty()) {
            array.add(resultStack.pop().data);
        }
        return array;
    }

    public ArrayListByRoman<T> breadthTraverse() {
        return breadthTraverse(root);
    }

    private ArrayListByRoman<T> breadthTraverse(AvlNode<T> node) {
        ArrayListByRoman<T> values = new ArrayListByRoman<>();
        ArrayListByRoman<AvlNode<T>> queue = new ArrayListByRoman<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            AvlNode<T> current = queue.get(0);
            queue.remove(0);
            values.add(current.data);
            if (current.leftChild != null)
                queue.add(current.leftChild);
            if (current.rightChild != null)
                queue.add(current.rightChild);
        }

        return values;
    }


}