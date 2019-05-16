package Access;

import FileDataBase.File;
import IMBD.DataRepository;
import IMBD.MovieLibrary;
import IMBD.SeriesLibrary;
import Validate.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class AdminControl {
    private Scanner sc = new Scanner(System.in);
    private Access ac = new Access();

    public AdminControl() throws ParseException, IOException, ClassNotFoundException {
        login();
    }

    private void menu() throws IOException, ClassNotFoundException, ParseException {
        System.out.println("1- add movie");
        System.out.println("2- add serie");
        System.out.println("3- back");
        int op = Validate.readOnlyIntegers(sc);

        switch (op) {
            case 1:
                addMovie();
                menu();
                break;
            case 2:
                addSerie();
                menu();
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

    private void login() throws ParseException, IOException, ClassNotFoundException {

        System.out.println("please enter admin username");
        String username = sc.next();
        System.out.println("please enter admin password");
        String pass = sc.next();
        if (username.equals("admin") && pass.equals("root")) {
            menu();
        } else {
            System.out.println("wrong inpute");
            login();
        }

    }

    private void addMovie() throws IOException {
        DataRepository<String, Object> p = new MovieLibrary<>();
        ((MovieLibrary<String, Object>) p).addMovie();
        p.put(((MovieLibrary<String, Object>) p).newMovie.getMovieTitle(), ((MovieLibrary<String, Object>) p).newMovie);
        File<Object> boxInteger = File.createAndPut(p.getValue());
        boxInteger.setToFile(p.getKey(), p.getValue());

    }

    private void addSerie() throws IOException {
        DataRepository<String, Object> p = new SeriesLibrary<>();
        ((SeriesLibrary<String, Object>) p).addSerie();
        p.put(((SeriesLibrary<String, Object>) p).newSeries.getSerieTitle(), ((SeriesLibrary<String, Object>) p).newSeries);
        File<Object> boxInteger = File.createAndPut(p.getValue());
        boxInteger.setToFile(p.getKey(), p.getValue());

    }
}
