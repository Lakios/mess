package eugeneto.princeton.algorithm.week1.part1.exercises.week2.progs;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 08.10.15
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr = new Item[100];
    private int size;

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

    }

    // remove and return a random item
    public Item dequeue() {
        StdRandom.uniform()
    }

    // return (but do not remove) a random item
    public Item sample() {

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {

    }

    // unit testing
    public static void main(String[] args) {

    }

    private class Element {
        Item item;
        Element next;
        Element prev;
    }
}
