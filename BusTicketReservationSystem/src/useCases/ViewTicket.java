package useCases;

import java.util.Scanner;
import dao.UserInterface;
import dao.UserInterfaceImpl;

public class ViewTicket {

    public static void viewTicketStatus() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Booking ID:");
        int bookingId = sc.nextInt();

        UserInterface dao = new UserInterfaceImpl();

        try {
            dao.viewTicket(1, bookingId);  // Assuming you have a valid user ID or adjust accordingly
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
