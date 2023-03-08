package uk.ac.hope.csc.hostel.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {

    Student s1;
    Student s2;
    Students ss;

    @BeforeEach
    void setUp() {
        s1 = new Student(20000001, "Fred", "Bloggs");
        s2 = new Student(20000002, "Eric", "Wiggle");
        ss = new Students();
    }

    @Test
    void addStudent() {
        ss.addStudent(s1);
        assertEquals(1, ss.getStudentsOrderBySid().size());
    }

    @Test
    void containsStudent() {
        ss.addStudent(s1);
        assertTrue(ss.containsStudent(s1.getSid()));
    }

    @Test
    void getStudentMap() {
        assertNotNull(ss.getStudentMap());
    }

    @Test
    void getStudentsOrderBySid() {
        ss.addStudent(s1);
        ss.addStudent(s2);
        List<Student> sl = ss.getStudentsOrderBySid();
        assertNotNull(sl);
        assertEquals(-1, sl.get(0).compareTo(sl.get(1)));
    }

    @Test
    void getStudentsOrderByName() {
        ss.addStudent(s1);
        ss.addStudent(s2);
        assertNotNull(ss.getStudentsOrderByName());
    }
}