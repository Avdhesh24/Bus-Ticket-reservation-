package dao;

import utility.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;


public class UserInterfaceImpl implements UserInterface {

    @Override
    public boolean userSignup(String username, String password, String firstName, String lastName, String address, String mobile) {
        boolean flag = false;

        try (Connection conn = DBUtil.provideConnection()) {
            String query = "INSERT INTO users (username, password, firstName, lastName, address, mobile) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, address);
            pstmt.setString(6, mobile);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Signup successful");
                flag = true;
            } else {
                System.out.println("Signup failed");
            }

        } catch (SQLException e) {
            System.err.println("An error occurred during signup: " + e.getMessage());
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public User userLogin(String username, String password) {
        User user = null;

        try (Connection conn = DBUtil.provideConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        rs.getString("mobile")
                );
            }

        } catch (SQLException e) {
            System.err.println("An error occurred during login: " + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public String bookTicket(String busName, int userId, int noOfTickets) {
        String message = "Booking failed";

        try (Connection conn = DBUtil.provideConnection()) {

            // Query to check bus availability
            String query = "SELECT * FROM buses WHERE busName = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, busName);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int busNo = rs.getInt("busNo");
                        int totalSeats = rs.getInt("TotalSeats");
                        int availSeats = rs.getInt("availableSeats");
                        int fare = rs.getInt("TotalFare");

                        if (availSeats >= noOfTickets) {
                            // Proceed with booking if seats are available
                            String updateQuery = "UPDATE buses SET availableSeats = availableSeats - ? WHERE busName = ?";
                            try (PreparedStatement updatePstmt = conn.prepareStatement(updateQuery)) {
                                updatePstmt.setInt(1, noOfTickets);
                                updatePstmt.setString(2, busName);

                                int rowsUpdated = updatePstmt.executeUpdate();

                                if (rowsUpdated > 0) {
                                    // Record the booking in the bookings table
                                    String insertBookingQuery = "INSERT INTO booking(userId, BusNo, seatFrom, seatTo, status) VALUES(?, ?, ?, ?, ?)";
                                    try (PreparedStatement insertPstmt = conn.prepareStatement(insertBookingQuery)) {

                                        int seatFrom = totalSeats - availSeats + 1;
                                        int seatTo = seatFrom + noOfTickets - 1;

                                        insertPstmt.setInt(1, userId);
                                        insertPstmt.setInt(2, busNo);
                                        insertPstmt.setInt(3, seatFrom);
                                        insertPstmt.setInt(4, seatTo);
                                        insertPstmt.setBoolean(5, true);

                                        int bookingResult = insertPstmt.executeUpdate();

                                        if (bookingResult > 0) {
                                            message = "Booking successful!";
                                            System.out.println("Customer ID: " + userId);
                                            System.out.println("Bus No: " + busNo);
                                            System.out.println("Seat No: From " + seatFrom + " to " + seatTo);
                                            System.out.println("Total Fare: " + (fare * noOfTickets));
                                            System.out.println("Booking is yet to be confirmed by the administrator.");
                                        }
                                    }
                                }
                            }
                        } else {
                            message = "Insufficient seats available";
                        }
                    } else {
                        message = "Bus not found";
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("An error occurred during ticket booking: " + e.getMessage());
            e.printStackTrace();
        }

        return message;
    }

    @Override
    public String cancelTicket(int bookingId) {
        String message = "Ticket cancellation failed";

        try (Connection conn = DBUtil.provideConnection()) {
            String selectBookingQuery = "SELECT * FROM booking WHERE bookingId = ?";
            try (PreparedStatement ps0 = conn.prepareStatement(selectBookingQuery)) {
                ps0.setInt(1, bookingId);

                try (ResultSet rs = ps0.executeQuery()) {
                    if (rs.next()) {
                        int busNo = rs.getInt("BusNo");
                        int seatFrom = rs.getInt("seatFrom");
                        int seatTo = rs.getInt("seatTo");
                        int count = seatTo - seatFrom + 1;

                        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM booking WHERE bookingId = ?")) {
                            ps.setInt(1, bookingId);
                            int x = ps.executeUpdate();

                            if (x > 0) {
                                message = "Ticket cancelled successfully";

                                try (PreparedStatement ps1 = conn.prepareStatement("UPDATE buses SET availableSeats = availableSeats + ? WHERE BusNo = ?")) {
                                    ps1.setInt(1, count);
                                    ps1.setInt(2, busNo);
                                    ps1.executeUpdate();
                                }
                            }
                        }
                    } else {
                        message = "Invalid booking ID";
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("An error occurred during ticket cancellation: " + e.getMessage());
            e.printStackTrace();
        }

        return message;
    }

    @Override
    public void viewTicket(int userId, int bookingId) {
        try (Connection conn = DBUtil.provideConnection()) {
            String query = "SELECT * FROM booking WHERE userId = ? AND bookingId = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, userId);
                ps.setInt(2, bookingId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("---------------------------------------------");
                        System.out.println("Booking ID: " + rs.getInt("bookingId"));
                        System.out.println("Bus No: " + rs.getInt("BusNo"));
                        System.out.println("Total tickets: " + (rs.getInt("seatTo") - rs.getInt("seatFrom") + 1));
                        System.out.println("Status: " + (rs.getBoolean("status") ? "Booked" : "Pending"));
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("Invalid booking ID or no ticket reserved.");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("An error occurred while viewing the ticket: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
