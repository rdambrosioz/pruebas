package interfaces;

import exceptions.ElementoNoExiste;
import exceptions.EmptyList;
import exceptions.ListOutOfIndex;

public interface Lista <T> extends Iterable<T> {

    void add (T valor, int posicion) throws ListOutOfIndex;
    void add (T valor);
    void addFirst (T valor);

    boolean contains(T valor);

    T remove (int posicion) throws ListOutOfIndex;
    T removeLast ();
    T remove (T valor) throws ElementoNoExiste;

    T get (int posicion) throws ListOutOfIndex;
    T get (T valueToSearch);


    int getSize();

    boolean isInTheList(T valor);

    void visualize(Lista orden);

    String visualize(String str);

    void interchange(T valor, int direccion) throws EmptyList;

    Lista<T> append (Lista<T> lista);

    Lista<T> symmetricDifference(Lista<T> lista);

}
