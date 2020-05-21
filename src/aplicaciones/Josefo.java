package aplicaciones;
import exceptions.ListOutOfIndex;
import interfaces.Lista;
import linkedlist.LinkedList;

public class Josefo {

    public static Lista juegoNuevo (int m, Lista colIntegrantes) throws IllegalArgumentException{
        if (colIntegrantes.getSize() < m){
            throw new IllegalArgumentException();
        }

        Lista retorno = new LinkedList();

        int lugar = m;
        int tamano = colIntegrantes.getSize();

        while(tamano > 1){
            try {
                Object valor = colIntegrantes.get(lugar-1);
                while (valor == null){
                    lugar++;
                    valor = colIntegrantes.get(lugar-1);
                }
                retorno.add(valor);
                colIntegrantes.remove(lugar-1);
                colIntegrantes.add(null, lugar-1);
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
            lugar = lugar + m;
            if (lugar > colIntegrantes.getSize()){
                lugar = lugar - colIntegrantes.getSize();
            }
            tamano--;

        }

        for (int i = 0; i < colIntegrantes.getSize(); i++){
            try {
                if (colIntegrantes.get(i) == null){
                    continue;
                }else {
                    System.out.println("El ganador es " + colIntegrantes.get(i));
                }
            } catch (ListOutOfIndex listOutOfIndex) {
                listOutOfIndex.printStackTrace();
            }
        }

        return retorno;
    }

}
