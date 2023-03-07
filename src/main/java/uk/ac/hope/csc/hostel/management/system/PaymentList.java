package uk.ac.hope.csc.hostel.management.system;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class PaymentList {

    // For now - may change
    List<Payment> payments;

    /**
     * No argument constructor just creates the ArrayList
     */
    public PaymentList() {
        this.payments = new ArrayList<>();
    }

    /**
     * Adds a Payment onject to the Payment List.
     * @param payment the payment to be added.
     */
    public void addPayment(Payment payment) {
        for(Payment p : payments) {
            if(p.getMonth() == payment.getMonth()) {
                throw new IllegalArgumentException("Duplicate payment for month " + payment.getMonth());
            }
        }
        payments.add(payment);
    }

    /**
     * Retrieves the payments List
     * @return the A List interface over the payments ArrayList.
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     *
     * @return
     */
    public int getPaymentCount() {
        return payments.size();
    }

    /**
     * Overridden toString() method.
     * @return a JSON string showing current object state.
     */
    @Override
    public String toString() {
        return "PaymentList{" +
                "payments=" + payments +
                '}';
    }

    /**
     * Queries for a Payment for a given Month
     * @param month the month for which a payment query is being made
     * @return a Payment object for that month
     */
    public Payment find(Month month) {
        Payment ret = null;
        for(Payment p : payments) {
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
        for(Payment p : payments) {
            ret += p.getAmount();
        }
        return ret;
    }

}
