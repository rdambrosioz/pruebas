package interfaces;

import exceptions.EmptyQueue;
import exceptions.ListOutOfIndex;

public interface DoubleQueue<T> {

    void enqueueLeft (T element);

    T dequeueLeft () throws EmptyQueue;

    void enqueueRight (T element);

    T dequeueRight () throws EmptyQueue;

    boolean isEmpty();

    T get (int posicion) throws ListOutOfIndex;

    int getSize();

    void visualize(Lista orden);

    String visualize(String str);
}
