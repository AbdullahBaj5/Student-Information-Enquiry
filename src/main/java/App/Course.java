package App;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Instructor> instructors = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public void addStudent(Student student){
        students.add(student);

        for(Instructor i: instructors){
            i.addStudent(student);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
