import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    NodeBinary root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private NodeBinary addRecursive(NodeBinary current, int value) {

        if (current == null) {
            return new NodeBinary(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(NodeBinary current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNodeBinary(int value) {
        return containsNodeBinaryRecursive(root, value);
    }

    private boolean containsNodeBinaryRecursive(NodeBinary current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeBinaryRecursive(current.left, value)
                : containsNodeBinaryRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private NodeBinary deleteRecursive(NodeBinary current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(NodeBinary root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseInOrder(NodeBinary NodeBinary) {
        if (NodeBinary != null) {
            traverseInOrder(NodeBinary.left);
            visit(NodeBinary.value);
            traverseInOrder(NodeBinary.right);
        }
    }

    public void traversePreOrder(NodeBinary NodeBinary) {
        if (NodeBinary != null) {
            visit(NodeBinary.value);
            traversePreOrder(NodeBinary.left);
            traversePreOrder(NodeBinary.right);
        }
    }

    public void traversePostOrder(NodeBinary NodeBinary) {
        if (NodeBinary != null) {
            traversePostOrder(NodeBinary.left);
            traversePostOrder(NodeBinary.right);
            visit(NodeBinary.value);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<NodeBinary> NodeBinarys = new LinkedList<>();
        NodeBinarys.add(root);

        while (!NodeBinarys.isEmpty()) {

            NodeBinary NodeBinary = NodeBinarys.remove();

            System.out.print(" " + NodeBinary.value);

            if (NodeBinary.left != null) {
                NodeBinarys.add(NodeBinary.left);
            }

            if (NodeBinary.right != null) {
                NodeBinarys.add(NodeBinary.right);
            }
        }
    }

    public void traverseInOrderWithoutRecursion() {
        Stack<NodeBinary> stack = new Stack<>();
        NodeBinary current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            NodeBinary top = stack.pop();
            visit(top.value);
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<NodeBinary> stack = new Stack<>();
        NodeBinary current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderWithoutRecursion() {
        Stack<NodeBinary> stack = new Stack<>();
        NodeBinary prev = root;
        NodeBinary current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }
}
