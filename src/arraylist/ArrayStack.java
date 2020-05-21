package arraylist;

import exceptions.EmptyStack;
import interfaces.Stack;

import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {


    private int pos = 0;
    private int size;
    private T[] array;

    public ArrayStack ( int tam){


        size = tam;
        array = (T[]) new Object[tam];

    }






    @Override
    public T pop() throws EmptyStack {
        T devolver = null;
        if (array[0] == null){
            throw new EmptyStack();
        } else{
            devolver = array[pos-1];
            array[pos-1] = null;
            pos--;
        }
        return devolver;
    }

    @Override
    public T top() throws EmptyStack {

        if (array[0] == null){
            throw new EmptyStack();
        }

        return array[pos-1];
    }

    @Override
    public void push(T element) {

        if (pos < size-1){
            array[pos] = element;
            pos++;
        }
    }

    @Override
    public boolean isEmpty() {
        return array[0]==null;
    }

    @Override
    public void makeEmpty() {
        for(int i = 0; i<pos; i++){
            array[i] = null;
        }
        pos = 0;

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
