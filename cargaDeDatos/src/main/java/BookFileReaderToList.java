import com.opencsv.CSVReader;
import uy.edu.um.prog2.adt.list.MyList;
import uy.edu.um.prog2.adt.list.linkedlist.MyLinkedListImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class BookFileReaderToList {

    private MyList<Book> bookList;
    private String fileName;

    public BookFileReaderToList(String pathToFile) {
        this.fileName = pathToFile;
        bookList = new MyLinkedListImpl<>();
    }

    public MyList<Book> getBookList() {
        return bookList;
    }
//
//    public void readFile(){
//        List<Book> newBookList = new LinkedList<>();
//        Path pathToFile = Paths.get(fileName);
//        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
//            String line = br.readLine();
//            line = br.readLine();
//            while (line != null) {
//                String[] attributes = line.split(",");
//                if (attributes[3].equals("NaN")){
//                    attributes[3] = String.valueOf(0);
//                }
//                Book busLine = new Book(attributes);
//                newBookList.add(busLine); //
//                line = br.readLine();
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace(); }
//
//        this.bookList = newBookList;
//
//    }
//


    public void readFileOpenCSV() {

        long start = System.nanoTime();
        MyList<Book> newBookList = new MyLinkedListImpl<>();

        CSVReader reader = null;
        try
        {
            reader = new CSVReader(new FileReader("books.csv"));
            String [] nextLine;
            nextLine = reader.readNext();
            Book newBook = null;
            int publication_year = 0;
            while ((nextLine = reader.readNext()) != null){
                if (nextLine[3].equals("NaN")){
                    nextLine[3] = String.valueOf(publication_year);
                }
                String[] authors = nextLine[2].split(",");

                newBook = new Book(Long.parseLong(nextLine[0]), nextLine[1], authors, Integer.parseInt(nextLine[3]),nextLine[4],nextLine[5],nextLine[6],nextLine[7]);
                newBookList.add(newBook);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.bookList = newBookList;
        long timeWithOpenCSV = System.nanoTime() - start;
        System.out.println("timeWithOpenCSV" + timeWithOpenCSV);
    }



    public void readFileParser(){
        long start = System.nanoTime();
        String[] attributes = new String[8];
        boolean inQuotes = false;
        StringBuilder b = new StringBuilder();
        int pos = 0;

        MyList<Book> newBookList = new MyLinkedListImpl<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                pos = 0;
                inQuotes = false;
                b = new StringBuilder();
                for (char c : line.toCharArray()) {
                    switch (c) {
                        case ',':
                            if (inQuotes) {
                                b.append(c);
                            } else {
                                attributes[pos] = b.toString();
                                pos++;
                                b = new StringBuilder();
                            }
                            break;
                        case '\"':
                            inQuotes = !inQuotes;
                        default:
                            b.append(c);
                            break;
                    }
                }
                attributes[pos] = b.toString();

                if (attributes[3].equals("NaN")){
                    attributes[3] = String.valueOf(0);
                }

                String[] authors = attributes[2].split(",");

                Book busLine = new Book(Long.parseLong(attributes[0]), attributes[1], authors, Integer.parseInt(attributes[3]),attributes[4],attributes[5],attributes[6],attributes[7]);

                newBookList.add(busLine);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace(); }

        this.bookList = newBookList;
        long timeWithParser = System.nanoTime() - start;
        System.out.println("timeWithParser" + timeWithParser);


    }


}




