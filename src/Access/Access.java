package Access;

import Validate.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Access {
    private Scanner sc = new Scanner(System.in);

    public Access() {

    }

    public void connect() throws IOException, ClassNotFoundException, ParseException {
        System.out.println("Are you user or admin ?");
        System.out.println("please enter following number");
        System.out.println("1- user");
        System.out.println("2- admin");
        int userId = Validate.readOnlyIntegers(sc);
        accessUser(userId).libraryOptions();
    }

    private Persone accessUser(int userId) throws IOException, ClassNotFoundException, ParseException {
        Persone persone = null;
        switch (userId) {
            case 1:
                persone = new User();
                break;
            case 2:
                persone = new Admin();
                break;
            default:
                System.out.println("we dont have that option");
                connect();
                break;
        }
        return persone;
    }

}
