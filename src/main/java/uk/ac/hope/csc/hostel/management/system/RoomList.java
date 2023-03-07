package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a collection of Rooms in the HManagementSystem
 * <p>
 *     The rooms in the hostel/hall in practice.
 * </p>
 */
public class RoomList implements Serializable {

    // Maps each roomNumber to a Room object
    private Map<Integer, Room> rooms;

    // An index by student, for those rooms that are occupied
    // maps each student ID to a room
    private Map<Integer, Room> roomsByStudent;

    public RoomList() {
        rooms = new HashMap<>();
        roomsByStudent = new HashMap<>();
    }

    /**
     *
     * @param room
     */
    public void addRoom(Room room) {
        rooms.put(room.getRoomNumber(), room);
    }

    /**
     *
     * @return
     */
    public List<Room> getRooms() {
        List<Room> roomList = new ArrayList<Room>(rooms.values());
        return roomList.stream().sorted().toList();
    }

    /**
     *
     * @return
     */
    public List<Room> getFreeRooms() {
        List<Room> roomList = new ArrayList<Room>(rooms.values());
        return roomList.stream().filter(p -> p.getSid() == 0).sorted().toList();
    }

    /**
     *
     * @return
     */
    public List<Room> getOccupiedRooms() {
        List<Room> roomList = new ArrayList<Room>(rooms.values());
        return roomList.stream().filter(p -> p.getSid() != 0).sorted().toList();
    }

    /**
     *
     * @param sid
     * @return
     */
    public Room findRoomByStudent(int sid) {
        return roomsByStudent.get(sid);
    }

}
