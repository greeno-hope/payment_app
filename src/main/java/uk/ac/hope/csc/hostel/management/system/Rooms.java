package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents a collection of Rooms in the HManagementSystem
 * <p>
 *     The rooms in the hostel/hall in practice.
 * </p>
 */
public class Rooms implements Serializable {

    // A list each roomNumber is the index of a Room object
    private List<Room> roomList;

    /**
     * No arg constructor
     */
    public Rooms() {
        roomList = new ArrayList<>();
    }

    /**
     * Adds a single room to the rooms collection. This function will
     * be called only from the init() series of functions
     * @param room
     */
    public void addRoom(Room room) {
        roomList.add(room);
    }

    /**
     * Returns an (unmodifiable) rooms list
     * @return list of rooms.
     */
    public final List<Room> getRoomList() {
        return roomList;
    }

    /**
     * Returns an (unmodifiable) rooms list of free (unoccupied) rooms
     * @return list of free rooms.
     */
    public final List<Room> getFreeRoomsAsList() {
        return roomList.stream().filter(p -> p.getStudent() == null).sorted().toList();
    }

    /**
     * Returns an (unmodifiable) rooms list of occupied rooms
     * @return list of occupied rooms.
     */
    public final List<Room> getOccupiedRoomsAsList() {
        return roomList.stream().filter(p -> p.getStudent() != null).sorted().toList();
    }

    /**
     * Returns number of rooms in the hostel.
     * @return List<Room> size()
     */
    public int getRoomCount() {
        return roomList.size();
    }

    /**
     * Utility function: Returns number of occupied rooms in the hostel.
     * @return number of occupied rooms.
     */
    public int getOccupiedRoomCount() {
        return (int) roomList.stream().filter(p -> p.getStudent() != null).count();
    }

    /**
     * Utility function: Returns number of free rooms.
     * @return number of free rooms
     */
    public int getFreeRoomCount() {
        return (int) roomList.stream().filter(p -> p.getStudent() == null).count();
    }

    /**
     * Utility function: The room number is the room index in the ArrayList
     * @param roomNumber number of the required room.
     * @return the Room which has that roomNumber.
     */
    public Room getRoomByRoomNumber(int roomNumber) {
        return roomList.get(roomNumber-1);
    }

    /**
     * Utility function: Finds a room for a given Student.
     * TODO: exercise, could implement a secondary index to avoid the loop - how would you do this?
     * @param student the Student who's room we want
     * @return a Room for the passed in Student.
     */
    public Room findRoomByStudent(Student student) {
        for(Room r : roomList) {
            // We can do this because if the student is the right one the reference
            // will be the same. We could also Override equals() and use that, which
            // is actually the right thing to do here - TODO fix me!
            if(r.getStudent() == student) {
                return r;
            }
        }
        return null;
    }

}
