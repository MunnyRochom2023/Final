package OOC_BusTicketsSystem.Authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends Authentication {

    private String name;
    private String password;

    public Login(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static boolean authenticateUser(String name, String password) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/munny/Desktop/Java_project1/OOC_BusTicketsSystem/Authentication/User.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 2 && userData[0].equals(name) && userData[1].equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.err.println("Error reading User.txt: " + e.getMessage());
            return false;
        }
    }
}
