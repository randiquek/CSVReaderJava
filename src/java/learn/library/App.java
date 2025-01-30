package learn.library;

import learn.library.data.CSVReader;

public class App {
    static CSVReader fileReader;

    public static void main(String[] args) {

        fileReader = new CSVReader("expense_report.csv");
        fileReader.readCSVFile();
        //view.printByCategory(creditCard)
    }
}
