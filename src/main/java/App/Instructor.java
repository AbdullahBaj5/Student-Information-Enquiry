package App;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Instructor extends User implements Serializable{
    private HashSet<Student> students = new HashSet<Student>();

    public Instructor(String fName, String lName, String uid, String password) {
        super(fName, lName, uid, password);
    }

    public String getName() {
        return fName + " " + lName;
    }

    public String getUid(){
        return uid;
    }

    public ArrayList<Student> searchCourse(String name) {
        for (Course course: courses) {
            if(course.getName().equalsIgnoreCase(name)) {
                return course.getStudents();
            }
        }
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void setCourses(HashSet<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        courses.add(course);
        course.addInstructor(this);
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void setStudents(HashSet<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addStudents(ArrayList<Student> students){
        for (Student s: students){
            this.students.add(s);
        }
    }

}
