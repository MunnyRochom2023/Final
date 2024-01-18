package OOC_BusTicketsSystem.Authentication;

import java.io.FileWriter;
import java.io.IOException;
    
    public class Register extends Authentication {
    
        private String name;
        private String password;
    
        public Register(String name, String password) {
            this.name = name;
            this.password = password;
        }
    public void writeToFile() {
        try (FileWriter fileWriter = new FileWriter("/home/munny/Desktop/Java_project1/OOC_BusTicketsSystem/Authentication/User.txt", true)) {
            fileWriter.write(name + "," + password + "\n");
            System.out.println("User registered successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to User.txt: " + e.getMessage());
        }
    }

    // Override toString method
    @Override
    public String toString() {
        return "Register [name=" + name + ", password=" + password + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Register other = (Register) obj;
        return name.equals(other.name) && password.equals(other.password);
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
}
