import Access.Access;
import FileDataBase.File;
import Validate.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class IMDBMainPage {
    private Scanner sc = new Scanner(System.in);
    private File<Object> f = new File<>();
    private Access ac = new Access();


    public IMDBMainPage() throws ParseException, IOException, ClassNotFoundException {
        System.out.println("welcome to IMDB");

    }

    public void imdbPage() throws ParseException, IOException, ClassNotFoundException {
        switch (menu()) {
            case 1:
                f.getAllIMBDElements();
                imdbPage();
                break;
            case 2:
                imdbAccountPage();
                imdbPage();
                break;
            case 3:
                System.out.println("good bye");
                System.exit(0);
                break;
            default:
                System.out.println("we don't have that option re-enter please");
                imdbPage();
                break;
        }
    }

    private int menu() {
        System.out.println("please enter following number");
        System.out.println("1- see all IMBD Movies and Series");
        System.out.println("2- login or create acount");
        System.out.println("3- Exit page");
        int choise = Validate.readOnlyIntegers(sc);
        return choise;
    }

    private void imdbAccountPage() throws ParseException, IOException, ClassNotFoundException {
        ac.connect();
    }

}
