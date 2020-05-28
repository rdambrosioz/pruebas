
import java.util.List;

    public class Main {
        public static void main(String[] args){
            BusLineFileReaderToList reader = new BusLineFileReaderToList("lineas.csv");
            reader.readFile();
            List<BusLine> busLines = reader.getBusLinesList();

            for (int i = 0; i < 5; i++){
                System.out.println(busLines.get(i));
            }
        }

    }

