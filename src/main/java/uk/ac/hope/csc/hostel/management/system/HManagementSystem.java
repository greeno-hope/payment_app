package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This class represents the 'entry point' for the HManagementSystem.
 * Use this class to get back lists of rooms, students and to add
 * delete a student from a room etc...
 */
public class HManagementSystem implements Serializable {

    private StudentList students;
    private RoomList rooms;

    // Public APIs below here:

    /**
     * Public constructor - just creates the StudentList and RoomList attributes
     */
    public HManagementSystem() {
        rooms = new RoomList();
        students = new StudentList();
    }

    /*
        Setup functions
     */

    /**
     * Called once to set up some initial Rooms and Students from
     * some .csv files
     */
    public void runFirstTimeConfiguration() {

    }

    /**
     * Reads stored system state from serialized files
     */
    public void initialise() {

    }

    /**
     * Writes system state into serialized files
     */
    public void shutdown() {

    }

    /**
     *
     * @return
     */
    public Month getCurrentMonth() {
        Date now = new Date();
        return Month.of(now.getMonth());
    }

    public List<Room> getRooms() {
        return rooms.getRooms();
    }

    public List<Room> getOccupiedRooms() {
        return rooms.getOccupiedRooms();
    }

    public List<Room> getUnoccupiedRooms() {
        return rooms.getFreeRooms();
    }

    public List<Student> getStudents() {
        return students.getStudents();
    }







}
