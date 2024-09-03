package useCases;

import java.util.Scanner;
import dao.UserInterface;
import dao.UserInterfaceImpl;

public class CancelTicket {

    public static void cancelTicketInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Booking ID:");
        int bookingId = sc.nextInt();

        UserInterface dao = new UserInterfaceImpl();

        try {
            String message = dao.cancelTicket(bookingId);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
