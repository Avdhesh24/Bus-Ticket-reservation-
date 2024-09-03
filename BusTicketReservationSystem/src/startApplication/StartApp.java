package startApplication;

import useCases.*;
import java.util.Scanner;

import static useCases.BookTicket.bookTicketInput;

public class StartApp {

    // Using a single Scanner instance for the entire application
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Bus Ticket Reservation System!");
        choice();  // Start the main menu
    }

    public static void choice() {
        while (true) {
            System.out.println("Enter your choice:" + "\n"
                    + "+------------------+" + "\n"
                    + "| 1. Admin         |" + "\n"
                    + "| 2. User          |" + "\n"
                    + "| 3. Exit          |" + "\n"
                    + "+------------------+");

            int choice = 0;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Input should be a number" + "\n"
                        + "------------------------");
                sc.next();  // Clear the invalid input
                continue;  // Retry the choice
            }

            switch (choice) {
                case 1:
                    admin();
                    break;
                case 2:
                    user();
                    break;
                case 3:
                    System.out.println("Thank you for visiting us. It’s nice to have you with us today.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void admin() {
        boolean status = AdminLogin.adminLoginDetails();
        if (status) {
            adminMethods();
        } else {
            while (true) {
                System.out.println("Wrong credentials. Press 1 to try again or any other number to return to the main menu.");
                int option = 0;

                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Input should be a number" + "\n"
                            + "------------------------");
                    sc.next();  // Clear the invalid input
                    continue;
                }

                if (option == 1) {
                    admin();
                } else {
                    choice();
                }
                return;
            }
        }
    }

    public static void adminMethods() {
        while (true) {
            System.out.println("Admin Menu:" + "\n"
                    + "+-----------------------------------+" + "\n"
                    + "| 1. Add Bus                        |" + "\n"
                    + "| 2. Confirm Tickets of Customers   |" + "\n"
                    + "| 3. View All Bookings              |" + "\n"
                    + "| 4. Back to Main Menu              |" + "\n"
                    + "| 5. Exit                           |" + "\n"
                    + "+-----------------------------------+");

            int adminChoice = 0;

            try {
                adminChoice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Input should be a number" + "\n"
                        + "------------------------");
                sc.next();  // Clear the invalid input
                continue;
            }

            switch (adminChoice) {
                case 1:
                    AddBus.addBusMethod();
                    break;
                case 2:
                    ConfirmTicketsOfUser.ConfirmTicketsOfUserInput();
                    break;
                case 3:
                    ViewBooking.viewBookingInput();
                    break;
                case 4:
                    choice();
                    return;  // Go back to the main menu
                case 5:
                    System.out.println("Thank you for visiting us. It’s nice to have you with us today.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void user() {
        while (true) {
            System.out.println("User Menu:" + "\n"
                    + "+-------------------------------+" + "\n"
                    + "| 1. Signup                     |" + "\n"
                    + "| 2. Login                      |" + "\n"
                    + "| 3. Back to Main Menu          |" + "\n"
                    + "| 4. Exit                       |" + "\n"
                    + "+-------------------------------+");

            int userChoice = 0;

            try {
                userChoice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Input should be a number" + "\n"
                        + "------------------------");
                sc.next();  // Clear the invalid input
                continue;
            }

            switch (userChoice) {
                case 1:
                    boolean signupSuccess = UserSignup.userSignup();
                    if (signupSuccess) {
                        System.out.println("Signup successful!");
                    } else {
                        System.out.println("Signup failed. Please try again.");
                    }
                    break;
                case 2:
                    boolean loginSuccess = UserLogin.userLogin();
                    if (loginSuccess) {
                        System.out.println("Login successful!");
                        userMethods();
                    } else {
                        System.out.println("Login failed. Please try again.");
                    }
                    break;
                case 3:
                    choice();
                    return;  // Go back to the main menu
                case 4:
                    System.out.println("Thank you for visiting us. It’s nice to have you with us today.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void userMethods() {
        while (true) {
            System.out.println("User Menu:" + "\n"
                    + "+--------------------------------+" + "\n"
                    + "| 1. Book Bus Ticket             |" + "\n"
                    + "| 2. Cancel Bus Ticket           |" + "\n"
                    + "| 3. View Status of Your Tickets |" + "\n"
                    + "| 4. Back to Main Menu           |" + "\n"
                    + "| 5. Exit                        |" + "\n"
                    + "+--------------------------------+");

            int userMethodChoice = 0;

            try {
                userMethodChoice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Input should be a number" + "\n"
                        + "------------------------");
                sc.next();  // Clear the invalid input
                continue;
            }

            switch (userMethodChoice) {
                case 1:
                    bookTicketInput();
                    break;
                case 2:
                    CancelTicket.cancelTicketInput();
                    break;
                case 3:
                    ViewTicket.viewTicketStatus();
                    break;
                case 4:
                    choice();
                    return;  // Go back to the main menu
                case 5:
                    System.out.println("Thank you for visiting us. It’s nice to have you with us today.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
}

