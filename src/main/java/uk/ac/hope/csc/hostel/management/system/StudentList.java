package uk.ac.hope.csc.hostel.management.system;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a collection of Students in the HLManagementSystem
 */
public class StudentList implements Serializable {

    private Map<Integer, Student> students;

    /**
     *  No args constructor
     */
    public StudentList() {
        students = new HashMap<>();
    }

    /**
     * Adds a student to the Students collection.
     * @param s a Student object to add.
     */
    public void addStudent(Student s) {
        students.put(s.getSid(), s);
    }

    /**
     *
     * @param sid
     * @return
     */
    public boolean containsStudent(int sid) {
        if (students.containsKey(sid)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a student from the Students collection.
     * @param sid a Student sid to remove.
     * @return true if the student was removed, false otherwise.
     */
    public boolean removeStudent(int sid) {
        boolean ret = false;
        if(students.containsKey(sid)) {
            ret = true;
            students.remove(sid);
        }
        return ret;
    }

    /**
     * Returns a list of students in SID order
     * @return a sorted Student list
     */
    public List<Student> getStudents() {
        List<Student> studentsAsList = new ArrayList<>(students.values());
        return studentsAsList.stream().sorted().toList();
    }

    /**
     * Returns a list of Students ordered alphabetically by last name
     * @return a sorted List of Students
     */
    public List<Student> getStudentsAlpha() {
        List<Student> studentsAsList = new ArrayList<>(students.values());
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
