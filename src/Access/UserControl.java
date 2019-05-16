package Access;

import FileDataBase.AccountsFile;
import FileDataBase.File;
import IMBD.DataRepository;
import IMBD.MovieLibrary;
import IMBD.SeriesLibrary;
import Validate.Validate;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class UserControl extends File {
    private Scanner sc = new Scanner(System.in);
    private User user = new User();
    private AccountsFile af = new AccountsFile();
    private Access ac = new Access();


    public UserControl() throws IOException, ClassNotFoundException, ParseException {
        menu();
    }

    private void menu() throws IOException, ClassNotFoundException, ParseException {
        System.out.println("1- Register ?");
        System.out.println("2- login ?");
        System.out.println("3- back");
        int op = Validate.readOnlyIntegers(sc);
        switch (op) {
            case 1:
                resgister();
                break;
            case 2:
                login();
                break;
            case 3:
                ac.connect();
                break;
            default:
                System.out.println("we don have that option");
                menu();
                break;
        }
    }

    private void menuForControl() throws IOException, ClassNotFoundException, ParseException {
        System.out.println("1-search movie");
        System.out.println("2-search serie");
        System.out.println("3-rate movie");
        System.out.println("4-rate serie");
        System.out.println("5-search by date");
        System.out.println("6-back");
        int op = Validate.readOnlyIntegers(sc);
        ;
        switch (op) {
            case 1:
                searchMovie();
                menuForControl();
                break;
            case 2:
                serachSerie();
                menuForControl();
                break;
            case 3:
                rateMovie();
                menuForControl();
                break;
            case 4:
                rateSerie();
                menuForControl();
                break;
            case 5:
                serachByDate();
                menuForControl();
                break;
            case 6:
                menu();
                break;
            default:
                System.out.println("we don have that option");
                menuForControl();
                break;
        }
    }

    public void resgister() throws IOException {

        boolean resgister = true;
        do {
            System.out.println("please enter you username");
            String name = sc.next();
            user.setUsername(name);
            System.out.println("please enter you password");
            String pass = sc.next();
            user.setPassword(pass);
            if (af.checkForAccounts(name) == true) {
                System.out.println("this username has taken");
            } else {
                af.set(name, pass);
                resgister = false;
            }

        } while (resgister);


    }

    public void login() throws IOException, ClassNotFoundException, ParseException {
        System.out.println("please enter you username");
        String name = sc.next();

        System.out.println("please enter you password");
        String pass = sc.next();
        if (af.registerToFile(name, pass) == true) {
            menuForControl();
        } else {
            System.out.println("wrong username or password");
            menu();
        }

    }

    public void searchMovie() throws IOException, ClassNotFoundException {
        System.out.println("enter movie name");
        String movieName = sc.next();
        System.out.println(getMovieByName(movieName));
    }

    public void serachSerie() throws IOException, ClassNotFoundException {
        System.out.println("enter serie name");
        String serieName = sc.next();
        System.out.println(getSerieByName(serieName));
    }

    public void rateMovie() throws IOException, ClassNotFoundException {
        System.out.println("enter movie name");
        String movieName = sc.next();

        System.out.println("enter movie rate");
        int rate = sc.nextInt();

        System.out.println(getMovieByName(movieName));
        setMovieRate(movieName, rate);

    }

    public void rateSerie() throws IOException, ClassNotFoundException {
        System.out.println("enter serie name");
        String serieName = sc.next();
        System.out.println("enter serie rate");
        int rate = sc.nextInt();

        setSerieRate(serieName, rate);

    }

    public void serachByDate() throws ParseException, IOException, ClassNotFoundException {
        Calendar cal = Calendar.getInstance();
        System.out.println("enter day month year");
        System.out.println("day");
        int day = Validate.limitationOfDay(sc);
        System.out.println("month");
        int month = Validate.limitationOfMonth(sc);
        System.out.println("year");
        int year = Validate.limitationOfYear(sc);
        String fullInputDate = day + "/" + month + "/" + year;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse(fullInputDate);
        getAllByDate(date);


    }
}
