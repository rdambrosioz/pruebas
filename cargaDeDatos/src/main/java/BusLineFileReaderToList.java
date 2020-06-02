import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class BusLineFileReaderToList {

    private List<BusLine> busLinesList;
    private String fileName;

    public BusLineFileReaderToList(String pathToFile) {
        this.fileName = pathToFile;
        busLinesList = new LinkedList<>();
    }

    public List<BusLine> getBusLinesList() {
        return busLinesList;
    }

    public void readFile(){
        List<BusLine> newbusLinesList = new LinkedList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                BusLine busLine = new BusLine(attributes);
                newbusLinesList.add(busLine); //
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace(); }

        this.busLinesList = newbusLinesList;

    }

    public void readFileOpenCSV() {
        List<BusLine> newbusLinesList = new LinkedList<>();

        CSVReader reader = null;
        try
        {
            reader = new CSVReader(new FileReader(fileName));
            String [] nextLine;
            nextLine = reader.readNext();
            BusLine newBusLine = null;
            while ((nextLine = reader.readNext()) != null){

                newBusLine = new BusLine(nextLine[0], Long.parseLong(nextLine[1]), nextLine[2],Integer.parseInt(nextLine[3]), Long.parseLong(nextLine[4]),nextLine[5],Long.parseLong(nextLine[6]),nextLine[7]);
                newbusLinesList.add(newBusLine);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.busLinesList = newbusLinesList;
    }




}
