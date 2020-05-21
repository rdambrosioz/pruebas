package interfaces;

import java.util.List;

public interface BinarySearchTree<K extends Comparable<K>, T> extends Iterable<T> {

    void insert (K key, T value);

    void delete (K key);

    boolean contains(K key);

    int size();

    int countLeaf();

    int countCompleteElement();

    Lista<T> inOrder();

    Lista<T> preOrder();

    Lista<T> postOrder();

    Lista<T> nivel();



}
