package useCases;

import model.Bus;
import dao.AdminInterface;
import dao.AdminInterfaceImpl;

import java.util.Scanner;

public class AddBus {

    public static void addBusMethod() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter Bus number:");
            int busNo = sc.nextInt();

            System.out.println("Enter Bus name:");
            String busName = sc.next();

            System.out.println("Enter Route from:");
            String source = sc.next();

            System.out.println("Enter Route to:");
            String destination = sc.next();

            sc.nextLine(); // Consume newline

            System.out.println("Enter Departure date and time (YYYY-MM-DD HH:MI):");
            String departureTime = sc.nextLine();

            System.out.println("Enter Arrival date and time (YYYY-MM-DD HH:MI):");
            String arrivalTime = sc.nextLine();

            System.out.println("Enter Total Seats:");
            int totalSeats = sc.nextInt();

            System.out.println("Enter Available Seats:");
            int availableSeats = sc.nextInt();

            System.out.println("Enter Total Fare:");
            int totalFare = sc.nextInt();

            // Create Bus object
            Bus bus = new Bus(busNo, busName, source, destination, departureTime, arrivalTime, totalSeats, availableSeats, totalFare);

            // Use AdminInterface to add the bus to the database
            AdminInterface dao = new AdminInterfaceImpl();
            String result = dao.addBusDao(bus);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
}

