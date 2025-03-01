package learn.library.data;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CSVReader {
    private String filePath;
    private final String DELIMITER = ",";
    private final String HEADER = "Date,Category,Description,Amount,Payment Method";

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Record> readCSVFile() {
        ArrayList<Record> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                //deserialize line into record object
                records.add(deserialize(line));
                line = reader.readLine();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
    public void addRecord(Record updatedRecord) {
        ArrayList<Record> records = readCSVFile();
        records.add(updatedRecord);
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(HEADER);
            for(Record record : records) {
                writer.println(serialize(record));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Record deserialize(String line) {
        String[] fields = line.split(DELIMITER, -1);
        if (fields.length == 5) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(fields[0], formatter);
            String category = fields[1];
            String name = fields[2];
            BigDecimal cost = new BigDecimal(fields[3]);
            String payment = fields[4];

            return new Record(date, category, name, cost, payment);
        }
        return null;
    }

    private String serialize(Record record) {
        return String.format("%s,%s,%s,%s,%s",
                record.getDate(),
                record.getCategory(),
                record.getName(),
                record.getCost().setScale(2, RoundingMode.HALF_UP),
                record.getPayment());
    }
}
