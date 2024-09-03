package useCases;

import dao.UserInterface;
import dao.UserInterfaceImpl;
import java.util.Scanner;

public class UserSignup {

    public static boolean userSignup() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username:");
        String username = sc.next();

        System.out.println("Enter Password:");
        String password = sc.next();

        System.out.println("Enter First Name:");
        String firstName = sc.next();

        System.out.println("Enter Last Name:");
        String lastName = sc.next();

        sc.nextLine();
        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter Mobile:");
        String mobile = sc.next();

        UserInterface dao = new UserInterfaceImpl();
        boolean result = dao.userSignup(username, password, firstName, lastName, address, mobile);

        if (result) {
            System.out.println("Sign up Successful");
            flag = true;
        } else {
            System.out.println("Sign up Failed");
        }

        return flag;
    }
}
