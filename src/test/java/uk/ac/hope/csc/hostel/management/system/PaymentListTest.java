package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PaymentsTest {

    Payments pl;

    @BeforeEach
    void setUp() {
        pl = new Payments();
        pl.addPayment(new Payment(Month.SEPTEMBER, 200.50, new Date()));
        pl.addPayment(new Payment(Month.OCTOBER, 200.50, new Date()));
        pl.addPayment(new Payment(Month.NOVEMBER, 200.50, new Date()));
        pl.addPayment(new Payment(Month.DECEMBER, 200.50, new Date()));
        pl.addPayment(new Payment(Month.JANUARY, 200.50, new Date()));
    }

    @Test
    void getCount() {
        assertEquals(5, pl.getPaymentCount());
    }

    @Test
    void addPayment() {
        pl.addPayment(new Payment(Month.FEBRUARY, 200.50, new Date()));
        assertEquals(6, pl.getPaymentCount());
    }

    @Test
    void addInvalidPayment() {
        assertThrows(IllegalArgumentException.class, () -> pl.addPayment(new Payment(Month.SEPTEMBER, 100.00, new Date())));
    }

    @Test
    void getPayments() {
        assertEquals(5, pl.getPaymentsList().size());
    }

    @Test
    void testToString() {
    }

    @Test
    void testAllPaymentsRecieved() {
        assertTrue(pl.allPaymentsRecieved(Month.JANUARY));
        assertFalse(pl.allPaymentsRecieved(Month.APRIL));
    }

    @Test
    void find() {
        assertEquals(Month.SEPTEMBER, pl.find(Month.SEPTEMBER).getMonth());
    }

    @Test
    void total() {
        assertEquals(1002.50, pl.total());
    }

}