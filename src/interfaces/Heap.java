package interfaces;

public interface Heap<T extends Comparable<T>> {

    void insert(T value);

    T getMax();

    T deleteMax();

    int size();







}
