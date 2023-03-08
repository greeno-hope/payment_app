package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a collection of Students in the HLManagementSystem
 */
public class Students implements Serializable {

    /**
     * Map of student id to Student object.
     */
    private Map<Integer, Student> studentMap;

    /**
     *  No args constructor
     */
    public Students() {
        studentMap = new HashMap<>();
    }

    /**
     * Adds a student to the Students collection.
     * @param s a Student object to add.
     */
    public void addStudent(Student s) {
        studentMap.put(s.getSid(), s);
    }

    /**
     *
     * @param sid
     * @return
     */
    public boolean containsStudent(int sid) {
        if (studentMap.containsKey(sid)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return the Map sid -> Student
     * @return the Map<Student>
     */
    public Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    /**
     * Returns a list of students in SID order
     * @return a sorted Student list
     */
    public List<Student> getStudentsOrderBySid() {
        List<Student> studentsAsList = new ArrayList<>(studentMap.values());
        return studentsAsList.stream().sorted().toList();
    }

    /**
     * Returns a list of Students ordered alphabetically by last name
     * @return a sorted List of Students
     */
    public List<Student> getStudentsOrderByName() {
        List<Student> studentsAsList = new ArrayList<>(studentMap.values());
        return studentsAsList.stream().sorted(new StudentComparator()).toList();
    }

    //
    static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getLname().compareTo(o2.getLname());
        }
    }

}
