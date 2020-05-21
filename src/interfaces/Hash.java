package interfaces;

/**
 * Implementacion de una estructura de hash
 * @param <K> Es la clave de cada elemento
 * @param <T>
 */
public interface Hash <K,T> {

    /**
     * Esta operacion permite agregar un valor de clave K y valor T al hash
     * @param key
     * @param value
     */
    void put(K key, T value);

    T remove(K key);

    T get(K key);

    int size();

}
