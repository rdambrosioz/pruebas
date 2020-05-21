
package doublelinkedlist;
import exceptions.ElementoNoExiste;
import exceptions.EmptyList;
import exceptions.ListOutOfIndex;
import interfaces.Lista;
import linkedlist.LinkedListIterator;
import linkedlist.Nodo;

import java.util.Iterator;


public class DoubleLinkedList<T> implements Lista<T> {

    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int size;


    public DoubleLinkedList() {
        this.primero = null;
        this.ultimo = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    //ADD
    public void add(T valor, int posicion) throws ListOutOfIndex {
        if (posicion == 0){
            addFirst(valor);
        } else if (posicion == (size)){
            addLast(valor);
        }else{
            NodoDoble<T> anterior = devolverNodoPosicion(posicion-1);
            NodoDoble<T> temp = new NodoDoble<>(valor, anterior);
            NodoDoble<T> siguiente = anterior.getSiguiente();
            temp.setSiguiente(siguiente);
            temp.setAnterior(anterior);
            siguiente.setAnterior(temp);
            anterior.setSiguiente(temp);
            size++;
        }
    }

    public void add(T valor) {
        addLast(valor);
    }

    public void addFirst(T valor){

        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor, null);

        if (primero == null){
            primero = nuevoNodo;
            size++;
            ultimo = nuevoNodo;
        }else{
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
            size++;
        }
    }

    @Override
    public boolean contains(T valor) {
        boolean contiene = false;
        if (valor instanceof Comparable){
            NodoDoble<T> temp = this.primero;
            while (temp!=null){
                if (valor.equals(temp.getValor())){
                    contiene = true;
                    break;
                }
            }
        }
        return contiene;

    }

    private void addLast(T valor){

        if (primero == null){
            addFirst(valor);
        } else{
            NodoDoble<T> nodoNuevo = new NodoDoble<>(valor,ultimo);
            ultimo.setSiguiente(nodoNuevo);

            ultimo = nodoNuevo;
            size++;
        }
    }

    public void addInOrder(T valor){
        if (valor instanceof Comparable) {
            if (size == 0) {
                addFirst(valor);
            } else {
                if (((Comparable) primero.getValor()).compareTo(valor) >= 0) {
                    addFirst(valor);
                } else {
                    NodoDoble temp = primero.getSiguiente();
                    boolean seAgrego = false;

                    while (temp != null) {

                        if (((Comparable) temp.getValor()).compareTo(valor) >= 0) {
                            NodoDoble anterior = temp.getAnterior();
                            NodoDoble nuevo = new NodoDoble(valor, anterior);
                            anterior.setSiguiente(nuevo);
                            nuevo.setSiguiente(temp);
                            temp.setAnterior(nuevo);
                            seAgrego = true;
                            break;
                        } else {
                            temp = temp.getSiguiente();
                        }
                    }

                    if (seAgrego) {
                        size++;
                    } else {
                        addLast(valor);
                    }
                }
            }
        }
    }

    //REMOVE
    public T remove(int posicion) throws ListOutOfIndex {

        T retorno = null;
        if (posicion == size-1){
            retorno = removeLast();
        } else {
            NodoDoble<T> eliminar = devolverNodoPosicion(posicion);
            retorno = eliminar.getValor();

            eliminar.getAnterior().setSiguiente(eliminar.getSiguiente());
            eliminar.getSiguiente().setAnterior(eliminar.getAnterior());

            eliminar.setSiguiente(null);
            eliminar.setAnterior(null);
            size--;
        }
        return retorno;
    }

    public T removeLast() {

        if (ultimo == null){
        } else if (size == 1) {
            primero = null;
            ultimo = null;
            size--;
        } else{
            NodoDoble<T> penultimo = ultimo.getAnterior();
            penultimo.setSiguiente(null);
            ultimo.setAnterior(null);
            ultimo = penultimo;
            size--;
        }

        return ultimo.getValor();
    }

    @Override
    public T remove(T valor) throws ElementoNoExiste {
        return null;
    }


    public T get(int posicion) throws ListOutOfIndex {
        return devolverNodoPosicion(posicion).getValor();
    }

    @Override
    public T get(T valueToSearch) {
        T devolver = null;
        if (valueToSearch instanceof Comparable){
            NodoDoble<T> temp = this.primero;
            while (temp!=null){
                if (valueToSearch.equals(temp.getValor())){
                    devolver = temp.getValor();
                    break;
                }
            }
        }
        return devolver;
    }

    private  NodoDoble<T> devolverNodoPosicion(int posicion) throws ListOutOfIndex{
        NodoDoble<T> temp = null;

        if (posicion >= size || posicion < 0){
            throw  new ListOutOfIndex(size);
        }
        else if ((posicion) <= (int)(size/2)) {
            temp = primero;
            for (int i = 0; i < posicion; i++) {
                temp = temp.getSiguiente();
            }
        }
        else {
            temp = ultimo;
            for (int i = 0; i < (size - posicion); i++) {
                temp = temp.getAnterior();
            }
        }

        return temp;
    }

    public boolean isInTheList (T valor){

        boolean esta = false;

        NodoDoble<T> temp = primero;

        while (temp != null){
            if (temp.getValor().equals(valor)){
                esta = true;
                break;
            }else {
                temp = temp.getSiguiente();
            }
        }

        return esta;
    }

    public void visualize (Lista orden){

        NodoDoble<T> temp = primero;
        int contador = 0;
        while (temp != null){
            Object valor = null;
            try {
                valor = orden.get(0);
                valor = (int) (valor);
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
            if (valor.equals(contador)){
                try {
                    System.out.print(temp.getValor() + "\t" );
                    orden.remove(0);
                } catch (ListOutOfIndex listOutOfIndex) {
                    listOutOfIndex.printStackTrace();
                }
            }
            if (orden.getSize() == 0){
                break;
            }
            contador++;
            temp = temp.getSiguiente();
        }

    }

    public String visualize(String str){
        String string = "";
        NodoDoble<T> temp = primero;
        while (temp != null){
            string = string + (temp.getValor() + str);
            temp = temp.getSiguiente();
        }
        string = string + "\n";
        return string;
    }

    public void interchange (T valor, int direccion) throws EmptyList{

        if (size == 0){
            throw new EmptyList();
        }
        else{
            NodoDoble<T> temp = primero;
            boolean existe = false;
            while (temp != null){
                if (temp.getValor().equals(valor)){
                    existe = true;
                    break;
                }
                temp = temp.getSiguiente();
            }
            if (existe) {
                NodoDoble<T> anterior = temp.getAnterior();
                NodoDoble<T> siguiente = temp.getSiguiente();
                if ((direccion == 1) && (temp != ultimo)) {
                    NodoDoble<T> siguiente2 = siguiente.getSiguiente();
                    if (siguiente2 == null) {
                        temp.setSiguiente(null);
                        ultimo = temp;
                    } else {
                        siguiente2.setAnterior(temp);
                        temp.setSiguiente(siguiente2);
                    }
                    temp.setAnterior(siguiente);
                    siguiente.setSiguiente(temp);
                    if (temp == primero) {
                        siguiente.setAnterior(null);
                        primero = siguiente;
                    } else {
                        siguiente.setAnterior(anterior);
                        anterior.setSiguiente(siguiente);
                    }
                }
                else if ((direccion == -1) && (temp != primero)){
                    NodoDoble<T> anterior2 = anterior.getAnterior();
                    if (anterior2 == null){
                        temp.setAnterior(null);
                        primero = temp;
                    } else {
                        temp.setAnterior(anterior2);
                        anterior2.setSiguiente(temp);
                    }
                    if (temp == ultimo){
                        anterior.setSiguiente(null);
                        ultimo = anterior;
                    } else {
                        anterior.setSiguiente(siguiente);
                        siguiente.setAnterior(anterior);
                    }
                    temp.setSiguiente(anterior);
                    anterior.setAnterior(temp);

                }
            }
        }
    }

    public Lista<T> append (Lista<T> lista){

        Lista<T> retorno = new DoubleLinkedList();
        NodoDoble<T> temp = primero;

        while(temp!=null){
            T valor = temp.getValor();
            if(lista.isInTheList(valor) && !(retorno.isInTheList(valor))){
                retorno.add(valor);
            }
            temp = temp.getSiguiente();
        }
        return retorno;
    }

    public Lista<T> symmetricDifference (Lista<T> lista){

        Lista<T> retorno = new DoubleLinkedList<T>();

        NodoDoble<T> temp = primero;

        while(temp != null){
            T valor = temp.getValor();
            if (!(lista.isInTheList(valor) || retorno.isInTheList(valor))){
                retorno.add(valor);
            }
            temp = temp.getSiguiente();
        }

        for (int i = 0; i < lista.getSize(); i++){
            T valor = null;
            try {
                valor = lista.get(i);
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
            if (!(this.isInTheList(valor) || retorno.isInTheList(valor))){
                retorno.add(valor);
            }
        }
        return retorno;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator<T>(primero);
    }


    @Override
    public String toString() {
        return visualize(" ");
    }
}




