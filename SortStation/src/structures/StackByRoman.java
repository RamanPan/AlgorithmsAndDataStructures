package structures;

public class StackByRoman<T> {
    private ArrayListByRoman<T> arr;
    private int top;

    public StackByRoman() {
        arr = new ArrayListByRoman<>();
        top = -1;
    }

    public void push(T value) {
        arr.add(value);
        top++;
    }

    public T getTopElement() {
        return isEmpty() ? null : arr.get(top);
    }

    public T pop() {
        T result = null;
        if (!isEmpty()) {
            result = arr.get(top);
            arr.remove(top--);
        }
        return result;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        return "StackByRoman{" +
                "arr=" + arr +
                ", top=" + top +
                '}';
    }
}
