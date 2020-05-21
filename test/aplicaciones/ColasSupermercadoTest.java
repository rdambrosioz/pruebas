package aplicaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColasSupermercadoTest {


    @Test
    void agregarCliente() {
        ColasSupermercado supermercado = new ColasSupermercado(3);
        supermercado.agregarCliente(1);
        supermercado.agregarCliente(5);
        supermercado.agregarCliente(7);
        supermercado.agregarCliente(2);
        supermercado.agregarCliente(8);
        supermercado.agregarCliente(1);

        supermercado.imprimirColas();


    }


    @Test
    void nuevaEjecucion() {
        ColasSupermercado supermercado = new ColasSupermercado(3);
        supermercado.nuevaEjecucion();

    }
}