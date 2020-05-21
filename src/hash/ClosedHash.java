package hash;

import exceptions.FullHash;
import interfaces.Hash;
import interfaces.Lista;

public class ClosedHash<K,T> implements Hash<K,T> {


    private HashEntry<K,T>[] hashArray;
    private int size;
    private boolean linear;

    public ClosedHash(int size, boolean linear){
        this.hashArray = (HashEntry<K, T>[]) new Object[size];
        this.linear = linear;
        this.size = 0;
    }




    @Override
    public void put(K key, T value) {
        int iterations = 0;
        int position = getPosition(key, iterations);

        while (!(hashArray[position] == null || hashArray[position].getKey().equals(key) || iterations  > hashArray.length)) {
            iterations++;
            position = getPosition(key,iterations);
        }

        if (iterations >= hashArray.length){
            throw new FullHash();
        } else{
            hashArray[position] = new HashEntry<>(key, value);
            this.size++;
        }

    }

    @Override
    public T remove(K key) {
        T valueToReturn = null;
        int iterations = 0;
        int position = getPosition(key, iterations);

        while (!(hashArray[position] == null || hashArray[position].getKey().equals(key) || iterations  > hashArray.length)) {
            iterations++;
            position = getPosition(key, iterations);
        }

        if (iterations <= hashArray.length && !(hashArray[position] == null)){
            valueToReturn = hashArray[position].getValue();
            hashArray[position].setDeleted(true);
        }
        return valueToReturn;
    }

    @Override
    public T get(K key) {
        T valueToReturn = null;
        int iterations = 0;
        int position = getPosition(key, iterations);
        while (!(hashArray[position] == null || hashArray[position].getKey().equals(key) || iterations  > hashArray.length)) {
            iterations++;
            position = getPosition(key, iterations);
        }

        if (iterations <= hashArray.length){
            valueToReturn = hashArray[position].getValue();
        }
        return valueToReturn;
    }

    @Override
    public int size() {
        return this.size;
    }


    private int getPosition(K key, int iterations){
        int position = 0;
        if (linear){
            position = (key.hashCode() % hashArray.length + iterations) % hashArray.length;
        }else{
            position = (key.hashCode() % hashArray.length + (iterations^2)) % hashArray.length;
        }
        return position;
    }
}
