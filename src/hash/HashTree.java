package hash;

import interfaces.BinarySearchTree;
import interfaces.Hash;
import interfaces.Lista;
import linkedlist.LinkedList;

public class HashTree<K extends Comparable<K>,T> implements Hash<K,T> {

    private BinarySearchTree<K,T>[] entryArray;
    private int size;

    public HashTree(BinarySearchTree<K,T>[] entryArray) {
        this.entryArray = entryArray;
        this.size = 0;
    }

    @Override
    public void put(K key, T value) {
        int position = key.hashCode() % entryArray.length;

        BinarySearchTree<K,T> treeForPosition = entryArray[position];

        if (treeForPosition == null){
            treeForPosition = new tree.BinarySearchTree<>();
        }


        if (! treeForPosition.contains(key)) {
            treeForPosition.insert(key, value);
            this.size++;
        }

    }

    @Override
    public T remove(K key) {
        int position = key.hashCode() % entryArray.length;
        BinarySearchTree<K,T> treeForPosition = entryArray[position];
        T valueToReturn = null;
        if (treeForPosition.contains(key)){
            treeForPosition.delete(key);
        }
        return null;
    }

    @Override
    public T get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
