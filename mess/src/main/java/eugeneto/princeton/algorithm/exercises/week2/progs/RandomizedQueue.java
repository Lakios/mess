package eugeneto.princeton.algorithm.exercises.week2.progs;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 08.10.15
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] elementData = (Item[]) new Object[16];

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();
        int index = StdRandom.uniform(size);
        Item val = elementData[index];
        elementData[index] = elementData[size - 1];
        elementData[size - 1] = null;
        size--;
        if (size > 0 && size <= elementData.length / 4) {
            elementData = Arrays.copyOf(elementData, elementData.length / 2);
        }
        return val;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (size == 0) throw new NoSuchElementException();
        return elementData[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RIterator();
    }

    // unit testing
    public static void main(String[] args) {
        RandomizedQueue<Integer> r = new RandomizedQueue<>();
        r.enqueue(1);
        r.enqueue(2);
        r.enqueue(3);
        r.enqueue(4);
        r.enqueue(5);
        r.enqueue(6);
        System.out.println(r.dequeue());
        System.out.println(r.dequeue());
        System.out.println(r.dequeue());
        System.out.println(r.dequeue());
        System.out.println(r.dequeue());
        System.out.println(r.dequeue());
    }

    private void grow() {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private class RIterator implements Iterator<Item> {
        private Item[] items;
        private int index = 0;

        public RIterator() {
            items = Arrays.copyOf(elementData, size);
            StdRandom.shuffle(items);
        }


        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[index++];
        }
    }
}
