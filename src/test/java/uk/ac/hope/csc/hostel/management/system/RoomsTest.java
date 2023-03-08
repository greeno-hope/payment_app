package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomsTest {

    Room r1, r2, r3;
    Rooms rs;

    @BeforeEach
    void setUp() {
        rs = new Rooms();
        r1 = new Room(1, 200.50, Room.ROOM_TYPE.TYPE_A);
        r2 = new Room(2, 200.50, Room.ROOM_TYPE.TYPE_A);
        r3 = new Room(3, 200.50, Room.ROOM_TYPE.TYPE_A);
    }

    @Test
    void addRoom() {
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertEquals(3, rs.getRoomCount());
    }

    @Test
    void getRoomList() {
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertNotNull(rs.getRoomList());
        assertEquals(3, rs.getRoomList().size());
    }

    @Test
    void getFreeRoomsAsList() {
        r1.setStudent(new Student(21111111, "Fred", "Basset"));
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertEquals(2, rs.getFreeRoomsAsList().size());
    }

    @Test
    void getOccupiedRoomsAsList() {
        r1.setStudent(new Student(21111111, "Fred", "Basset"));
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertEquals(1, rs.getOccupiedRoomsAsList().size());
    }

    @Test
    void getRoomCount() {
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertEquals(3, rs.getRoomCount());
    }

    @Test
    void getOccupiedRoomCount() {
        r1.setStudent(new Student(21111111, "Fred", "Basset"));
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertEquals(1, rs.getOccupiedRoomCount());
    }

    @Test
    void getFreeRoomCount() {
        r1.setStudent(new Student(21111111, "Fred", "Basset"));
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertEquals(2, rs.getFreeRoomCount());
    }

    @Test
    void getRoomByRoomNumber() {
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertNotNull(rs.getRoomByRoomNumber(3));
        assertThrows(IndexOutOfBoundsException.class, () -> rs.getRoomByRoomNumber(20));
    }

    @Test
    void findRoomByStudent() {
        Student s = new Student(21111111, "Fred", "Basset");
        r1.setStudent(s);
        rs.addRoom(r1);
        rs.addRoom(r2);
        rs.addRoom(r3);
        assertNotNull(rs.findRoomByStudent(s));
    }
}