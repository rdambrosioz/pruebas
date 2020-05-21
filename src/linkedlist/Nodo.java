package linkedlist;

public class Nodo<T> {

    private T valor;
    private Nodo siguiente;


    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    
//    public int compareTo(Nodo o) {
//        int devolver = 0;
//        if (compare(this.valor ,o.getValor())) {
//
//        }
//        return 0;
//    }
}
