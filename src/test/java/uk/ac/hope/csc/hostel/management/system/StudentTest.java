package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s1;
    Student s2;

    @BeforeEach
    void setUp() {
        s1 = new Student(20000001, "Fred", "Bloggs");
        s2 = new Student(20000002, "Eric", "Wiggle");
    }

    @Test
    void getSid() {
        assertEquals(20000001, s1.getSid());
        assertNotEquals(20000001, s2.getSid());
    }

    @Test
    void getFname() {
        assertEquals("Fred", s1.getFname());
        assertNotEquals("Fred", s2.getLname());
    }

    @Test
    void getLname() {
        assertEquals("Bloggs", s1.getLname());
        assertNotEquals("Bloggs", s2.getLname());
    }

    @Test
    void getRoom() {
        assertNull(s1.getRoom());
    }

    @Test
    void setRoom() {
        s1.setRoom(new Room(1, 200, Room.ROOM_TYPE.TYPE_A));
        assertNotNull(s1.getRoom());
    }

    @Test
    void getPayments() {
        assertEquals(0, s1.getPayments().getPaymentsList().size());
    }

    @Test
    void addPayment() {
    }

    @Test
    void testToString() {
    }

    @Test
    void compareTo() {
        assertEquals(-1, s1.compareTo(s2));
    }
}