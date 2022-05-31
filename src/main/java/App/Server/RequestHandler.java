package App.Server;

import App.Instructor;
import App.User;
import App.Student;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.*;
import java.net.Socket;

public class RequestHandler extends Thread {

    StandardPBEStringEncryptor passwordDecrypter = new StandardPBEStringEncryptor();
    Socket socket;
    BufferedReader in;
    User user;
    PrintWriter out;
    String fileSeparator = System.getProperty("file.separator");
    String type = "";
    String databaseDir = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "main"
            + fileSeparator + "java" + fileSeparator + "App"
            + fileSeparator + "Server" + fileSeparator + "Database" + fileSeparator;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("The server has connected to a client.");

            passwordDecrypter.setPassword(System.getenv("secret"));

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            type = in.readLine().trim();
            out = new PrintWriter(socket.getOutputStream(), true);
            String sid = in.readLine().trim();
            String password = in.readLine().trim();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(databaseDir + type + fileSeparator + sid + fileSeparator + "data"));

            user = type.equalsIgnoreCase("students") ? (Student) in.readObject() : (Instructor) in.readObject();

            if (passwordDecrypter.decrypt(user.getPassword()).equalsIgnoreCase(password)) {
                out.println("SUCCESS");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(user);
                if (user instanceof Student) {
                    out.println(user.getCourses());
                } else {
                    out.println(user.getStudents());
                }
            } else {
                out.println("FAILURE");
            }

            in.close();
        } catch (FileNotFoundException e) {
            out.println("Error: File is Not Found.");
        } catch (NullPointerException e) {
            out.println("Error: Input is empty.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
