package uk.ac.hope.csc.hostel.management.system;

import java.security.InvalidParameterException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        HManagementSystem hms = new HManagementSystem();

        // Start up system from pre-generated fake data or
        // load previously saved state (command line argument)
        if(args.length > 0) {
            if (args[0].equals("-init")) {
                hms.init();
            } else {
                throw new InvalidParameterException("Only -init supported as a command line argument");
            }
        } else {
            hms.loadState();
        }

        // Print the students
        System.out.println("Students list");
        List<Student> students = hms.getStudentsOrderedByName();
        students.forEach(e -> System.out.println(e.toString()));
        System.out.println("\n\n");

        // Print the empty rooms
        System.out.println("Empty rooms list");
        List<Room> emptyRooms = hms.getUnoccupiedRooms();
        emptyRooms.forEach(e -> System.out.println(e.toString()));
        System.out.println("\n\n");

        // Print the empty rooms
        System.out.println("Occupied rooms list");
        List<Room> occupiedRooms = hms.getOccupiedRooms();
        occupiedRooms.forEach(e -> System.out.println(e.toString()));
        System.out.println("\n\n");

    }
}