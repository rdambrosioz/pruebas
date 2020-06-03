
import uy.edu.um.prog2.adt.exeptions.ListOutOfIndex;
import uy.edu.um.prog2.adt.list.MyList;
import uy.edu.um.prog2.adt.list.linkedlist.MyLinkedListImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

    public class Main {
        public static void main(String[] args) throws ListOutOfIndex {

            int option = 0 ;

            if (option == 0) {
                BookFileReaderToList reader = new BookFileReaderToList("books.csv");
                reader.readFileOpenCSV();
                MyList<Book> booksList = reader.getBookList();

                System.out.println(booksList.getSize());

                for (int i = 0; i < 5; i++) {
                    System.out.println(booksList.get(i));
                }

                reader.readFileParser();
                booksList = reader.getBookList();

                System.out.println(booksList.getSize());

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





//            String str = "1,\"Hola, como estas\"";
//
//
//            long start = System.nanoTime();
//            String[] lstr = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//            long timeWithSplitting = System.nanoTime() - start;
//
//
//
//
//            start = System.nanoTime();
//            String[] lstr2 = new String[2];
//            int pos = 0;
//            boolean inQuotes = false;
//            StringBuilder b = new StringBuilder();
//            for (char c : str.toCharArray()) {
//                switch (c) {
//                    case ',':
//                        if (inQuotes) {
//                            b.append(c);
//                        } else {
//                            lstr2[pos] = b.toString();
//                            pos++;
//                            b = new StringBuilder();
//                        }
//                        break;
//                    case '\"':
//                        inQuotes = !inQuotes;
//                    default:
//                        b.append(c);
//                        break;
//                }
//            }
//            lstr2[pos] = b.toString();
//
//            long timeWithParsing = System.nanoTime() - start;
//
//
//            start = System.nanoTime();
//            MyList<String> lstr3 = new MyLinkedListImpl<>();
//
//            boolean inQuotes2 = false;
//            StringBuilder b2 = new StringBuilder();
//            for (char c : str.toCharArray()) {
//                switch (c) {
//                    case ',':
//                        if (inQuotes2) {
//                            b2.append(c);
//                        } else {
//                            lstr3.add(b2.toString());
//                            b2 = new StringBuilder();
//                        }
//                        break;
//                    case '\"':
//                        inQuotes2 = !inQuotes2;
//                    default:
//                        b2.append(c);
//                        break;
//                }
//            }
//            lstr3.add(b2.toString());
//
//            long timeWithParsingMyList = System.nanoTime() - start;
//
//
//
//
//            start = System.nanoTime();
//            List<String> lstr4 = new LinkedList<>();
//
//            boolean inQuotes3 = false;
//            StringBuilder b3 = new StringBuilder();
//            for (char c : str.toCharArray()) {
//                switch (c) {
//                    case ',':
//                        if (inQuotes3) {
//                            b3.append(c);
//                        } else {
//                            lstr4.add(b2.toString());
//                            b3 = new StringBuilder();
//                        }
//                        break;
//                    case '\"':
//                        inQuotes3 = !inQuotes3;
//                    default:
//                        b3.append(c);
//                        break;
//                }
//            }
//            lstr4.add(b3.toString());
//
//            long timeWithParsingArrayList = System.nanoTime() - start;
//
//
//            System.out.println("Time 1 = " + timeWithSplitting );
//            System.out.println("Time 2 = " + timeWithParsing );
//            System.out.println("Time 3 = " + timeWithParsingMyList );
//            System.out.println("Time 4 = " + timeWithParsingArrayList );
//
//
//            for (String tmp : lstr)
//                System.out.println(tmp);
//
//            System.out.println("Next option");
//
//            for (String tmp : lstr2)
//                System.out.println(tmp);
//
//            System.out.println("Next option");
//
//            for (String tmp : lstr3)
//                System.out.println(tmp);

        }

    }

