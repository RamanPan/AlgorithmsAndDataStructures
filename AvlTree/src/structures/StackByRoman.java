package structures;

public class StackByRoman<T> {
    private Node<T> head;
    private int count = 0;

    public T push( T item) {
        if (head == null) {
            head = new Node<>(item, null);
        } else {
            head = new Node<>(item, head);
        }
        ++count;
        return item;
    }

    public T pop() {
        if (head == null)
            return null;
        T data = head.data;
        head = head.next;
        --count;
        return data;
    }

    public T peek() {
        return head != null ? head.data : null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<T> {
        final T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public int getCount() {
        return count;
    }
}
