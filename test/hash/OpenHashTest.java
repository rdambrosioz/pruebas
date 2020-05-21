package hash;

import aplicaciones.Cliente;
import interfaces.Hash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenHashTest {

    private Hash<Long, Cliente> myHash;

    @BeforeEach
    void setUp(){
        myHash = new OpenHash<>(10);
    }

    @Test
    void put() {
        Cliente cl1 = new Cliente(50047630l, 1866546l, "Juan");
        Cliente cl2 = new Cliente(50047631l, 1866547l, "Pedro");
        Cliente cl3 = new Cliente(50047632l, 1866549l, "Jose");

        myHash.put(cl1.getCedula(), cl1);

    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }
}