package hash;

import exceptions.ElementoNoExiste;
import exceptions.ListOutOfIndex;
import interfaces.Hash;
import interfaces.Lista;
import linkedlist.LinkedList;

public class OpenHash<K,T> implements Hash<K,T> {

    private Lista<HashEntry<K,T>>[] entryArray;
    private int size;

    public OpenHash(int size) {
        this.entryArray = new Lista[size];
        this.size = 0;
    }

    @Override
    public void put(K key, T value) {
        int position = key.hashCode() % entryArray.length;

        Lista<HashEntry<K,T>> listForPosition = entryArray[position];

        if (listForPosition == null){
            listForPosition = new LinkedList<>();
        }

        HashEntry<K,T> hashEntry = new HashEntry<>(key, value);

        if (! listForPosition.contains(hashEntry)) {
            listForPosition.add(hashEntry);
            this.size++;
        }
    }

    @Override
    public T remove(K key) {

        T valueToReturn = null;
        int position = key.hashCode() % entryArray.length;
        Lista<HashEntry<K,T>> listForPosition = entryArray[position];

        if (listForPosition != null) {
            try {
                HashEntry<K,T> temp = new HashEntry<>(key, null);
                valueToReturn =  listForPosition.remove(temp).getValue();
            } catch (ElementoNoExiste elementoNoExiste) {
                elementoNoExiste.printStackTrace();
            }

        }

        return valueToReturn;
    }

    @Override
    public T get(K key) {
        T valueToReturn = null;
        int position = key.hashCode() % entryArray.length;
        Lista<HashEntry<K,T>> listForPosition = entryArray[position];

        if (listForPosition != null){
            for(HashEntry<K,T> temp : listForPosition) {
                if (temp.getKey().equals(key)) {
                    valueToReturn = temp.getValue();
                    break;
                }
            }
        }

        return valueToReturn;
    }

    @Override
    public int size() {
        return this.size;
    }




}
