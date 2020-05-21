package doublelinkedlist;

public class NodoDoble<T> {

    private T valor;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;


    public NodoDoble(T valor, NodoDoble anterior) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = anterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
