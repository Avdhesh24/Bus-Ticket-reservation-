package useCases;

import dao.UserInterface;
import dao.UserInterfaceImpl;
import model.User;
import java.util.Scanner;

public class UserLogin {

    public static boolean userLogin() {
        boolean loginSuccessful = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username:");
        String username = sc.next();

        System.out.println("Enter Password:");
        String password = sc.next();

        UserInterface dao = new UserInterfaceImpl();

        try {
            User user = ((UserInterfaceImpl) dao).userLogin(username, password);  // Adjusted to match interface method name
            if (user != null) {
                System.out.println("Welcome to Bus Ticket Reservation Application, " + user.getFirstName() + " " + user.getLastName() + "!");
                loginSuccessful = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (Exception e) {  // Use a generic Exception if UserException is not defined
            System.out.println(e.getMessage());
        }

        return loginSuccessful;
    }
}



