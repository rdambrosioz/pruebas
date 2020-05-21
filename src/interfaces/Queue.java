package interfaces;

import exceptions.EmptyQueue;
import exceptions.ListOutOfIndex;

public interface Queue<T> extends Iterable<T>{

    void enqueue (T element);

    void enqueueWithPriority (T element);

    T dequeue () throws EmptyQueue;

    boolean isEmpty();

    T get (int posicion) throws ListOutOfIndex;

    int getSize();

    String visualize(String str);


}
