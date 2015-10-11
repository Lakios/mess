package eugeneto.princeton.algorithm.week1.part1.exercises.week2.progs;

import com.sun.xml.internal.fastinfoset.stax.events.ReadIterator;
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
    private Item[] elementData = (Item[]) new Object[128];

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
        return val;
    }

    // return (but do not remove) a random item
    public Item sample() {
        return elementData[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ReadIterator();
    }

    // unit testing
    public static void main(String[] args) {

    }

    private void grow() {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public class RIterator implements Iterator<Item> {
        private Item[] items;
        private int index = 0;

        public RIterator() {
            items = Arrays.copyOf(elementData, elementData.length);
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
