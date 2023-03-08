package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PaymentsTest {

    Payment p1, p2, p3;
    Payments ps;

    @BeforeEach
    void setUp() {
        p1 = new Payment(Month.SEPTEMBER, 200.50, new Date());
        p2 = new Payment(Month.OCTOBER, 200.50, new Date());
        p3 = new Payment(Month.NOVEMBER, 200.50, new Date());
        ps = new Payments();
        ps.addPayment(p1);
        ps.addPayment(p2);
        ps.addPayment(p3);
    }

    @Test
    void addPayment() {
        ps.addPayment(new Payment(Month.DECEMBER, 200.50, new Date()));
        assertEquals(4, ps.getPaymentsList().size());
    }

    @Test
    void getPaymentsList() {
        assertNotNull(ps.getPaymentsList());
    }

    @Test
    void getPaymentCount() {
        assertEquals(3, ps.getPaymentCount());
    }

    @Test
    void testToString() {
        assertNotNull(ps.toString());
    }

    @Test
    void find() {
        assertNotNull(ps.find(Month.NOVEMBER));
        assertNull(ps.find(Month.JANUARY));
    }

    @Test
    void total() {
        assertEquals(601.50, ps.total());
    }

    @Test
    void allPaymentsRecieved() {
        assertTrue(ps.allPaymentsRecieved(Month.NOVEMBER));
        assertFalse(ps.allPaymentsRecieved(Month.JANUARY));
    }
}