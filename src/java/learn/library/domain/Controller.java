package learn.library.domain;

import learn.library.data.CSVReader;
import learn.library.data.Record;

import java.util.ArrayList;
import java.util.Objects;

public class Controller {

    CSVReader reader;

    public Controller(String filePath) {
        this.reader = new CSVReader(filePath);
    }

    public ArrayList<Record> filterByCategory(String category) {
        // TODO call the csvReader.readCSVFile() to get the list of records
        //  create new arraylist
        //  filter entire list based on category parameter
        ArrayList<Record> records = reader.readCSVFile();
        ArrayList<Record> filteredRecords = new ArrayList<>();
        for(Record record : records) {
            if(record.getCategory().equals(category)) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }



    public ArrayList<Record> getAllRecords() {
        // TODO calls CSVReader.readCSVFile() and return array of records
        return reader.readCSVFile();
    }
}
