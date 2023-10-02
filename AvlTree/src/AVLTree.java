public class AVLTree {
    private NodeAvl root;

    public NodeAvl find(int key) {
        NodeAvl current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public NodeAvl getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private NodeAvl insert(NodeAvl nodeAvl, int key) {
        if (nodeAvl == null) {
            return new NodeAvl(key);
        } else if (nodeAvl.key > key) {
            nodeAvl.left = insert(nodeAvl.left, key);
        } else if (nodeAvl.key < key) {
            nodeAvl.right = insert(nodeAvl.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(nodeAvl);
    }

    private NodeAvl delete(NodeAvl nodeAvl, int key) {
        if (nodeAvl == null) {
            return nodeAvl;
        } else if (nodeAvl.key > key) {
            nodeAvl.left = delete(nodeAvl.left, key);
        } else if (nodeAvl.key < key) {
            nodeAvl.right = delete(nodeAvl.right, key);
        } else {
            if (nodeAvl.left == null || nodeAvl.right == null) {
                nodeAvl = (nodeAvl.left == null) ? nodeAvl.right : nodeAvl.left;
            } else {
                NodeAvl mostLeftChild = mostLeftChild(nodeAvl.right);
                nodeAvl.key = mostLeftChild.key;
                nodeAvl.right = delete(nodeAvl.right, nodeAvl.key);
            }
        }
        if (nodeAvl != null) {
            nodeAvl = rebalance(nodeAvl);
        }
        return nodeAvl;
    }

    private NodeAvl mostLeftChild(NodeAvl nodeAvl) {
        NodeAvl current = nodeAvl;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private NodeAvl rebalance(NodeAvl z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private NodeAvl rotateRight(NodeAvl y) {
        NodeAvl x = y.left;
        NodeAvl z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private NodeAvl rotateLeft(NodeAvl y) {
        NodeAvl x = y.right;
        NodeAvl z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(NodeAvl n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(NodeAvl n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(NodeAvl n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
}
