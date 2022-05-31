package App.Server;

import App.Course;
import App.Instructor;
import App.Student;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {
    static String fileSeparator = System.getProperty("file.separator");
    static ObjectOutputStream out;

    public static void initDatabase() {
        try {
            // Jasypt library was used for encrypting passwords
            StandardPBEStringEncryptor passwordEncryptor = new StandardPBEStringEncryptor();
            passwordEncryptor.setPassword(System.getenv("secret"));

            // Courses declaration
            Course cpit251 = new Course("CPIT251");
            Course cpit280 = new Course("CPIT280");
            Course cpit370 = new Course("CPIT370");
            Course cpit252 = new Course("CPIT252");
            Course cpit305 = new Course("CPIT305");
            Course cpit330 = new Course("CPIT330");
            Course cpit380 = new Course("CPIT380");
            Course cpit425 = new Course("CPIT425");
            Course cpit405 = new Course("CPIT405");
            Course cpit498 = new Course("CPIT498");
            Course cpit345 = new Course("CPIT345");
            Course cpit435 = new Course("CPIT435");

            // Instructors declaration
            Instructor instructor1 = new Instructor("Rayan", "Mosli", "5349611", passwordEncryptor.encrypt("password11"));
            Instructor instructor2 = new Instructor("Reda", "Salamah", "5349622", passwordEncryptor.encrypt("password22"));
            Instructor instructor3 = new Instructor("Khalid", "Alharbi", "5349633", passwordEncryptor.encrypt("password33"));
            Instructor instructor4 = new Instructor("Mohammed", "Alhaddad", "5349644", passwordEncryptor.encrypt("password44"));
            Instructor instructor5 = new Instructor("Hassan", "Alterazi", "5349655", passwordEncryptor.encrypt("password55"));
            Instructor instructor6 = new Instructor("Majed", "Alshishtawi", "5349666", passwordEncryptor.encrypt("password66"));
            Instructor instructor7 = new Instructor("Mohammed", "Monowar", "5349677", passwordEncryptor.encrypt("password77"));
            Instructor instructor8 = new Instructor("Rayed", "Alghamdi", "5349688", passwordEncryptor.encrypt("password88"));

            // Adding instructors
            instructor4.addCourse(cpit251);
            instructor8.addCourse(cpit280);
            instructor7.addCourse(cpit370);
            instructor1.addCourse(cpit252);
            instructor3.addCourse(cpit252);
            instructor1.addCourse(cpit305);
            instructor2.addCourse(cpit305);
            instructor5.addCourse(cpit330);
            instructor8.addCourse(cpit380);
            instructor7.addCourse(cpit425);
            instructor2.addCourse(cpit405);
            instructor3.addCourse(cpit405);
            instructor6.addCourse(cpit498);
            instructor1.addCourse(cpit345);
            instructor5.addCourse(cpit435);


            // Database directory for instructors
            String databaseDir = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "java" + fileSeparator + "App" + fileSeparator + "Server" + fileSeparator + "Database" + fileSeparator + "Students" + fileSeparator;


            // Writing students to local disk database

            // Student 1
            String userDir = databaseDir.concat("1935149");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            Student student = new Student("Abdulrahman", "Alosaimi", "1935149", 4.74, passwordEncryptor.encrypt("password1"));
            student.addCourse(cpit252);
            student.addCourse(cpit380);
            student.addCourse(cpit425);
            student.addCourse(cpit305);
            student.addCourse(cpit330);
            out.writeObject(student);

            // Student 2
            userDir = databaseDir.concat("1941167");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Saud", "Alslimany", "1941167", 4.41, passwordEncryptor.encrypt("password2"));
            student.addCourse(cpit251);
            student.addCourse(cpit280);
            student.addCourse(cpit425);
            student.addCourse(cpit305);
            student.addCourse(cpit330);
            out.writeObject(student);

            // Student 3
            userDir = databaseDir.concat("1936299");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Abdullah", "Bajaman", "1936299", 4.45, passwordEncryptor.encrypt("password3"));
            student.addCourse(cpit498);
            student.addCourse(cpit435);
            student.addCourse(cpit425);
            student.addCourse(cpit405);
            student.addCourse(cpit380);
            out.writeObject(student);

            // Student 4
            userDir = databaseDir.concat("1935864");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Faisal", "Alshehri", "1935864", 4.78, passwordEncryptor.encrypt("password4"));
            student.addCourse(cpit370);
            student.addCourse(cpit345);
            student.addCourse(cpit380);
            student.addCourse(cpit305);
            student.addCourse(cpit330);
            out.writeObject(student);

            // Student 5
            userDir = databaseDir.concat("1931247");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Abdulaziz", "AlGhamdi", "1931247", 2.4, passwordEncryptor.encrypt("password5"));
            student.addCourse(cpit370);
            student.addCourse(cpit251);
            student.addCourse(cpit280);
            student.addCourse(cpit305);
            out.writeObject(student);

            // Student 6
            userDir = databaseDir.concat("2900270");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Gilgamesh", "Alotaibi", "2900270", 4.99, passwordEncryptor.encrypt("password6"));
            student.addCourse(cpit251);
            student.addCourse(cpit252);
            student.addCourse(cpit380);
            student.addCourse(cpit280);
            student.addCourse(cpit330);
            student.addCourse(cpit345);
            student.addCourse(cpit305);
            out.writeObject(student);

            // Student 7
            userDir = databaseDir.concat("1914000");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Majid", "Almohandis", "1914000", 0.1, passwordEncryptor.encrypt("password7"));
            student.addCourse(cpit498);
            student.addCourse(cpit330);
            out.writeObject(student);

            // Student 8
            userDir = databaseDir.concat("0470490");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Leonidas", "I", "0470490", 4.6, passwordEncryptor.encrypt("password8"));
            student.addCourse(cpit252);
            student.addCourse(cpit380);
            student.addCourse(cpit280);
            student.addCourse(cpit330);
            student.addCourse(cpit345);
            student.addCourse(cpit305);
            out.writeObject(student);

            // Student 9
            userDir = databaseDir.concat("1925557");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Abdulrahman", "Gusty", "1925557", 3.0, passwordEncryptor.encrypt("password9"));
            student.addCourse(cpit305);
            student.addCourse(cpit252);
            student.addCourse(cpit435);
            student.addCourse(cpit380);
            out.writeObject(student);

            // Student 10
            userDir = databaseDir.concat("1864537");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Talal", "Najm", "1864537", 3.84, passwordEncryptor.encrypt("password10"));
            student.addCourse(cpit330);
            student.addCourse(cpit252);
            student.addCourse(cpit435);
            student.addCourse(cpit380);
            student.addCourse(cpit405);
            out.writeObject(student);

            // Student 11
            userDir = databaseDir.concat("1679854");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Obaid", "Alotaibi", "1679854", 4.2, passwordEncryptor.encrypt("password11"));
            student.addCourse(cpit498);
            student.addCourse(cpit252);
            student.addCourse(cpit435);
            student.addCourse(cpit425);
            out.writeObject(student);

            // Student 12
            userDir = databaseDir.concat("1754512");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Yaser", "Alfahad", "1754512", 3.11, passwordEncryptor.encrypt("password12"));
            student.addCourse(cpit345);
            student.addCourse(cpit280);
            student.addCourse(cpit405);
            student.addCourse(cpit380);
            student.addCourse(cpit330);
            student.addCourse(cpit252);
            out.writeObject(student);

            // Student 13
            userDir = databaseDir.concat("1834665");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Ali", "Faisal", "1834665", 4.22, passwordEncryptor.encrypt("password13"));
            student.addCourse(cpit305);
            student.addCourse(cpit252);
            student.addCourse(cpit435);
            student.addCourse(cpit380);
            out.writeObject(student);

            // Student 14
            userDir = databaseDir.concat("1468725");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Saad", "Alzahrani", "1468725", 0.11, passwordEncryptor.encrypt("password14"));
            student.addCourse(cpit370);
            student.addCourse(cpit498);
            student.addCourse(cpit435);
            student.addCourse(cpit425);
            student.addCourse(cpit405);
            out.writeObject(student);

            // Student 15
            userDir = databaseDir.concat("2235487");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Alaa", "Mohammed", "2235487", 1.6, passwordEncryptor.encrypt("password15"));
            student.addCourse(cpit370);
            student.addCourse(cpit251);
            student.addCourse(cpit252);
            student.addCourse(cpit405);
            out.writeObject(student);

            // Student 16
            userDir = databaseDir.concat("1560101");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Naif", "Fadel", "1560101", 4.04, passwordEncryptor.encrypt("password16"));
            student.addCourse(cpit370);
            student.addCourse(cpit498);
            student.addCourse(cpit425);
            student.addCourse(cpit498);
            out.writeObject(student);


            // Student 17
            userDir = databaseDir.concat("1822514");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Abdullah", "Yaser", "1822514", 3.97, passwordEncryptor.encrypt("password17"));
            student.addCourse(cpit280);
            student.addCourse(cpit345);
            student.addCourse(cpit380);
            student.addCourse(cpit435);
            student.addCourse(cpit252);
            out.writeObject(student);


            // Student 18
            userDir = databaseDir.concat("1923950");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Rayan", "Jamal", "1923950", 4.71, passwordEncryptor.encrypt("password18"));
            student.addCourse(cpit252);
            student.addCourse(cpit251);
            student.addCourse(cpit370);
            student.addCourse(cpit498);
            out.writeObject(student);

            // Student 19
            userDir = databaseDir.concat("1515487");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Saeed", "Saad", "1515487", 4.25, passwordEncryptor.encrypt("password19"));
            student.addCourse(cpit498);
            student.addCourse(cpit252);
            student.addCourse(cpit405);
            out.writeObject(student);

            // Student 20
            userDir = databaseDir.concat("0654874");
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));

            student = new Student("Mohammed", "Abdo", "0654874", 0.09, passwordEncryptor.encrypt("password20"));
            student.addCourse(cpit498);
            student.addCourse(cpit252);
            student.addCourse(cpit345);
            student.addCourse(cpit380);
            student.addCourse(cpit405);
            out.writeObject(student);


            // Writing instructors to database
            writeInstructorsDir(instructor1);
            writeInstructorsDir(instructor2);
            writeInstructorsDir(instructor3);
            writeInstructorsDir(instructor4);
            writeInstructorsDir(instructor5);
            writeInstructorsDir(instructor6);
            writeInstructorsDir(instructor7);
            writeInstructorsDir(instructor8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeInstructorsDir(Instructor instructor) {
        try {
            // Database directory for instructors
            String databaseDir = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "java" + fileSeparator + "App" + fileSeparator + "Server" + fileSeparator + "Database" + fileSeparator + "Instructors" + fileSeparator;
            String userDir = databaseDir.concat(instructor.getUid());
            Files.createDirectories(Paths.get(userDir));
            out = new ObjectOutputStream(new FileOutputStream(userDir + fileSeparator + "data"));
            out.writeObject(instructor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Initialize local disk with database
            initDatabase();

            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Server is listening at port 5555");
            while (true) {
                RequestHandler requestHandler = new RequestHandler(serverSocket.accept());
                requestHandler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
