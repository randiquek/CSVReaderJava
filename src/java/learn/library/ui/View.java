package learn.library.ui;

import learn.library.domain.Controller;
import learn.library.data.CSVReader;
import learn.library.data.Record;
import java.util.ArrayList;

public class View {
    Controller controller;

    public View(String filePath) {
        this.controller = new Controller(filePath);
    }

    public void printAll() {
        // call Controller.getAllRecords()
        ArrayList<Record> records = controller.getAllRecords();
        for(Record record : records) {
            System.out.println(record);
        }
    }
    public ArrayList<Record> printByCategory(String category) {
    //TODO get an array list from Controller.filterByCategory(category)
        ArrayList<Record> records = controller.filterByCategory(category);
    // loop through array list and print
        for(Record record : records) {
            System.out.println(record);
        }
        return records;
    }


}
