package linkedlist;

import exceptions.EmptyQueue;
import exceptions.ListOutOfIndex;
import interfaces.Lista;
import interfaces.PriorityQueue;

import java.util.Iterator;

public class PriorityQueueLinkedList<T> implements PriorityQueue<T> {

    Lista<Object[]> queue = new LinkedList<>();

    public PriorityQueueLinkedList() {

    }

    @Override
    public void enqueueWithPriority(T element, int prioridad) {


        Object[] valor = new Object[2];
        valor[0] = element;
        valor[1] = prioridad;

        boolean agrego = false;

        int size = queue.getSize();
        for (int i = 0; i < size; i++){
            Object[] prioridadtemp = null;
            try{
                prioridadtemp = queue.get(i);
                if (prioridad > (int) prioridadtemp[1]) {
                    queue.add(valor, i);
                    agrego = true;
                    break;
                }
            }catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }

        }

        if (!agrego){
            enqueue(element);
        }

    }

    @Override
    public void enqueue(Object element) {

        Object[] valor = {(T)element, 0};
        queue.add(valor);
    }

    @Override
    public void enqueueWithPriority(T element) {
        enqueueWithPriority(element, (int) element);
    }

    @Override
    public T dequeue() throws EmptyQueue {
        T retorno = null;

        if (queue.getSize() == 0){
            throw new EmptyQueue();
        }
        try {
            retorno = (T) queue.get(0);
            queue.remove(0);
        } catch (ListOutOfIndex listOutOfIndex) {
            listOutOfIndex.printStackTrace();
        }


        return retorno;
    }

    @Override
    public boolean isEmpty() {
        return queue.getSize() == 0;
    }

    @Override
    public T get(int posicion) throws ListOutOfIndex {

        return (T) queue.get(posicion)[0];
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public String visualize(String str) {

        String s = "";
        int size = queue.getSize();

        for (int i = 0; i < size; i++){
            try {
                s = s + (queue.get(i)[0] + str);
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
        }
        return s + "\n";
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
