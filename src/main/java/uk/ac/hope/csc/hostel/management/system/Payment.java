package uk.ac.hope.csc.hostel.management.system;

import java.time.Month;

public class Payment {

    private double amount;
    private Month month;

    /**
     * The constructor for a Payment object.
     * @param month the month of the yerar for this payment
     * @param amount the amount paid
     */
    public Payment(Month month, double amount) {
        this.month = month;
        this.amount = amount;
    }

    /**
     * Queries the payment object
     * @return the amount in the payment
     */
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", month=" + month +
                '}';
    }
}
