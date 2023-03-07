package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents a Student in the HManagementSystem
 */
public class Student implements Serializable, Comparable {

    // sid is a positive int greater than 0
    private int sid = 0;

    private String fname;
    private String lname;

    // roomNumber is a positive int greater than 0
    private int roomNumber = 0;

    // The list of payments that this student had made
    private List<Payment> payments;

    /**
     * Constructor for a Student object.
     * @param sid a sid (student id)
     * @param fname first name for a Student.
     * @param lname last name for a Student.
     * @throws - IllegalArgumentException if either string argument is null or if sid is not a positive integer
     */
    public Student(int sid, String fname, String lname) {
        if(sid < 1 || fname == null || lname == null) {
            throw new IllegalArgumentException("Invalid arguments passed to Student constructor");
        }
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        payments = new ArrayList<>();
    }

    /**
     * Query for a student ID
     * @return sid for this Student object.
     */
    public int getSid() {
        return sid;
    }

    /**
     * Query for a Student first name.
     * @return first name of this Student
     */
    public String getFname() {
        return fname;
    }

    /**
     *
     * @return
     */
    public String getLname() {
        return lname;
    }

    /**
     *
     * @return
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets a new roomNumber for a Student.
     * @param roomNumber the room to be assigned to the Student.
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", roomNumber=" + roomNumber +
                ", payments=" + payments +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student)o;
        if(sid > other.sid) {
            return 1;
        } else {
            return -1;
        }
    }
}
