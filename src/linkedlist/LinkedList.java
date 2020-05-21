package linkedlist;
import exceptions.*;
import interfaces.*;

import java.util.Iterator;


public class LinkedList <T> implements Lista<T>, Stack<T>, Queue<T>, DoubleQueue<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;


    public LinkedList() {
        this.primero = null;
        this.ultimo = null;
        size = 0;
    }


    /**
     * AQUI SE ENCUENTRAN TODOS LOS DISTINTOS CODIGOS DE AGREGARA AUNA LISTA
     */
    @Override
    public void add(T valor, int posicion) throws ListOutOfIndex {

        if (posicion == 0){
            addFirst(valor);
        } else if (posicion == (size-1)){
            addLast(valor);
        }else{
            Nodo<T> anterior = devolverNodoPosicion(posicion-1);
            Nodo<T> temp = new Nodo<T>( valor);
            temp.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(temp);
            size++;
        }

    }       //Operacion de la interfaz. Agrega al final
    @Override
    public void add(T valor) {

        addLast(valor);
    }
    @Override
    public void addFirst(T valor){                     //Agrega al principio


        Nodo<T> nuevoNodo = new Nodo<T>(valor);

        if (primero == null){                   //Si la lista esta vacia, agrega solamente
            primero = nuevoNodo;
            size++;
            ultimo = nuevoNodo;
        }else{                                  //Lista no vacia, le agrega puntero al nuevo
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
            size++;
        }
    }
    public void addInOrder(T valor){
        if (size == 0){
            addFirst(valor);
        } else {
            if (((Comparable) primero.getValor()).compareTo(valor) >= 0 ){
                addFirst(valor);
            } else{
                Nodo<T> temp = primero.getSiguiente();
                Nodo<T> anterior = primero;
                boolean seAgrego = false;

                while(temp != null){

                    if(((Comparable)temp.getValor()).compareTo(valor) >= 0 ){
                        Nodo<T> nuevo = new Nodo<>(valor);
                        anterior.setSiguiente(nuevo);
                        nuevo.setSiguiente(temp);
                        seAgrego = true;
                        break;
                    } else {
                        anterior = temp;
                        temp = temp.getSiguiente();
                    }
                }

                if (seAgrego){
                    size++;
                } else{
                    addLast(valor);
                }
            }
        }
    }
    private void addLast(T valor){                         //Agrega al final



        if (primero == null){                   //Si la lista es vacia agrega al principio
            addFirst(valor);
        } else{
            Nodo<T> nodoNuevo = new Nodo<T>(valor);   //Si la lista no es vacia, solamente agrega seteando el siguiente del
            ultimo.setSiguiente(nodoNuevo);     //ultimo y renueva el ultimo
            ultimo = nodoNuevo;
            size++;
        }
    }

    /**
     * AQUI SE ENCUENTRAN TODOS LOS DISTINTOS CODIGOS DE REMOVER UN ELEMENTO DE UNA LISTA LISTA
     */
    @Override
    public T remove(int posicion) throws ListOutOfIndex {

        T retorno = null;
        if (posicion == size-1){                                //En este caso se elimina el ultimo indirectamente
            retorno =  removeLast();
        } else if (posicion == 0){
            retorno = primero.getValor();
            Nodo<T> nuevoPri = primero.getSiguiente();
            primero.setSiguiente(null);
            primero = nuevoPri;
            size--;
        } else{
            Nodo<T> temp = devolverNodoPosicion(posicion - 1);     //Busca el anterior del que quiero elminar
            Nodo<T> eliminar = temp.getSiguiente();                //Encuentro el que quiero eliminar
            retorno = temp.getValor();
            temp.setSiguiente(eliminar.getSiguiente());         //Le doy al nodo anterior el siguiente del que voy  eliminar
            eliminar.setSiguiente(null);
            size--;
        }
        return retorno;
    }

    @Override
    public T removeLast() {
        T devolver = ultimo.getValor();

        if (size == 0){                                    //Si el ultimo es nulo, no hace nada
        } else if (size == 1) {                                 //Si hay 1 solo elemento lo elimina a ese
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
            temp.setSiguiente(null);
            ultimo = temp;
            size--;
        }
        return devolver;

    }

    @Override
    public T remove(T valor) throws ElementoNoExiste {
        Nodo<T> anterior = null;
        Nodo<T> temp = primero;
        for(int i = 0; i < size; i++){
            if (temp.equals(valor)){
                if(temp.equals(primero)){
                    primero = temp.getSiguiente();
                } else{
                    anterior.setSiguiente(temp.getSiguiente());
                }
                size--;
                return temp.getValor();
            }
        }

        return null;
    }

    /**
     * AQUI SE ENCUENTRAN TODOS LOS DISTINTOS CODIGOS QUE PERMITEN OBETNER UN ELEMENTO DE LA LISTA
     * O CHECKEAR QUE UN ELEMENTO ESTE EN LA LISTA
     */
    @Override
    public T get(int posicion) throws ListOutOfIndex {         //Devuelve el valor
        return devolverNodoPosicion(posicion).getValor();
    }

    @Override
    public T get(T valueToSearch) {
        T devolver = null;
        if (valueToSearch instanceof Comparable){
            Nodo<T> temp = this.primero;
            while (temp!=null){
                if (valueToSearch.equals(temp.getValor())){
                    devolver = temp.getValor();
                    break;
                }
            }
        }
        return devolver;
    }
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
    @Override
    public boolean isInTheList (T valor){          //Devuelve si el valor esta en la lista

        boolean esta = false;


        Nodo<T> temp = primero;

        while (temp != null){                           //Va recorriendo y comparando el valor con el de cada nodo. Si lo encuentra corta
            if (temp.getValor().equals(valor)){
                esta = true;
                break;
            }else {
                temp = temp.getSiguiente();
            }
        }

        return esta;
    }
    @Override
    public boolean contains(T valor) {
        boolean contiene = false;
        if (valor instanceof Comparable){
            Nodo<T> temp = this.primero;
            while (temp!=null){
                if (valor.equals(temp.getValor())){
                    contiene = true;
                    break;
                }
            }
        }
        return contiene;
    }

    /**
     * OPERACIONES VARIAS DE LISTA
     */
    @Override
    public Iterator<T> iterator() {

        return new LinkedListIterator<T>(primero);
    }
    public int getSize() {
        return size;
    }
    @Override
    public String toString() {
        return visualize(" ");
    }
    @Override
    public void visualize (Lista orden){

        Nodo<T> temp = primero;
        int contador = 0;

        while (temp != null){
            T valor = null;
            try {
                valor = (T)orden.get(0);

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

    @Override
    public String visualize(String separacion){

        Nodo<T> temp = primero;
        String str = "";

        while(temp != null){
            str = str + (temp.getValor() + separacion);
            temp = temp.getSiguiente();
        }
        str = str + "\n";
        return str;
    }


    /**
     * OPERACIONES PARA OPEREARO CON DISTINTAS LISTAS
     */
    @Override
    public void interchange (T valor, int direccion) throws EmptyList {


        if (size == 0){
            throw new EmptyList();
        }
        else if (direccion == 1) {
            Nodo<T> anterior = null;
            Nodo<T> temp = primero;
            boolean existe = false;
            while (temp != null) {
                if (temp.getValor().equals(valor)){
                    existe = true;
                    break;
                }
                anterior = temp;
                temp = temp.getSiguiente();
            }
            if (existe && (temp != ultimo)) {
                if (anterior == null) {
                    Nodo<T> siguiente = temp.getSiguiente();
                    temp.setSiguiente(siguiente.getSiguiente());
                    siguiente.setSiguiente(temp);
                    primero = siguiente;
                } else {
                    Nodo<T> siguiente = temp.getSiguiente();
                    anterior.setSiguiente(siguiente);
                    temp.setSiguiente(siguiente.getSiguiente());
                    siguiente.setSiguiente(temp);
                }
                if (temp.getSiguiente() == null) {
                    ultimo = temp;
                }
            }
        } else if (direccion == -1){
            Nodo<T> anterior1 = null;
            Nodo<T> anterior2 = null;
            Nodo<T> temp = primero;
            boolean existe = false;
            while (temp != null) {
                if (temp.getValor().equals(valor)){
                    existe = true;
                    break;
                }
                anterior2 = anterior1;
                anterior1 = temp;
                temp = temp.getSiguiente();
            }
            if (existe && (temp!=primero)){
                if (anterior2 == null){
                    anterior1.setSiguiente(temp.getSiguiente());
                    temp.setSiguiente(anterior1);
                    primero = temp;
                } else{
                    anterior2.setSiguiente(temp);
                    anterior1.setSiguiente(temp.getSiguiente());
                    temp.setSiguiente(anterior1);
                }
                if (anterior1.getSiguiente() == null){
                    ultimo = anterior1;
                }
            }
        }
    }
    @Override
    public Lista<T> append (Lista lista){

        Lista<T> retorno = new LinkedList<>();
        Nodo<T> temp = primero;

        while(temp != null){
            T valor = temp.getValor();
            if(lista.isInTheList(valor) && !(retorno.isInTheList(valor))){
                retorno.add(valor);
            }
            temp = temp.getSiguiente();
        }
        return retorno;
    }
    @Override
    public Lista<T> symmetricDifference (Lista lista){

        Lista<T> retorno = new LinkedList<>();

        Nodo<T> temp = primero;

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
                valor = (T) lista.get(i);
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
            if (!(this.isInTheList(valor) || retorno.isInTheList((T) valor))){
                retorno.add(valor);
            }
        }
        return retorno;
    }




    /**
     * AQUI SE ENCUENTRA EL CODIGO Y OPERACIONES DE LA IMPLEMENTACION DEL STACK
     */
    @Override
    public T pop() throws EmptyStack {


        return removeLast();
    }
    @Override
    public T top() throws EmptyStack {

        if (size == 0){
            throw new EmptyStack();
        } else {
            return ultimo.getValor();
        }
    }
    @Override
    public void push(T element) {

        addLast(element);

    }



    /**
     * AQUI SE ENCUENTRA EL CODIGO Y OPERACIONES DE LA IMPLEMENTACION DE UNA QUEUE
     */
    @Override
    public void enqueue(T element) {
        addLast(element);
    }
    @Override
    public void enqueueWithPriority(T element) {
        addInOrder(element);
    }
    @Override
    public T dequeue() throws EmptyQueue {
        Nodo<T> primero = this.primero;

        if(size == 0){
            throw  new EmptyQueue();
        } else{
            try {
                remove(0);
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
        }

        return primero.getValor();
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void makeEmpty() {

        Nodo<T> temp = this.primero;
        Nodo<T> siguiente =temp.getSiguiente();


        while(siguiente != null){
            temp.setSiguiente(null);
            temp = siguiente;
            siguiente = temp.getSiguiente();
        }

        primero = null;
        ultimo = null;
        size = 0;
    }


    /**
     * AQUI SE ENCUENTRA EL CODIGO Y OPERACIONES DE LA IMPLEMENTACION DE UNA DOBLEQUEUE
     */
    @Override
    public void enqueueLeft(T element) {
        addFirst(element);
    }
    @Override
    public T dequeueLeft() throws EmptyQueue {

        return dequeue();
    }
    @Override
    public void enqueueRight(T element) {

        enqueue(element);
    }

    @Override
    public T dequeueRight() throws EmptyQueue {


        if(size == 0){
            throw  new EmptyQueue();
        } else{
            return removeLast();
        }

    }


}





