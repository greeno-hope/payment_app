package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PaymentListTest {

    PaymentList pl;

    @BeforeEach
    void setUp() {
        pl = new PaymentList();
        pl.addPayment(new Payment(Month.SEPTEMBER, 200.50));
        pl.addPayment(new Payment(Month.OCTOBER, 200.50));
        pl.addPayment(new Payment(Month.NOVEMBER, 200.50));
        pl.addPayment(new Payment(Month.DECEMBER, 200.50));
        pl.addPayment(new Payment(Month.JANUARY, 200.50));
    }

    @Test
    void getCount() {
        assertEquals(5, pl.getPaymentCount());
    }

    @Test
    void addPayment() {
        pl.addPayment(new Payment(Month.FEBRUARY, 200.50));
        assertEquals(6, pl.getPaymentCount());
    }

    @Test
    void addInvalidPayment() {
        assertThrows(IllegalArgumentException.class, () -> pl.addPayment(new Payment(Month.SEPTEMBER, 100.00)));
    }

    @Test
    void getPayments() {
        assertEquals(5, pl.getPayments().size());
    }

    @Test
    void testToString() {
    }

    @Test
    void find() {
        assertEquals(Month.SEPTEMBER, pl.find(Month.SEPTEMBER).getMonth());
    }

    @Test
    void total() {
    }

}