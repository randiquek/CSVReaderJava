package learn.library;

import learn.library.data.CSVReader;
import learn.library.domain.Controller;
import learn.library.ui.View;
import learn.library.data.Record;

import java.math.BigDecimal;
import java.time.LocalDate;


public class App {
    static CSVReader fileReader;
    static View view;
    static Controller controller;

    public static void main(String[] args) {
        controller = new Controller("expense_report.csv");
        Record newRecord = new Record(LocalDate.of(2024, 4, 5), "Travel",  "Flight to LA", new BigDecimal("200.00"), "Credit Card");
        controller.addNewRecord(newRecord);

        view = new View ("expense_report.csv");

        //view.printAll();
        //view.printByCategory("Meals");
    }
}
