package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HManagementSystemTest {

    HManagementSystem hms;

    @BeforeEach
    void setUp() {
        hms = new HManagementSystem();
        URL url = hms.getClass().getClassLoader().getResource("rooms.csv");
        File roomsFile = new File(url.getFile());
        url = hms.getClass().getClassLoader().getResource("students.csv");
        File studentsFile = new File(url.getFile());
        hms.init(roomsFile, studentsFile);
    }

    @Test
    void loadState() {

    }


    @Test
    void saveState() {

    }

    @Test
    void getCurrentMonth() {

    }

    @Test
    void getRooms() {
        assertEquals(100, hms.getRooms().size());
    }

    @Test
    void getOccupiedRooms() {
        assertEquals(50, hms.getOccupiedRooms().size());
    }

    @Test
    void getUnoccupiedRooms() {
        assertEquals(50, hms.getUnoccupiedRooms().size());
    }

    @Test
    void getStudentsOrderedBySid() {
        assertNotNull(hms.getStudentsOrderedBySid());
    }

    @Test
    void getStudentsOrderedByName() {
        assertNotNull(hms.getStudentsOrderedByName());
    }

    @Test
    void addStudentTenant() {
        assertEquals(50, hms.getOccupiedRooms().size());
        Student s = new Student(21111111, "Fred", "Basset");
        Room r = hms.getUnoccupiedRooms().get(0);
        hms.addStudentTenant(s, r);
        assertEquals(51, hms.getOccupiedRooms().size());
    }

    @Test
    void moveStudentTenant() {
        Room r = hms.getUnoccupiedRooms().get(0);
        Student s = hms.getStudentsOrderedByName().get(0);
        hms.moveStudentTenant(s, r);
        assertEquals(50, hms.getOccupiedRooms().size());
    }

    @Test
    void removeStudentTenant() {
        Student s = hms.getStudentsOrderedByName().get(0);
        hms.removeStudentTenant(s);
        assertEquals(49, hms.getOccupiedRooms().size());
        assertEquals(49, hms.getStudentsOrderedBySid().size());
    }

    @Test
    void makePayment() {
        Student s = hms.getStudentsOrderedByName().get(0);
        hms.makePayment(s, new Payment(Month.SEPTEMBER, 200.50, new Date()));
        assertEquals(1, s.getPayments().getPaymentsList().size());
    }

}