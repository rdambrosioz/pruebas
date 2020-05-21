package exceptions;

public class EmptyStack extends Exception {

    @Override
    public String toString(){
        return "La pila esta vacia";
    }
}
