/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.List;

import models.Student;
import java.util.ArrayList;
/**
 *
 * @author Szymek
 */
@Named(value = "studentBean")
@SessionScoped
public class StudentBean implements Serializable {
    
    
    private String firstName;
    private String lastName;
    private Float avg;
    
    private List<Student> students = new ArrayList<>();

    /**
     * Creates a new instance of studentBean
     */
    public StudentBean() {
    }
    
    public void addStudent() {
        students.add(new Student(firstName, lastName, avg));
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the avg
     */
    public Float getAvg() {
        return avg;
    }

    /**
     * @param avg the avg to set
     */
    public void setAvg(Float avg) {
        this.avg = avg;
    }


}