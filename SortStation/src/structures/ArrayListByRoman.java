package structures;

import java.util.Arrays;

public class ArrayListByRoman<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T item) {
        if (pointer == array.length - 1)
            resize(array.length * 2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public boolean contains(T object) {
        for (int i = 0; i < pointer; ++i) {
            if (get(i).equals(object)) return true;
        }
        return false;
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    @Override
    public String toString() {
        return "ArrayListByRoman{" +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
