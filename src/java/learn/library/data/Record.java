package learn.library.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Record {
    LocalDate date;
    String category;
    String name;
    BigDecimal cost;
    String payment;

    public Record() {

    }
    public Record(LocalDate date, String category, String name, BigDecimal cost, String payment) {
        this.date = date;
        this.category = category;
        this.name = name;
        this.cost = cost;
        this.payment = payment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        BigDecimal scaledCost = cost.setScale(2, RoundingMode.HALF_UP);
        return "Date: " + date + // month/ date/ year
                "| Cost: " + "$" + scaledCost + //can be formatted as currency
                "| Name: " + name +
                "| Category: " + category +
                "| Payment: " + payment ;
    }

}
