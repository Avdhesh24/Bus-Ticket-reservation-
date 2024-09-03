package useCases;
import dao.AdminInterface;
import dao.AdminInterfaceImpl;

import java.util.Scanner;

public class ConfirmTicketsOfUser {
    public static void ConfirmTicketsOfUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Enter customer Id" );
        int Userid = sc.nextInt();

        AdminInterface dao = new AdminInterfaceImpl();

        String result = dao.updateTicket(Userid);
        System.out.println(result);
    }
}


