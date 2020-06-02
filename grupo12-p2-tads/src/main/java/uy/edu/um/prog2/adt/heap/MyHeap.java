package uy.edu.um.prog2.adt.heap;

public interface MyHeap<T extends Comparable<T>> {

    void insert(T value);

    T getMax();

    T deleteMax();

    int size();


}
