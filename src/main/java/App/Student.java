package App;

import java.io.Serializable;
import java.util.HashSet;

public class Student extends User implements Serializable {
    private double gpa;

    public Student(String fName, String lName, String uid, double gpa, String password) {
        super(fName, lName, uid, password);
        this.gpa = gpa;
    }

    public String getName(){
        return fName + " " + lName;
    }

    public double getGpa() {
        return gpa;
    }

    public String getPassword() {
        return password;
    }

    public void addCourse(Course course){
        courses.add(course);
        course.addStudent(this);
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    @Override
    public HashSet<Student> getStudents() {
        return null;
    }

    public String getFName(){
        return fName;
    }

    public String getLName(){
        return lName;
    }

    public String getUid(){
        return uid;
    }

    @Override
    public String toString() {
        return fName + " " + lName + " || GPA: " + getGpa() + "\n";
    }
}
