package deque;

import java.lang.reflect.Array;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        firstIndex = 4;
        lastIndex = 4;
        size = 0;
    }

    public void addFirst(Item i) {
        if (size == items.length) {
            resize(size * 2);
        }
        firstIndex = ((firstIndex - 1) + items.length) % items.length;
        items[firstIndex] = i;
        size++;
    }

    public void addLast(Item i) {
        if (size == items.length) {
            resize(size * 2);
        }
        lastIndex = (lastIndex + 1) % items.length;
        items[lastIndex] = i;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if ((size < items.length / 4) && (size > 4)) {
            resize(items.length / 2);
        }
        Item first = get(firstIndex);
        items[firstIndex] = null;

        firstIndex = (firstIndex + 1) % items.length;
        size--;
        return first;
    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        if ((size < items.length / 4) && (size > 4)) {
            resize(items.length / 2);
        }
        Item last = get(lastIndex);
        items[lastIndex] = null;

        lastIndex = ((lastIndex - 1) + items.length) % items.length;
        size--;
        return last;
    }

    //Potential complications if downsizing by greater than a factor of 2.
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        if (lastIndex < firstIndex) {
            int firstCopy = items.length - firstIndex;
            System.arraycopy(items, firstIndex, temp, (int) (size / 2), firstCopy);
            System.arraycopy(items, 0, temp, (int) (size / 2) + firstCopy, size - firstCopy);
        } else {
            System.arraycopy(items, firstIndex, temp, (int) (size / 2), size);
        }
        items = temp;
        firstIndex = size / 2;
        lastIndex = size + size / 2;
    }

    public int size() {return size;}
    public Item get(int index) {return items[(firstIndex + index) % items.length];}
    public boolean isEmpty(){return size == 0;}
}
