package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;

/**
 * Represents a Room in the HManagementSystem
 */
public class Room implements Serializable, Comparable {

    //
    public enum ROOM_TYPE {
        TYPE_A,
        TYPE_B,
        TYPE_C,
        TYPE_D
    };

    // Room number is a positive integer between 1 and ...
    private int roomNumber;

    private double rate;
    private ROOM_TYPE type;
    private int sid = 0;

    /**
     * Constructor for a room
     * @param roomNumber room number
     * @param rate cost of this room (per month)
     * @param type room type ( can be used as an index for a room descriptor)
     */
    public Room(int roomNumber, double rate, ROOM_TYPE type) {
        this.roomNumber = roomNumber;
        this.rate = rate;
        this.type = type;
    }

    /**
     * Returns the roomNumber of a given room.
     * @return the room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the rate (amount / month) for the room
     * @return room rate.
     */
    public double getRate() {
        return rate;
    }

    /**
     * Sets a (new) rate for the room
     * @param rate the new rate.
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Returns the
     * @return
     */
    public ROOM_TYPE getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(ROOM_TYPE type) {
        this.type = type;
    }

    /**
     * Returns the student ID (sid) of teh student occupying this room.
     * @return a positive sid if the room is occupied else 0.
     */
    public int getSid() {
        return sid;
    }

    /**
     *
     * @param sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Room other = (Room) o;
        if( roomNumber > other.roomNumber) {
            return 1;
        } else {
            return -1;
        }
    }
}
