package learn.library.domain;

import learn.library.data.CSVReader;

import java.util.ArrayList;

public class Controller {

    CSVReader reader;
    Record allRecords;



    public ArrayList<Record> filterByCategory(String category) {
        // TODO call the csvReader.readCSVFile() to get the list of records
        //  create new arraylist
        //  filter entire list based on category parameter
        reader.readCSVFile();
        ArrayList<Record> records = new ArrayList<>();

        for(Record record : records) {
        }
    }



    public void getAllRecords() {
        // TODO calls CSVReader.readCSVFile() and return array of records
        reader.readCSVFile();
    }
}
