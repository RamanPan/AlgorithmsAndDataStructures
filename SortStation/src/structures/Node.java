package structures;

public class Node<T> {
    // The actual data
    T data;
    // Reference to the next node
    Node<T> next;
    // Reference to the prev node
    Node<T> prev;

    /**
     * Constructor.
     * Note that the next and prev variables are set to null, thus this is the "root-node"
     *
     * @param data node data
     */
    Node(T data) {
        this(null, data, null);
    }

    /**
     * Constructor.
     *
     * @param data node data
     * @param next reference to next node
     * @param prev reference to the previous node
     */
    Node(Node<T> prev, T data, Node<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
