package App;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

abstract public class User implements Serializable {
    protected String fName, lName, uid, password;
    protected HashSet<Course> courses = new HashSet<Course>();

    public User(String fName, String lName, String uid, String password) {
        this.fName = fName;
        this.lName = lName;
        this.uid = uid;
        this.password = password;
    }

    abstract public String getPassword();
    abstract public HashSet<Course> getCourses();
    abstract public HashSet<Student> getStudents();
}
