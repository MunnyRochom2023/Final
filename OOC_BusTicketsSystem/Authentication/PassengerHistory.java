package OOC_BusTicketsSystem.Authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PassengerHistory extends Authentication {

    public static void displayBookingHistory(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/munny/Desktop/Java_project1/OOC_BusTicketsSystem/Authentication/Ticket.txt"))) {
            String line;
            boolean foundUser = false;

            while ((line = reader.readLine()) != null) {
                String[] ticketInfo = line.split("/");

                // Check if the line corresponds to the user
                if (ticketInfo.length >= 11 && ticketInfo[1].equals(name)) {
                    foundUser = true;

                    // Display booking history for the user
                    System.out.println("---BusTicket---");
                    System.out.println("Username: " + ticketInfo[1]);
                    System.out.println("Booking Date(DD-MM_YY): " + ticketInfo[2]);
                    System.out.println("Departure Date(DD-MM_YY): " + ticketInfo[3]);
                    System.out.println("Departure Time: " + ticketInfo[4]);
                    System.out.println("Passenger No: " + ticketInfo[5]);
                    System.out.println("Direction: " + ticketInfo[6]);
                    System.out.println("Payment Method: " + ticketInfo[7]);
                    System.out.println("Seats No: " + ticketInfo[8]);
                    System.out.println("Unit price: " + ticketInfo[9] + "$");
                    System.out.println("Amount: " + ticketInfo[10] + "$");
                    System.out.println("Total Amount: " + ticketInfo[11] + "$");
                    System.out.println();
                }
            }

            if (!foundUser) {
                System.out.println("No booking history found for the user: " + name);
            }

        } catch (IOException e) {
            System.err.println("Error reading ticket.txt: " + e.getMessage());
        }
    }
}
