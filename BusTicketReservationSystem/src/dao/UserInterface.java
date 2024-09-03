package dao;

import model.User;

public interface UserInterface {

    boolean userSignup(String username, String password, String firstName, String lastName, String address, String mobile);

    User userLogin(String username, String password);

    String bookTicket(String busName, int userId, int noOfTickets);

    String cancelTicket(int bookingId);

    void viewTicket(int userId, int bookingId);
}

