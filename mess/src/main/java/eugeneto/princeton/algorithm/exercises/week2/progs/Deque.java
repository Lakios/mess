package eugeneto.princeton.algorithm.exercises.week2.progs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 08.10.15
 * Time: 9:34
 * To change this template use File | Settings | File Templates.
 */
public class Deque<Item> implements Iterable<Item> {
    private Element first = null;
    private Element last = null;
    private int size;

    // construct an empty deque
    public Deque() {}

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        Element e = new Element();
        e.item = item;
        if (first == null) {
            first = e;
            last = e;
        } else {
            Element cur = first;
            first = e;
            e.next = cur;
            cur.prev = e;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        Element e = new Element();
        e.item = item;
        if (last == null) {
            first = e;
            last = e;
        } else {
            Element cur = last;
            last = e;
            cur.next = e;
            e.prev = cur;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null) throw new NoSuchElementException();
        Element cur = first;
        first = first.next;
        cur.next = null;
        if (size == 1) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return cur.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (first == null) throw new NoSuchElementException();
        Element cur = last;
        last = last.prev;
        cur.prev = null;
        if (size == 1) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return cur.item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Element cur;

            @Override
            public boolean hasNext() {
                if (cur == null) return first != null;
                return cur.next != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                if (cur == null) {
                    cur = first;
                    return first.item;
                } else {
                    Element el = cur.next;
                    cur = cur.next;
                    return el.item;
                }
            }
        };
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.isEmpty();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeLast();
        deque.removeLast();
    }

    private class Element {
        Item item;
        Element next;
        Element prev;
    }
}
