package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bus;
import utility.DBUtil;

public class AdminInterfaceImpl implements AdminInterface {

    @Override
    public String addBusDao(Bus bus) {
        String message = "Bus addition failed. Please try again.";

        try (Connection conn = DBUtil.provideConnection()) {
            String query = "INSERT INTO buses (busNo, busName, source, destination, departureTime, arrivalTime, totalSeats, availableSeats, totalFare) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, bus.getBusNo());
            ps.setString(2, bus.getBusName());
            ps.setString(3, bus.getSource());
            ps.setString(4, bus.getDestination());
            ps.setString(5, bus.getDepartureTime());
            ps.setString(6, bus.getArrivalTime());
            ps.setInt(7, bus.getTotalSeats());
            ps.setInt(8, bus.getAvailableSeats());
            ps.setInt(9, bus.getTotalFare());

            int x = ps.executeUpdate();
            if (x > 0) {
                message = "Bus added successfully!";
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String updateTicket(int Userid) {
        String message = "Status update failed. Please try again.";

        try (Connection conn = DBUtil.provideConnection()) {
            String query = "UPDATE booking SET status = true WHERE Userid = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, Userid);

            int x = ps.executeUpdate();
            if (x > 0) {
                message = "Status successfully updated for User Id: " + Userid;
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public void viewAllTicket() {
        try (Connection conn = DBUtil.provideConnection()) {
            String query = "SELECT * FROM booking";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            boolean flag = false;
            while (rs.next()) {
                flag = true;

                System.out.println("----------------------------------------------------");
                System.out.println("Booking Id : " + rs.getInt("bookingId"));
                System.out.println("Bus No : " + rs.getInt("busNo"));
                System.out.println("Total tickets : " + (rs.getInt("seatTo") - rs.getInt("seatFrom") + 1));
                System.out.println("Status : " + (rs.getInt("status") == 1 ? "Booked" : "Pending"));
                System.out.println("----------------------------------------------------");
            }

            if (!flag) {
                System.out.println("No ticket found.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


