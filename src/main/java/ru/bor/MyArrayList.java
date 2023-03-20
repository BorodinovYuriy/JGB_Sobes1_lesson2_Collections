package ru.bor;

public class MyArrayList<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_TRIGGER = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int triggerSize = 0;

    public void add(T item) {
        if(triggerSize == array.length-1)
            resize(array.length * 2);

        array[triggerSize++] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }


    public void remove(int index) {
        for (int i = index; i < triggerSize; i++) {
            array[i] = array[i + 1];
        }
        array[triggerSize] = null;
        triggerSize--;
        if (array.length > INIT_SIZE && triggerSize < array.length / CUT_TRIGGER)
            resize(array.length/2);
    }

    public int size() {
        return triggerSize;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, triggerSize);
        array = newArray;
    }

}