package OOC_BusTicketsSystem.Authentication;

import java.util.Scanner;

public class Authentication {

    private static final String USER_FILE_PATH = "/home/munny/Desktop/Java_project1/OOC_BusTicketsSystem/Authentication/User.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display authentication options
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Change Information");
            System.out.println("4. Passenger History");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Handle registration
                    handleRegistration();
                    break;
                case 2:
                    // Handle login
                    handleLogin();
                    break;
                case 3:
                    // Handle change information
                    handleChangeInformation();
                    break;
                case 4:
                    // Handle passenger history
                    handlePassengerHistory();
                    break;
                case 5:
                    System.out.println("Exiting the Bus Ticket System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void handleRegistration() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
    
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
    
        Register newUser = new Register(name, password);
        newUser.writeToFile();
        System.out.println("Registration completed successfully.");
    
        // After registration, you might want to redirect the user to the login menu or perform other actions.
        // You can add the logic here based on your application flow.
    
        scanner.close();
    }
    
    private static void handleLogin() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
    
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
    
        boolean isAuthenticated = Login.authenticateUser(name, password);
    
        if (isAuthenticated) {
            System.out.println("Login successful.");
    
            // After successful login, you might want to redirect the user to other menus.
            // You can add the logic here based on your application flow.
    
            // Example: Display passenger history
            PassengerHistory.displayBookingHistory(name);
        } else {
            System.out.println("Login failed. User not found or incorrect password.");
        }
    
        scanner.close();
    }
    
    protected static void handleChangeInformation() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
    
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
    
        boolean isAuthenticated = Login.authenticateUser(name, password);
    
        if (isAuthenticated) {
            System.out.println("Authentication successful. Choose the information to change:");
    
            // Create an instance of ChangeInformation
            ChangeInformation changeInformation = new ChangeInformation(name, password);
    
            // Call the non-static method on the instance
            changeInformation.handleChangeInformation();
        } else {
            System.out.println("Authentication failed. User not found or incorrect password.");
        }
    
        scanner.close();
    }
    
    
    private static void handlePassengerHistory() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
    
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
    
        boolean isAuthenticated = Login.authenticateUser(name, password);
    
        if (isAuthenticated) {
            System.out.println("Authentication successful. Displaying passenger history:");
            PassengerHistory.displayBookingHistory(name);
        } else {
            System.out.println("Authentication failed. User not found or incorrect password.");
        }
    
        scanner.close();
    }
    
}
