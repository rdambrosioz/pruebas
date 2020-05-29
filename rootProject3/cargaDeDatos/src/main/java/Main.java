
import uy.edu.um.prog2.adt.list.MyList;
import uy.edu.um.prog2.adt.list.linkedlist.MyLinkedListImpl;

import java.util.List;

    public class Main {
        public static void main(String[] args){
            BusLineFileReaderToList reader = new BusLineFileReaderToList("lineas.csv");
            reader.readFile();
            List<BusLine> busLines = reader.getBusLinesList();

            for (int i = 0; i < 5; i++){
                System.out.println(busLines.get(i));
            }

            MyList<Integer> myList = new MyLinkedListImpl<>();

            myList.add(22);
            System.out.print(myList);
        }

    }

