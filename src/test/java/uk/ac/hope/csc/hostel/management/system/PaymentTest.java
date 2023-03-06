package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = new Payment(Month.SEPTEMBER, 200.50);
    }

    @Test
    void getAmount() {
        assertEquals(200.50, payment.getAmount());
    }

    @Test
    void setAmount() {
    }

    @Test
    void getMonth() {
    }

    @Test
    void setMonth() {
    }

    @Test
    void testToString() {
    }
}