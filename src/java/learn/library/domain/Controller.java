package learn.library.domain;

import learn.library.data.CSVReader;
import learn.library.data.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Controller {

    CSVReader reader;
    public static final ArrayList<String> categories = new ArrayList<>();
    public static final ArrayList<String> payments = new ArrayList<>();

    public Controller(String filePath) {
        this.reader = new CSVReader(filePath);
        categories.addAll(Arrays.asList("Meals", "Travel", "Utilities", "Entertainment", "Office Supplies"));
        payments.addAll(Arrays.asList("Credit Card", "Bank Transfer", "Company Card", "Cash"));
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

    public void addNewRecord(Record newRecord) {
        boolean hasErrors = false;
        if(!categories.contains(newRecord.getCategory())) {
            System.out.println("Invalid category");
            hasErrors = true;
        }
        if(!payments.contains(newRecord.getPayment())) {
            System.out.println("Invalid category");
            hasErrors = true;
        }
        if (!hasErrors) {
            reader.addRecord(newRecord);
            System.out.println("Record was successfully added");
        }
    }
}
