package aplicaciones;

import exceptions.EmptyQueue;
import exceptions.ListOutOfIndex;
import interfaces.Queue;
import linkedlist.LinkedList;

import java.util.Scanner;
import java.util.Timer;


public class ColasSupermercado {


    private int cajas;
    private  Queue<Cliente>[] colas;
    private TimerSupermercado timerSupermercado;


    public ColasSupermercado(int cajas){
        this.cajas = cajas;
        colas = new LinkedList[cajas];
        for (int i = 0; i < cajas; i++){
            colas[i] = new LinkedList<>();
        }
        timerSupermercado = new TimerSupermercado(this);
    }

    private int[] calcularTiempoCola(){
        int[] tiempos = new int[cajas];


        for (int i = 0; i < cajas; i++){

            for (int j = 0; j < colas[i].getSize(); j++){
                try {
                    tiempos[i] = tiempos[i] + (colas[i].get(j).getCantidadProductos() * 5);
                } catch (ListOutOfIndex listOutOfIndex) {
                    listOutOfIndex.printStackTrace();
                }
            }
        }
        return tiempos;
    }


    private int elegirMejorCola(){

        int[] tiempo = calcularTiempoCola();

        int minInd = 0;
        for (int i = 0; i < cajas; i++){
            if (tiempo[i] < tiempo[minInd]){
                minInd = i;
            }
        }
        return minInd;
    }


    public boolean agregarCliente (int cantidadProductos){
        Cliente nuevo = new Cliente(cantidadProductos);
        int mejorCola = elegirMejorCola();
        synchronized (colas[mejorCola]){
            colas[mejorCola].enqueue(nuevo);
        }
        return true;
    }


    public void actualizarColas(){

        for (int i = 0; i < cajas; i++){
            int eliminar = 6;
            synchronized (colas[i]){
                Queue<Cliente> colaAct = colas[i];
                while(eliminar > 0) {
                    if (colaAct.getSize() == 0) {
                        break;
                    }
                    Cliente temp = null;
                    try {
                        temp = colaAct.get(0);
                        eliminar = temp.eliminarProductos(eliminar);
                        if (temp.getCantidadProductos() == 0) {
                            colaAct.dequeue();
                        }
                    } catch (ListOutOfIndex | EmptyQueue listOutOfIndex) {
                        listOutOfIndex.printStackTrace();
                    }
                }
            }

        }

    }


    public void imprimirColas(){

        for (int i = 0; i < cajas; i++){
            System.out.println("Cola " + Integer.toString(i+1) + ":");
            for (int j = 0; j < colas[i].getSize(); j++){
                try {
                    System.out.print(colas[i].get(j) + "\t");
                } catch (ListOutOfIndex listOutOfIndex) {
                    listOutOfIndex.printStackTrace();
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }


    public void nuevaEjecucion(){

        boolean ejecutar = true;

        Timer timer = new Timer();
        timer.schedule(timerSupermercado, 1000,30000);



//        while(ejecutar){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Ingresar cliente: add");
//            System.out.println("Imprimir colas: print");
//            System.out.println("Terminar programa: exit");
//            String ingreso = scanner.nextLine();
//
//            if (ingreso.equals("exit")){
//                ejecutar = false;
//                timer.cancel();
//            } else if (ingreso.equals("add")){
//                System.out.println("Introduzca la cantidad de productos");
//                try {
//                    Integer productos = Integer.parseInt(scanner.nextLine());
//                    agregarCliente(productos);
//                } catch (Exception e){
//                    System.out.println("El valor introducido es incorrecto");
//                }
//            } else if (ingreso.equals("print")){
//                imprimirColas();
//            }
//
//        }

        for (int i = 0; i < 100; i++){
            int cantidadProductos = 1 + (int)(Math.random() * 20);
            agregarCliente(cantidadProductos);
            System.out.println("Tenemos un nuevo cliente!");
            imprimirColas();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        timer.cancel();


    }

}
