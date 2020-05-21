package hash;

import java.util.Objects;

/**
 * @param <K> Clave del valor almacenado
 * @param <T> Valor almacenado
 */
public class HashEntry<K,T> {

    private K key;
    private boolean deleted;
    private T value;

    /**
     * Constructor normal que recibe todos los parametros del HashEntry
     *
     * @param key
     * @param value
     */
    public HashEntry(K key, T value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public K getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equalToReturn = false;
        if (obj instanceof HashEntry) {
            equalToReturn = this.equals(obj);
        }
        return equalToReturn;
    }
}



