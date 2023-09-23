package structures;

import java.util.NoSuchElementException;

public class LinkedListByRoman<T> {
    private Node<T> head;

    private int size;

    public LinkedListByRoman() {
        head = null;
    }

    public void addHead(T x) {
        if (isEmpty())
            head = new Node<T>(x);
        else {
            Node<T> temp = head;
            head = new Node<T>(null, x, temp);
            head.next.prev = head;
        }
        size++;
    }

    public void add(T x) {
        if (isEmpty())
            head = new Node<T>(x);
        else {
            Node<T> temp = head;
            // Traverse till end of list
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<T>(temp, x, null);
        }
        size++;
    }

    public void add(T x, T y,Mode mode) {
        if(mode.equals(Mode.AFTER)) {
            if (isEmpty())
                throw new NoSuchElementException("Element " + x.toString() + " not found");

            Node<T> current = head;

            // Looping through until found
            while (current != null && !current.data.equals(x))
                current = current.next;

            // If null, not found
            if (current == null)
                throw new NoSuchElementException("Element " + x.toString() + " not found");

            // Not null, value found
            Node<T> newNode = new Node<T>(current, y, current.next);
            if (current.next != null)
                current.next.prev = newNode;
            current.next = newNode;

            size++;
        }
        else {
            if (isEmpty())
                throw new NoSuchElementException("Element " + x.toString() + " not found");

            Node<T> current = head;

            // Looping through until found
            while (current != null && !current.data.equals(x))
                current = current.next;

            // If null, not found
            if (current == null)
                throw new NoSuchElementException("Element " + x.toString() + " not found");

            Node<T> newNode = new Node<T>(current.prev, y, current);
            if (current.prev != null)
                current.prev.next = newNode;
            else
                head = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void remove(T x) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        // Removing front element
        if (head.data.equals(x)) {
            head = head.next;
            return;
        }

        Node<T> current = head;

        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;

        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        // It has a next pointer, so not the last node.
        if (current.next != null)
            current.next.prev = current.prev;

        current.prev.next = current.next;

        size--;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        StringBuilder builder = new StringBuilder("[");

        while (temp != null) {
            builder.append(temp.data).append(",");
            temp = temp.next;
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
