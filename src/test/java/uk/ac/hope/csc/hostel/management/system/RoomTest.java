package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room r1, r2;

    @BeforeEach
    void setUp() {
        r1 = new Room(3, 200.50, Room.ROOM_TYPE.TYPE_A);
        r2 = new Room(5, 200.50, Room.ROOM_TYPE.TYPE_A);
    }

    @Test
    void getRoomNumber() {
        assertEquals(3, r1.getRoomNumber());
    }

    @Test
    void getRate() {
        assertEquals(200.5, r1.getRate());
    }

    @Test
    void setRate() {
        r2.setRate(250.50);
        assertEquals(250.50, r2.getRate());
    }

    @Test
    void getType() {
        assertEquals(Room.ROOM_TYPE.TYPE_A, r2.getType());
    }

    @Test
    void getStudent() {
        assertNull(r1.getStudent());
    }

    @Test
    void setStudent() {
        Student s = new Student(21111111, "Eric", "Idle");
        r1.setStudent(s);
        assertNotNull(r1.getStudent());
    }

    @Test
    void compareTo() {
        assertEquals(-1, r1.compareTo(r2));
    }

    @Test
    void testToString() {
        assertNotNull(r1.toString());
    }
}