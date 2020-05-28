import java.io.BufferedReader;
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




}
