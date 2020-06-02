import com.opencsv.CSVReader;

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

    private List<Book> bookList;
    private String fileName;

    public BookFileReaderToList(String pathToFile) {
        this.fileName = pathToFile;
        bookList = new LinkedList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void readFile(){
        List<Book> newBookList = new LinkedList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                if (attributes[3].equals("NaN")){
                    attributes[3] = String.valueOf(0);
                }
                Book busLine = new Book(attributes);
                newBookList.add(busLine); //
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace(); }

        this.bookList = newBookList;

    }

    public void readFileOpenCSV() {
        List<Book> newBookList = new LinkedList<>();

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
                newBook = new Book(Long.parseLong(nextLine[0]), nextLine[1], nextLine[2], Integer.parseInt(nextLine[3]),nextLine[4],nextLine[5],nextLine[6],nextLine[7]);
                newBookList.add(newBook);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.bookList = newBookList;
    }
}




