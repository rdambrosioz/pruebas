package linkedcircularlist;

import exceptions.ElementoNoExiste;
import exceptions.EmptyList;
import exceptions.ListOutOfIndex;
import interfaces.Lista;
import linkedlist.LinkedListIterator;
import linkedlist.Nodo;

import java.util.Iterator;

public class LinkedCircularList<T> implements Lista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public LinkedCircularList() {
        this.primero = null;
        this.ultimo = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }


    @Override
    public void add(T valor, int posicion) throws ListOutOfIndex {


        if (posicion == 0){
            addFirst(valor);
        } else if (posicion == (size-1)){
            add(valor);
        }else{
            Nodo<T> anterior = devolverNodoPosicion(posicion-1);
            Nodo<T> temp = new Nodo<>(valor);
            temp.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(temp);
            size++;
        }

    }


    public void add(T valor) {


        if (primero == null){                   //Si la lista es vacia agrega al principio
            addFirst(valor);
        } else{
            Nodo<T> nodoNuevo = new Nodo<>(valor);   //Si la lista no es vacia, solamente agrega seteando el siguiente del
            ultimo.setSiguiente(nodoNuevo);     //ultimo y renueva el ultimo
            ultimo = nodoNuevo;
            ultimo.setSiguiente(primero);
            size++;
        }
    }

    public void addFirst(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (primero == null){                   //Si la lista esta vacia, agrega solamente
            primero = nuevoNodo;
            size++;
            ultimo = nuevoNodo;
        }else{                                  //Lista no vacia, le agrega puntero al nuevo
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
            ultimo.setSiguiente(primero);
            size++;
        }
    }

    @Override
    public boolean contains(T valor) {
        //FIXME completar esto

        return false;
    }

    public T remove(int posicion) throws ListOutOfIndex {
        T retorno = null;
        if (posicion == size-1){                                //En este caso se elimina el ultimo indirectamente
            retorno = removeLast();
        } else if (posicion == 0){
            retorno = primero.getValor();
            Nodo<T> segundo = primero.getSiguiente();
            ultimo.setSiguiente(segundo);
            primero = segundo;
            size--;
        } else {
            Nodo<T> temp = devolverNodoPosicion(posicion - 1);     //Busca el anterior del que quiero elminar
            Nodo<T> eliminar = temp.getSiguiente();                //Encuentro el que quiero eliminar
            retorno = eliminar.getValor();
            temp.setSiguiente(eliminar.getSiguiente());         //Le doy al nodo anterior el siguiente del que voy  eliminar
            eliminar.setSiguiente(null);
            size--;
        }
        return retorno;

    }

    public T removeLast() {
        T retorno = null;
        if (size == 0){                                    //Si el ultimo es nulo, no hace nada
        } else if (size == 1) {                                 //Si hay 1 solo elemento lo elimina a ese
            retorno = primero.getValor();
            primero = null;
            ultimo = null;
            size--;
        } else{
            Nodo<T> temp = null;
            try {
                temp = devolverNodoPosicion(size-2);            //Va al penultimo nodo y elimina, sabiendo que no hay forma que de error
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
            retorno = temp.getSiguiente().getValor();
            temp.getSiguiente().setSiguiente(null);
            temp.setSiguiente(primero);
            ultimo = temp;
            size--;
        }
        return retorno;

    }

    @Override
    public T remove(T valor) throws ElementoNoExiste {
        return null;
    }


//FIXME






    private  Nodo<T> devolverNodoPosicion(int posicion) throws ListOutOfIndex{     //Devuelve el nodo en una posicion especifica

        Nodo<T> temp = null;

        if (posicion >= size || posicion < 0){          //Ceckea que exista la pos
            throw  new ListOutOfIndex(size);
        }else if (posicion == (size-1)){                //Checkea si es el ultimo
            temp = ultimo;
        }  else{                                        //Recorre la cantidad de veces necesarias y devuelve el ultimo
            temp = primero;
            for (int i = 0; i < posicion ; i++){
                temp = temp.getSiguiente();
            }
        }

        return temp;
    }

    public T get(int posicion) throws ListOutOfIndex {
        return devolverNodoPosicion(posicion).getValor();
    }

    @Override
    public T get(T valueToSearch) {
        //FIXME arreglar despues

        return null;
    }


    public boolean isInTheList(T valor) {
        boolean esta = false;

        Nodo<T> temp = primero;

        do {                           //Va recorriendo y comparando el valor con el de cada nodo. Si lo encuentra corta
            if (temp.getValor().equals(valor)){
                esta = true;
                break;
            }else {
                temp = temp.getSiguiente();
            }
        } while (temp != primero);

        return esta;
    }

    @Override
    public void visualize(Lista orden) {

    }

    @Override
    public String visualize(String str) {

        Nodo<T> temp = primero;
        if (primero != null){
            do{
                System.out.print(temp.getValor() + str);
                temp = temp.getSiguiente();
            }while(temp != primero);

                    System.out.println("");
            }
        return null;
    }

    @Override
    public void interchange(T valor, int direccion) {

    }

    @Override
    public Lista<T> append(Lista lista) {
        return null;
    }

    @Override
    public Lista<T> symmetricDifference(Lista<T> lista) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(primero);
    }
}
