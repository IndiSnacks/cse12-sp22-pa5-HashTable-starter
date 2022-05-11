/**
 * Name: Sahil Gathe
 * ID: A16840774
 * Email: sgathe@ucsd.edu
 * Sources used:Tutors, Zybooks, and Lecture Slides
 * 
 * This file implents the courstom tester for the course, student, and sanctuary classes
 */

import java.util.*;
import java.util.jar.JarEntry;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class implments a coustom tester for the course sanctuary, and student classes
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when [two students have differnt PIDs]
     */
    @Test
    public void testEquals() {
        Student student1 = new Student("jay","joe", "A12345");
        Student student2 = new Student("jay","joe", "A123456");
        assertEquals(false, student1.equals(student2));
    }

    /**
     * Test the compareTo method when [students have differnt first last and PID's]
     */
    @Test
    public void testCompareTo() {
        Student student1 = new Student("jay","joe", "A12345");
        Student student2 = new Student("jay","notjoe", "A12345");
        Student student3 = new Student("notjay","joe", "A12345");
        Student student4 = new Student("jay","joe", "A1234567");
        assertEquals(-4, student1.compareTo(student2));
        assertEquals(-4, student1.compareTo(student3));
        assertEquals(-2, student1.compareTo(student4));
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when [enrolling when class is full]
     */
    @Test
    public void testEnroll() {
        Course course = new Course("CSE", "12", "Data Structure", 1);
        course.enrolled = new HashSet<>();
        Student student1 = new Student("jay", "joe", "A123");
        Student student2 = new Student("jay2", "joe2", "A1232");
        assertTrue(course.enroll(student1));
        assertFalse(course.enroll(student2));
        assertTrue(course.enrolled.contains(student1));
        assertFalse(course.enrolled.contains(student2));
        assertEquals(1, course.enrolled.size());
    }

    /**
     * Test the unenroll method when [unenrolling a student not in the class]
     */
    @Test
    public void testUnenroll() {
        Course course = new Course("CSE", "12", "Data Structure", 1);
        Student student1 = new Student("Jay", "joe", "A123");
        Student student2 = new Student("Jay2", "joe2", "A1232");

        course.enrolled = new HashSet<>();
        course.enrolled.add(student1);

        assertFalse(course.unenroll(student2));
        assertFalse(course.enrolled.contains(student2));
        assertEquals(1, course.enrolled.size());
    }

    /**
     * Test the getRoster method when [calss is at capasity]
     */
    @Test
    public void testGetRoster() {
        Course course = new Course("CSE", "12", "Data Structure", 1);
        Student student1 = new Student("Jay", "joe", "A123");
        Student student2 = new Student("Jay2", "joe2", "A1232");

        course.enrolled = new HashSet<>();
        course.enrolled.add(student1);
        course.enrolled.add(student2);
 
        ArrayList<Student> studArylist = course.getRoster();

        assertEquals(student1,studArylist.get(0));
        assertEquals(student2,studArylist.get(1));
    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when [0 is an input]
     */
    @Test
    public void testSanctuaryConstructor() {
        Sanctuary sanctuary1 = new Sanctuary(3, 3);
        assertEquals(3, sanctuary1.maxAnimals);
        assertEquals(3, sanctuary1.maxSpecies);

        boolean error = false;
        try{
            Sanctuary sanctuary2 = new Sanctuary(-1, 3);
        }catch(IllegalArgumentException bad){
            error = true;
        }
        assertTrue(error);
    }

    /**
     * Test the rescue method when [full santuary]
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary sanctuary = new Sanctuary(3, 2);

        assertEquals(0,sanctuary.rescue("dog", 2));
        assertEquals(2, sanctuary.getTotalAnimals());
        assertEquals(1, sanctuary.rescue("cat", 2));
    }

    /**
     * Test the rescue method when [resuce number is 0 or spices is null]
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary sanctuary = new Sanctuary(3, 2);

        boolean error = false;
        try{
            sanctuary.rescue(null, 1);
        }catch(IllegalArgumentException bad){
            error = true;
        }
        assertTrue(error);

        boolean error2 = false;
        try{
            sanctuary.rescue("cat", 0);
        }catch(IllegalArgumentException bad){
            error2 = true;
        }
        assertTrue(error2);
    }

    /**
     * Test the release method when [relseasing a species that dose not exist]
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary sanctuary = new Sanctuary(3, 2);
        sanctuary.sanctuary.put("dog", 1);
        sanctuary.sanctuary.put("cat", 1);

        boolean error = false;
        try{
            sanctuary.release("mouse", 1);
        }catch(IllegalArgumentException bad){
            error = true;
        }
        assertTrue(error);
    }

    /**
     * Test the release method when [not more animals then are there]
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary sanctuary = new Sanctuary(3, 2);
        sanctuary.sanctuary.put("dog", 3);

        boolean error = false;
        try{
            sanctuary.release("dog", 5);
        }catch(IllegalArgumentException bad){
            error = true;
        }
        assertTrue(error);
    }
}

