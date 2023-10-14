package trees;

public class AvlNode<T> {
    T data;
    short height;
    AvlNode<T> leftChild;
    AvlNode<T> rightChild;

    public AvlNode(T data) {
        this.data = data;
    }

    public void fixHeight() {
        short hl = height(leftChild);
        short hr = height(rightChild);
        height = (short) (Math.max(hl, hr) + 1);
    }

    public static int balanceFactor(AvlNode node) {
        return height(node.rightChild) - height(node.leftChild);
    }

    public static short height(AvlNode node) {
        return node != null ? node.height : 0;
    }

    public T getData() {
        return data;
    }

    public short getHeight() {
        return height;
    }

    public AvlNode<T> getLeftChild() {
        return leftChild;
    }

    public AvlNode<T> getRightChild() {
        return rightChild;
    }
}