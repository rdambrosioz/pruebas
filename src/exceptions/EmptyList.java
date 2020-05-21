package exceptions;

public class EmptyList extends Exception {

    @Override
    public String toString(){
        return "La lista esta vacia!";
    }
}
