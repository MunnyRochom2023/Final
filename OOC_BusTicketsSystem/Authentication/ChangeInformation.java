package OOC_BusTicketsSystem.Authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeInformation extends Authentication {

    private String name;
    private String password;

    public ChangeInformation(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void changeName(String newName) {
        // Implement logic to change the name in User.txt
        // Update the file or handle errors
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getUserFilePath()));
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 2 && userData[0].equals(name) && userData[1].equals(password)) {
                    // Update the name
                    line = newName + "," + password;
                }
                fileContent.append(line).append("\n");
            }

            bufferedReader.close();

            // Write the updated content back to User.txt
            FileWriter fileWriter = new FileWriter(getUserFilePath());
            fileWriter.write(fileContent.toString());
            fileWriter.close();

            System.out.println("Name updated successfully.");

        } catch (IOException e) {
            System.err.println("Error changing name: " + e.getMessage());
        }
    }

    public void changePassword(String newPassword) {
        // Implement logic to change the password in User.txt
        // Update the file or handle errors
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getUserFilePath()));
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 2 && userData[0].equals(name) && userData[1].equals(password)) {
                    // Update the password
                    line = name + "," + newPassword;
                }
                fileContent.append(line).append("\n");
            }

            bufferedReader.close();

            // Write the updated content back to User.txt
            FileWriter fileWriter = new FileWriter(getUserFilePath());
            fileWriter.write(fileContent.toString());
            fileWriter.close();

            System.out.println("Password updated successfully.");

        } catch (IOException e) {
            System.err.println("Error changing password: " + e.getMessage());
        }
    }

    public void changeBoth(String newName, String newPassword) {
        // Implement logic to change both name and password in User.txt
        // Update the file or handle errors
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getUserFilePath()));
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 2 && userData[0].equals(name) && userData[1].equals(password)) {
                    // Update both name and password
                    line = newName + "," + newPassword;
                }
                fileContent.append(line).append("\n");
            }

            bufferedReader.close();

            // Write the updated content back to User.txt
            FileWriter fileWriter = new FileWriter(getUserFilePath());
            fileWriter.write(fileContent.toString());
            fileWriter.close();

            System.out.println("Name and password updated successfully.");

        } catch (IOException e) {
            System.err.println("Error changing name and password: " + e.getMessage());
        }
    }

    // Helper method to get the path of the User.txt file
    private String getUserFilePath() {
        return "/home/munny/Desktop/Java_project1/OOC_BusTicketsSystem/Authentication/User.txt";
    }
}
