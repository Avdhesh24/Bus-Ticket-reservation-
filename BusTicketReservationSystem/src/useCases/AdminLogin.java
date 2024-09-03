package useCases;
import java.util.Scanner;

public class AdminLogin {
    public static boolean adminLoginDetails() {
        Scanner sc = new Scanner(System.in);

            System.out.println("enter username");
            String username = sc.next();
            System.out.println("enter password");
            String password = sc.next();

        if (username.equals("Avdhesh") && password.equals("24062000")) {
            return true;
        } else {
            return false;
        }
    }

}
