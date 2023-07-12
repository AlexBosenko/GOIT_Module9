package myarraylist;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 2;
    private Object[] data;
    private int index;

    public MyArrayList() {
        this.data = new Object[INIT_SIZE];
    }

    public void add(T value) {
        resizeData();

        data[index] = value;
        index++;
    }

    private void resizeData() {
        if (index == data.length) {
            //System.out.println("Resize happened, index = " + index + ", length = " + data.length);

            int newSize = data.length + (data.length >> 1);
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, data.length);

            data = newData;
        }
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.index - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return index;
    }

    public void clear() {
        data = new Object[INIT_SIZE];
        index = 0;
    }

    public void remove(int index) {
        checkIndex(index);

        Object[] newData = Arrays.copyOf(data, data.length - 1);
        System.arraycopy(data, index + 1, newData, index, data.length - index - 1);

        this.index--;

        data = newData;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < index; i++) {
            joiner.add(String.valueOf(data[i]));
        }

        return "[" + joiner + "]";
    }
}
