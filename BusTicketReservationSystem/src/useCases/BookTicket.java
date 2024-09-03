package useCases;

import java.util.Scanner;
import dao.UserInterface;
import dao.UserInterfaceImpl;
import model.User;  // Import the User class

public class BookTicket {
    public static void bookTicketInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Bus Name: ");
        String busName = sc.next();

        UserInterface dao = new UserInterfaceImpl();

        try {
            System.out.println("Enter the number of Tickets for Booking: ");
            int noOfTickets = sc.nextInt();
            // Display the message from the booking process

            int userId = User.getUserid();
            String message = dao.bookTicket(busName, userId, noOfTickets);
        } catch (Exception e) {
            System.out.println("An error occurred while booking the ticket. Please try again.");
        }
    }
}



