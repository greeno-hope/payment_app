package uk.ac.hope.csc.hostel.management.system;

import java.io.*;

import java.net.URL;
import java.nio.file.Files;
import java.time.Month;
import java.util.Date;
import java.util.List;

import java.util.Random;
import java.util.stream.Stream;

/**
 * This class represents the 'entry point' for the HManagementSystem.
 * Use this class to get back lists of rooms, students and to add
 * delete a student from a room etc...
 */
public class HManagementSystem implements Serializable {

    private Students students;
    private Rooms rooms;

    // Public APIs below here:

    /**
     * Public constructor - just creates the StudentList and RoomList attributes
     */
    public HManagementSystem() {
        rooms = new Rooms();
        students = new Students();
    }

    /**************************************************************************
     *  Setup functions
     *************************************************************************/

    /**
     * Called once to set up some initial Rooms and Students from
     * some .csv files
     */
    public void init(File roomsFile, File studentsFile ) {
        // Read the fake Rooms data
        Random random = new Random(4);
        try {
            initCreateRooms(roomsFile);
            initAddStudents(studentsFile, random);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Reads stored system state from serialized files
     */
    public void loadState() {

    }

    /**
     * Writes system state into serialized files
     */
    public void saveState() {

    }

    /**************************************************************************
     *  Public APIs
     *************************************************************************/

    /**
     *
     * @return
     */
    public Month getCurrentMonth() {
        Date now = new Date();
        return Month.of(now.getMonth());
    }

    /**
     * Pass through function: lists all rooms
     * @return List of Room
     */
    public List<Room> getRooms() {
        return rooms.getRoomList();
    }

    /**
     * Pass through function: lists all occupied rooms
     * @return List of Room
     */
    public List<Room> getOccupiedRooms() {
        return rooms.getOccupiedRoomsAsList();
    }

    /**
     * Pass through function: lists all free rooms
     * @return List of Room.
     */
    public List<Room> getUnoccupiedRooms() {
        return rooms.getFreeRoomsAsList();
    }

    /**
     * Pass through function: lists all registered (living here) students ordred by SID
     * @return
     */
    public List<Student> getStudentsOrderedBySid() {
        return students.getStudentsOrderBySid();
    }

    /**
     * Pass through function: lists all registered (living here) students ordred by surname
     * @return
     */
    public List<Student> getStudentsOrderedByName() {
        return students.getStudentsOrderByName();
    }

    /**
     * Adds a new Student to the hostel
     * </p>
     * Adds to the Student collection.
     * Sets the Student reference in Room to point to the student.
     * Sets the Room reference in Student to point to the room.
     * @param student
     * @param room
     */
    public void addStudentTenant(Student student, Room room) {

        // Check that the student has a unique sid and that the room
        // exists and is unoccupied
        if(students.containsStudent(student.getSid())) {
            throw new IllegalArgumentException("Duplicate Student ID found");
        }
        if(room.getStudent() != null) {
            throw new IllegalArgumentException("Room already occupied");
        }

        // Set the student/room relationship
        students.addStudent(student);
        student.setRoom(room);
        room.setStudent(student);
    }

    /**
     * Moves a student from a current room to a new one.
     * @param student the Student to move.
     * @param newRoom the new Room.
     */
    public void moveStudentTenant(Student student, Room newRoom) {

        if(newRoom.getStudent() != null) {
            throw new IllegalArgumentException("Room already occupied");
        }
        Room currentRoom = student.getRoom();
        currentRoom.setStudent(null);
        newRoom.setStudent(student);
        student.setRoom(newRoom);
    }

    /**
     * Removes (unregisters) a Student
     * @param student the Student to delete.
     */
    public void removeStudentTenant(Student student) {
        student.getRoom().setStudent(null);
        students.getStudentMap().remove(student.getSid());
    }

    public void makePayment(Student student, Payment payment) {
        student.addPayment(payment);
    }


    /**************************************************************************
     *
     * Initializer functions - load fake data from the csv files
     *
     *************************************************************************/
    public void initCreateRooms(File file) throws IOException{

        List<String> lines = Files.readAllLines(file.toPath());
        lines.remove(0);
        for(String line: lines) {
            String[] values = line.split(",");
            int roomNumber = Integer.parseInt(values[0]);
            Room.ROOM_TYPE type = getType(values[1]);
            double rate = Double.valueOf(values[2]);
            rooms.addRoom(new Room(roomNumber, rate, type));
        }
    }

    public void initAddStudents(File file, Random random) throws IOException {

        List<String> lines = Files.readAllLines(file.toPath());
        lines.remove(0);
        for(String line: lines) {
            String[] values = line.split(",");
            // Make a student
            String fname = values[0];
            String lname = values[1];
            int sid = Integer.parseInt(values[2]);
            Student student = new Student(sid, fname, lname);
            // Get the empty rooms
            List<Room> emptyRooms = rooms.getFreeRoomsAsList();
            int size = emptyRooms.size();
            int index = random.nextInt(0, size-1);
            addStudentTenant(student, emptyRooms.get(index));
        }
    }

    private static Room.ROOM_TYPE getType(String s) {
        if(s.equals("A")) {
            return Room.ROOM_TYPE.TYPE_A;
        } else if (s.equals("B")) {
            return Room.ROOM_TYPE.TYPE_B;
        } else if (s.equals("C")) {
            return Room.ROOM_TYPE.TYPE_C;
        } else {
            return Room.ROOM_TYPE.TYPE_D;
        }
    }

}
