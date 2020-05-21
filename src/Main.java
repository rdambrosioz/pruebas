//import linkedcircularlist.LinkedCircularList;
import aplicaciones.ColasSupermercado;
import aplicaciones.EquilibrioSimbolos;
import aplicaciones.TimerSupermercado;
import arraylist.ArrayStack;
import arraylist.DoubleArrayStack;
import doublelinkedlist.DoubleLinkedList;
import exceptions.EmptyQueue;
import exceptions.ListOutOfIndex;
import exceptions.StackOverflow;
import interfaces.*;
import linkedcircularlist.LinkedCircularList;
import linkedlist.LinkedList;
import linkedlist.PriorityQueueLinkedList;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
//        LinkedList lista = new LinkedList();
//
//        ArrayList vec = new ArrayList();
//        System.out.println(vec.size());
//        vec.add(1);
//        vec.add(1);
//        vec.add(3);
//
//
//        lista.add(5);
//        lista.add(1);
//        lista.addFirst(3);
//        lista.addFirst(55);
//        try {
//
//            lista.add(7,0);
//            lista.add(8,1);
//            lista.add(6,0);
//        } catch (ListOutOfIndex listOutOfIndex) {
//            listOutOfIndex.printStackTrace();
//        }
//
//        lista.add(9);
//
//
//        System.out.println("tamano " + lista.getSize());
//        int valor1 = 0;
//        for (int i =0; i<lista.getSize();i++){
//            try {
//                valor1 = (int) lista.get(i);
//            } catch (ListOutOfIndex listOutOfIndex) {
//                listOutOfIndex.printStackTrace();
//            }
//            System.out.println(valor1);
//        }
//
//
//        lista.removeLast();
//
//        System.out.println(lista.getSize());
//        int valor2 = 0;
//        try {
//            lista.remove(5);
//            valor2 = (int) lista.get(8);
//            System.out.println(lista.getSize());
//        } catch (ListOutOfIndex listOutOfIndex) {
//            System.out.println(listOutOfIndex);
//        }
//        System.out.println(valor2);
//
//        if (lista.isInTheList(7)){
//            System.out.println("si");
//        }


//        Lista josefo = new LinkedList();
//        josefo.add(1);
//        josefo.add(2);
//        josefo.add(3);
//        josefo.add(4);
//        josefo.add(5);
//        josefo.add(6);
//        josefo.add(7);
//        josefo.add(8);
//        josefo.add(9);
//
//        Lista juego1 = Josefo.juegoNuevo(3, josefo);
//
//        for (int i = 0; i < juego1.getSize(); i++) {
//            Object valor = null;
//            try {
//                valor = juego1.get(i);
//            } catch (ListOutOfIndex listOutOfIndex) {
//                listOutOfIndex.printStackTrace();
//            }
//            if (valor == null) {
//                continue;
//            } else {
//                System.out.println(valor);
//            }
//
//
//       }


//        DoubleLinkedList lista2 = new DoubleLinkedList();
//        lista2.add(13);
//        lista2.add(12);
//        lista2.add(12);
//        lista2.add(12);
//        lista2.add(12);
//        lista2.add(1);
//        try {
//            lista2.add(5, 2);
//        } catch (ListOutOfIndex listOutOfIndex) {
//            listOutOfIndex.printStackTrace();
//        }
//        lista2.add(22);
//
//        lista2.add(89);
//
//
//
//        lista2.interchange(1, -1);
//        lista2.add(21);
//        lista2.addFirst(99);
//
//
//        try {
//            lista.remove(1);
//        } catch (ListOutOfIndex listOutOfIndex) {
//            listOutOfIndex.printStackTrace();
//        }
//
//
//
//        LinkedList orden = new LinkedList();
//        orden.add(0);
//        orden.add(1);
//        orden.add(2);
//        orden.add(3);
//        orden.add(4);
//        orden.add(5);
//        orden.add(6);
//        orden.add(7);
//        orden.add(8);
//        orden.add(9);
//        orden.add(10);
//        orden.add(11);
//
//
//
//
//        lista2.visualize("\t");
//        orden.visualize("\t");
//
//        Lista listaAppend = lista2.symmetricDifference(orden);
//
//
//        listaAppend.visualize("\t");
//
//
//
//
//        String str = "7{a[( 9)11]2}]";
//
//        EquilibrioSimbolos.EquilibrioSimbolos(str);

//
//        Lista lista2 = new LinkedCircularList();
//
//        lista2.add(1);
//        lista2.add(2);
//        lista2.add(3);
//        lista2.add(4);
//        lista2.add(5);
//        lista2.add(6);
//        lista2.addFirst(0);
//        try {
//            lista2.add(11, 2);
//        } catch (ListOutOfIndex listOutOfIndex) {
//            listOutOfIndex.printStackTrace();
//        }
//        lista2.add(22);
//
//        lista2.add(89);
//
//        try {
//            lista2.remove(0);
//        } catch (ListOutOfIndex listOutOfIndex) {
//            listOutOfIndex.printStackTrace();
//        }
//
//        lista2.removeLast();
//
//
//
//
//        lista2.visualize(" ");



//        DoubleLinkedList lista = new DoubleLinkedList();
//
//        System.out.println(lista.getSize());
//        lista.addInOrder((Integer) 1);
//        lista.addInOrder((Integer) 1);
//
//        lista.addInOrder((Integer)2);
//        lista.addInOrder((Integer)2);
//        lista.addInOrder((Integer)3);
//        System.out.println(lista.getSize());
//        lista.addInOrder((Integer)5);
//        lista.addInOrder((Integer)6);
//        lista.addInOrder((Integer)0);
//        lista.addInOrder((Integer)4);
//
//        lista.addFirst(1111);
//        lista.add(99999);
//        try {
//            lista.add(2222,1);
//        } catch (ListOutOfIndex listOutOfIndex) {
//            listOutOfIndex.printStackTrace();
//        }
//
//        lista.addInOrder(8888);
//
//
//        lista.removeLast();
//
//        System.out.println(lista.getSize());
//        lista.visualize(" ");


//        DoubleArrayStack dstack = new DoubleArrayStack(10);
//
//        try {
//            dstack.push1(1);
//            dstack.push1(2);
//            dstack.push1(3);
//            dstack.pop1();
//            System.out.println(dstack.top1());
//            if (!dstack.isEmpty1()){
//                System.out.println("No Vacio");
//            }
//        } catch (StackOverflow stackOverflow) {
//            stackOverflow.printStackTrace();
//        }
//
//        try {
//            dstack.push2(1);
//            dstack.push2(2);
//            dstack.push2(3);
//            dstack.pop2();
//            System.out.println(dstack.top2());
//            if (dstack.isEmpty2()){
//                System.out.println("Vacio");
//            }
//        } catch (StackOverflow stackOverflow) {
//            stackOverflow.printStackTrace();
//        }
//
//        try {
//            dstack.push1(3);
//            dstack.push1(4);
//            dstack.push1(5);
//            dstack.push1(6);
//            dstack.push1(7);
//            dstack.push1(8);
//            dstack.pop1();
//            dstack.push1(7);
//            //dstack.push1(8);
//        } catch (StackOverflow stackOverflow) {
//            stackOverflow.printStackTrace();
//        }
//
//        dstack.visualize(" ");


        //Lista<Integer> lista = new LinkedList<>();


//        Queue fila = new LinkedList();
//
//        fila.enqueue(3);
//        fila.enqueue(4);
//        fila.enqueue(5);
//        fila.enqueue(6);
//
//
//        try {
//            fila.dequeue();
//        } catch (EmptyQueue emptyQueue) {
//            emptyQueue.printStackTrace();
//        }
//
//
//        if(!fila.isEmpty()){
//            System.out.println(fila.getSize());
//        }
//        fila.visualize(" ");


//        PriorityQueue fila = new PriorityQueueLinkedList();
//
//        fila.enqueue(3);
//        fila.enqueue(4);
//        fila.enqueue(5);
//        fila.enqueue(6);
//        fila.visualize(" ");
//
//        try {
//            fila.dequeue();
//        } catch (EmptyQueue emptyQueue) {
//            emptyQueue.printStackTrace();
//        }
//        fila.visualize(" ");
//
//        fila.enqueueWithPriority(7,2);
//        fila.enqueueWithPriority(6,2);
//        fila.enqueueWithPriority(8,1);
//        fila.enqueueWithPriority(9,3);
//
//        try {
//            fila.dequeue();
//        } catch (EmptyQueue emptyQueue) {
//            emptyQueue.printStackTrace();
//        }
//
//        fila.visualize(" ");

//
//        DoubleQueue fila = new LinkedList();
//
//        fila.enqueueLeft(1);
//        fila.enqueueLeft(2);
//        fila.enqueueRight(3);
//        fila.enqueueRight(4);
//        fila.visualize(" ");
//
//        try {
//            fila.dequeueRight();
//            fila.visualize(" ");
//            fila.dequeueLeft();
//            fila.visualize(" ");
//        } catch (EmptyQueue emptyQueue) {
//            emptyQueue.printStackTrace();
//        }


        ColasSupermercado supermercado = new ColasSupermercado(3);
        supermercado.agregarCliente(1);
        supermercado.agregarCliente(5);
        supermercado.agregarCliente(7);
        supermercado.agregarCliente(2);
        supermercado.agregarCliente(8);
        supermercado.agregarCliente(1);
        supermercado.agregarCliente(8);
        supermercado.agregarCliente(4);
        supermercado.agregarCliente(4);

//        supermercado.imprimirColas();
//
//        supermercado.actualizarColas();
//
//        supermercado.imprimirColas();
//
//        supermercado.actualizarColas();
//
//        supermercado.imprimirColas();



        supermercado.nuevaEjecucion();


    }
}

