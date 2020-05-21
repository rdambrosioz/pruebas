package aplicaciones;

import java.util.TimerTask;

public class TimerSupermercado extends TimerTask {

    private ColasSupermercado supermercado;

    public TimerSupermercado(ColasSupermercado supermercado) {
        this.supermercado = supermercado;
    }

    @Override
    public void run() {
        this.supermercado.actualizarColas();
        this.supermercado.imprimirColas();
    }
}
