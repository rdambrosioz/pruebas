
import uy.edu.um.prog2.adt.list.MyList;
import uy.edu.um.prog2.adt.list.linkedlist.MyLinkedListImpl;

import java.util.List;

    public class Main {
        public static void main(String[] args){

            int option = 1;

            if (option == 0) {
                BookFileReaderToList reader = new BookFileReaderToList("books.csv");
                reader.readFileOpenCSV();
                List<Book> booksList = reader.getBookList();

                System.out.println(booksList.size());

                for (int i = 0; i < 5; i++) {
                    System.out.println(booksList.get(i));
                }
            } else if (option == 1){
                BusLineFileReaderToList reader = new BusLineFileReaderToList("lineas.csv");
                reader.readFile();
                List<BusLine> busList = reader.getBusLinesList();

                System.out.println(busList.size());

                for (int i = 0; i < 5; i++) {
                    System.out.println(busList.get(i));
                }
            } else if (option == 2){
                BusLineFileReaderToList reader = new BusLineFileReaderToList("lineas.csv");
                reader.readFileOpenCSV();
                List<BusLine> busList = reader.getBusLinesList();

                System.out.println(busList.size());

                for (int i = 0; i < 5; i++) {
                    System.out.println(busList.get(i));
                }
            }


            MyList<Integer> myList = new MyLinkedListImpl();

            myList.add((Integer) 2);
            myList.add((Integer) 3);

            System.out.println("VALOR DE LA LISTA: " + myList);

        }

    }

