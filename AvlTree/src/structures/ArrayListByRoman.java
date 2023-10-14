package structures;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayListByRoman<T> {
    public static final double INCREMENTATION_COEFFICIENT = 1.5D;
    public static final int DEFAULT_CAPACITY = 10;
    private transient Object[] data;
    private int size = 0;

    public ArrayListByRoman() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListByRoman(int size) {
        this.data = new Object[size];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.data.length;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(T element) {
        if (this.size + 1 > this.data.length) {
            Object[] newArray = new Object[(int) Math.round((this.size + 1) * INCREMENTATION_COEFFICIENT)];

            System.arraycopy(data, 0, newArray, 0, data.length);

            newArray[this.size] = element;
            ++this.size;
            this.data = newArray;
        } else {
            this.data[this.size] = element;
            ++this.size;
        }
        return true;
    }

    public boolean removeIf(Predicate<T> predicate) {
        return remove(indexOfFirst(predicate));
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        for (int i = index + 1; i < data.length; i++)
            data[i - 1] = data[i];

        --this.size;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        return (T) this.data[index];
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        T previous = (T) this.data[index];

        this.data[index] = element;
        return previous;
    }

    public boolean contains(Object o) {
        return indexOfFirst(it -> it.equals(o)) != -1;
    }

    public int indexOfFirst(Predicate<T> predicate) {
        for (int i = 0; i < this.size; i++)
            if (predicate.test((T) this.data[i]))
                return i;

        return -1;
    }

    public boolean remove(Object o) {
        return remove(indexOfFirst(it -> it.equals(o)));
    }


    public int indexOf(Object o) {
        return indexOfFirst(it -> it.equals(o));
    }

    public void clear() {
        Arrays.fill(data, null);
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
}
