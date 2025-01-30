package learn.library;

import learn.library.data.CSVReader;
import learn.library.ui.View;

public class App {
    static CSVReader fileReader;
    static View view;

    public static void main(String[] args) {

        view = new View ("expense_report.csv");

        //view.printAll();
        view.printByCategory("Meals");
    }
}
