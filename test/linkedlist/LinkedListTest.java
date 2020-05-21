package linkedlist;

import interfaces.Lista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void getSize() {
        Lista lista = new LinkedList();

        lista.add(1);
        lista.add(2);
        lista.add(3);

        assertEquals(3,lista.getSize());

    }

    @Test
    void testIterator() {
        Lista<Integer> lista = new LinkedList<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);

        for (Integer temp : lista) {
            System.out.println(temp);
        }
    }
}