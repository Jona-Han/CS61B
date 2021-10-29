package deque;

import java.lang.reflect.Array;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    public void addFirst(Item i) {
        if (size == items.length) {
            resize(size * 2);
        }
        Item[] temp = items;
        System.arraycopy(temp, 0, temp, 1, size);
        items[0] = i;
        size++;
    }

    public void addLast(Item i) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = i;
        size++;
    }

    public Item removeFirst() {
        if ((size < items.length / 4) && (size > 4)) {
            resize(items.length / 4 );
        }
        Item first = get(0);
        size--;
        System.arraycopy(items, 1, items, 0, size - 1);
        return first;
    }

    public Item removeLast() {
        if ((size < items.length / 4) && (size > 4)) {
            resize(items.length / 4);
        }
        Item last = get(size - 1);
        items[size - 1] = null;
        size--;
        return last;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public int size() {return size;}
    public Item get(int index) {return items[index];}
    public boolean isEmpty(){return size == 0;}
}
