/**
 * Name: Sahil Gathe
 * ID: A16840774
 * Email: sgathe@ucsd.edu
 * Sources used:Tutors, Zybooks, and Lecture Slides
 * 
 * This file implents the student object. This object repersents a course and hold the follow data values. 
 * The courses capacity, department, number & description.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * This class implments the course object which repersents a college course
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * Constructor for the Course class
     * @param department
     * @param number
     * @param description
     * @param capacity
     */
    public Course(String department, String number, String description, 
        int capacity){
            if(department == null || number == null || description == null || capacity < 0 ){
                throw new IllegalArgumentException("Crouse Paramaters are null");
            }
            else{
                this.department = department;
                this.number = number;
                this.description = description;
                this.capacity = capacity;
            }
        }
    
    /**
     * @return the department that the course belongs to
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * @return the course number for the course
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * @return the course description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * @return the description of the course
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     *  enrolls a student into a course by inserting the student object to the enrolled Hashset
     * @param student a student object 
     * @return true if the student is enrolled
     *         false if the student isn't enrolled
     */
    public boolean enroll(Student student) {
        boolean enroll = false;
        if(student == null){
            throw new IllegalArgumentException("Enroll student is null");
        }
        else{
            if(!this.isFull() && !this.getStudents().contains(student)){
                enrolled.add(student);
                enroll = true;
            }
        }
        return enroll;
    }

    /**
     *  unenrolls a stduent forma course by removing them form the enrolled Hashmap
     * @param student
     * @return true if the student is removed 
     *         false if the student isn't removed
     */
    public boolean unenroll(Student student) {
        if(enrolled.contains(student)){
            enrolled.remove(student);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Clears the course Hashmap
     */
    public void cancel() {
        enrolled.clear();
    }

    /**
     * @return true if the course is full
     *          false if the course isn't full
     */
    public boolean isFull() {
        if(enrolled.size() == capacity){
            return true;
        }
        else{
            return false;
        }
    }

    public int getEnrolledCount() {
        return enrolled.size();
    }

    public int getAvailableSeats() {
        return capacity - enrolled.size();
    }

    public HashSet<Student> getStudents() {
        HashSet<Student> returnHash = (HashSet) enrolled.clone();
        return returnHash;
    }

    public ArrayList<Student> getRoster() {
        ArrayList<Student> rtnList = new ArrayList<>();
        for(Student i: enrolled){
            rtnList.add(i);
        }
        Collections.sort(rtnList);
        return rtnList;
    }

    public String toString() {
        String rtnString = department + " " + number + " " + "[" + capacity + "]" + "\n" + description;
        return rtnString;
    }
}

