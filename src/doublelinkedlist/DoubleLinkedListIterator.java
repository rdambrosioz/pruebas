package doublelinkedlist;


import java.util.Iterator;

public class DoubleLinkedListIterator<T> implements Iterator<T> {



    private NodoDoble<T> nodo;

    public DoubleLinkedListIterator (NodoDoble<T> nodo) {
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

