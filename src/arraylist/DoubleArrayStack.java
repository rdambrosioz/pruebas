package arraylist;
import exceptions.EmptyStack;
import exceptions.StackOverflow;


public class DoubleArrayStack <T>{



    private int pos1 = 0;
    private int pos2 = 0;
    private int size;
    private T[] array;

    public DoubleArrayStack ( int tam){
        size = tam;
        array = (T[]) new Object[tam];

    }


    public void pop1() throws EmptyStack {
        int posicion = getPos1();
        if (posicion == 0){
            throw new EmptyStack();
        } else{
            array[posicion-1] = null;
            pos1--;
        }
    }


    public Object top1() throws EmptyStack {

        int posicion = getPos1();
        if (posicion == 0){
            throw new EmptyStack();
        }

        return array[posicion-1];
    }


    public void push1(Object element) throws StackOverflow {


        if (pos1+pos2 == size){
            throw new StackOverflow();
        } else{
            array[pos1] = (T) element;
            pos1++;
        }



    }

    public boolean isEmpty1() {
        return pos1 == 0;
    }

    public void makeEmpty1() {
        for(int i = 0; i<pos1; i++){
            array[i] = null;
        }
        pos1 = 0;

    }



    public void pop2() throws EmptyStack {
        int posicion = getPos2();
        if (pos2 == 0){
            throw new EmptyStack();
        } else{
            array[posicion+1] = null;
            pos2--;
        }
    }


    public Object top2() throws EmptyStack {

        int posicion = getPos2();
        if (pos2 == 0){
            throw new EmptyStack();
        }

        return array[posicion+1];
    }


    public void push2(Object element) throws StackOverflow {



        if (pos2+pos1 == size-2){
            throw new StackOverflow();
        } else{
            array[getPos2()] = (T) element;
            pos2++;
        }



    }

    public boolean isEmpty2() {
        return pos2 == 0;
    }

    public void makeEmpty2() {
        for(int i = getPos2()+1; i<size; i++){
            array[i] = null;
        }
        pos2 = 0;

    }






    private int getPos1() {
        return pos1;
    }

    private int getPos2() {
        return size-pos2-1;
    }




    public void visualize(String str){
        System.out.println("Stack 1" );
        for (int i = 0; i < pos1; i++){
            System.out.print(array[i] + str);
        }

        System.out.println("\nStack 2");
        for (int i = getPos2()+1; i < size; i++){
            System.out.print(array[i] + str);
        }


    }


}
