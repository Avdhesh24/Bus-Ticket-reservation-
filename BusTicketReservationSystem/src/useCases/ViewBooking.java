package useCases;

import dao.AdminInterface;
import dao.AdminInterfaceImpl;

public class ViewBooking {
    public static void viewBookingInput() {
        AdminInterface dao = new AdminInterfaceImpl();
        dao.viewAllTicket();
    }
}
