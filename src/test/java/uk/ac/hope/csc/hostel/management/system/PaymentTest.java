package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = new Payment(Month.SEPTEMBER, 200.50, new Date());
    }

    @Test
    void getAmount() {
        assertEquals(200.50, payment.getAmount());
    }

    @Test
    void getMonth() {
        assertEquals(Month.SEPTEMBER, payment.getMonth());
    }

    @Test
    void testToString() {
    }
}