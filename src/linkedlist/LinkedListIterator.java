package linkedlist;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

    private Nodo<T> nodo;

    public LinkedListIterator(Nodo<T> nodo) {
        this.nodo = nodo;
    }


    @Override
    public boolean hasNext() {
        return (nodo != null);
    }

    @Override
    public T next() {
        T valueToReturn = nodo.getValor();
        nodo = nodo.getSiguiente();
        return valueToReturn;
    }
}
