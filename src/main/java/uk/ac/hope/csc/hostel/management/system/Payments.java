package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Payments implements Serializable {

    // For now - may change
    List<Payment> paymentsList;

    /**
     * No argument constructor just creates the ArrayList
     */
    public Payments() {
        this.paymentsList = new ArrayList<>();
    }

    /**
     * Adds a Payment onject to the Payment List.
     * @param payment the payment to be added.
     */
    public void addPayment(Payment payment) {
        for(Payment p : paymentsList) {
            if(p.getMonth() == payment.getMonth()) {
                throw new IllegalArgumentException("Duplicate payment for month " + payment.getMonth());
            }
        }
        paymentsList.add(payment);
    }

    /**
     * Retrieves the payments List
     * @return the A List interface over the payments ArrayList.
     */
    public List<Payment> getPaymentsList() {
        return paymentsList;
    }

    /**
     *
     * @return
     */
    public int getPaymentCount() {
        return paymentsList.size();
    }

    /**
     * Overridden toString() method.
     * @return a JSON string showing current object state.
     */
    @Override
    public String toString() {
        return "PaymentList{" +
                "payments=" + paymentsList +
                '}';
    }

    /**
     * Queries for a Payment for a given Month
     * @param month the month for which a payment query is being made
     * @return a Payment object for that month
     */
    public Payment find(Month month) {
        Payment ret = null;
        for(Payment p : paymentsList) {
            if (month == p.getMonth()) {
                ret = p;
                break;
            }
        }
        return ret;
    }

    /**
     * Queries the PaymentList for a total paid value.
     * @return The sum of all payments made.
     */
    public double total() {
        double ret = 0;
        for(Payment p : paymentsList) {
            ret += p.getAmount();
        }
        return ret;
    }

    /**
     * Function assumes that all students start paying rent in September
     * and the function asserts that all payments from September up to and including
     * the month argument are complete
     * @param month the month up to which to search/test
     * @return true if all payments have been made, false otherwise
     */
    public boolean allPaymentsRecieved(Month month) {
        boolean ret = false;
        switch (month) {
            case SEPTEMBER -> ret = paymentsList.size() == 1;
            case OCTOBER -> ret = paymentsList.size() == 2;
            case NOVEMBER -> ret = paymentsList.size() == 3;
            case DECEMBER -> ret = paymentsList.size() == 4;
            case JANUARY -> ret = paymentsList.size() == 5;
            case FEBRUARY -> ret = paymentsList.size() == 6;
            case MARCH -> ret = paymentsList.size() == 7;
            case APRIL -> ret = paymentsList.size() == 8;
            case MAY -> ret = paymentsList.size() == 9;
            case JUNE -> ret = paymentsList.size() == 10;
            case JULY -> ret = paymentsList.size() == 11;
            case AUGUST -> ret = paymentsList.size() == 12;
        }
        return ret;
    }

}
