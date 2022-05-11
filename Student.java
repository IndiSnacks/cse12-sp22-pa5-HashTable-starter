/**
 * Name: Sahil Gathe
 * ID: A16840774
 * Email: sgathe@ucsd.edu
 * Sources used:Tutors, Zybooks, and Lecture Slides
 * 
 * This file implents the student object. This object repersents a student and has hold the data values. 
 * The sudents firstname, lastname & PID.
 */

import java.nio.channels.Pipe;
import java.security.Policy;
import java.util.Objects;

import javax.xml.transform.Templates;

import org.w3c.dom.ls.LSException;

/**
 * This class implments the student object and repersents a student and all the perspective data that 
 * the student has.
 */
public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * Constructor for the student class
     * @param firstName A string containing a studets first name
     * @param lastName A string containing a lastname
     * @param PID A string containing a studets PID
     */
    public Student(String firstName, String lastName, String PID) {
        if(firstName == null|| lastName == null || PID == null){
            throw new IllegalArgumentException("Student info is null");
        }
        else{
            this.firstName = firstName;
            this.lastName = lastName;
            this.PID = PID;
        }
    }

    /**
     * @return lastName of the student
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @return the first name of the student
     */
    public String getFirstName() {
        return this.firstName;
    }

    /** 
     * @return the PID of the student
     */
    public String getPID() {
        return this.PID;
    }

    /**
     * @param o a student object
     * @return  true if o is equal to o
     *          false if o isn't equal to o
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            Student temp = (Student) o;
            if(this.compareTo(temp) == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }

    }

    /**
     * @return The object hash value
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, PID);
    }

    /**
     * @param o A student object that is being comapred
     * @return  1 if this is greater then o
     *          0 if this is equal to o
     *          -1 if this is less then o
     */
    @Override
    public int compareTo(Student o) {
        Student other = (Student) o;
        if(firstName.compareTo(o.firstName) != 0){
            return firstName.compareTo(other.firstName);
        }else if(lastName.compareTo(other.lastName) != 0){
            return lastName.compareTo(other.lastName);
        }else{
            return PID.compareTo(other.PID);
        }
    }
}
