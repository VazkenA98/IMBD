package IMBD;

import Validate.Validate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MovieLibrary<K, V> implements DataRepository<K, V> {

    private K key;
    private V value;

    public static Movies newMovie;


    private Scanner sc = new Scanner(System.in);


    public MovieLibrary() {

    }

    private void addMovieTitle() {
        newMovie = new Movies();
        System.out.println("enter movie title");
        String movieTitle = sc.nextLine();
        newMovie.setMovieTitle(movieTitle);
    }

    private void addMovieDiscription() {
        System.out.println("enter movie discription");
        String movieDiscription = sc.nextLine();
        newMovie.setMovieDescription(movieDiscription);
    }

    private void addMovieRating() {
        System.out.println("enter movie rating");
        int movieRating = Validate.limitationOfRating(sc);
        newMovie.setMovieRating(movieRating);
    }

    private void addMoviePrimerDate() {
        Calendar cal = Calendar.getInstance();
        System.out.println("enter day month year");
        System.out.println("day");
        int day = Validate.limitationOfDay(sc);
        System.out.println("month");
        int month = Validate.limitationOfMonth(sc);
        System.out.println("year");
        int year = Validate.limitationOfYear(sc);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DATE, day);
        Date d = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(d);
        newMovie.setMoviePremieredate(strDate);
    }

    private void movieGenres() {
        System.out.println("type on of these");
        System.out.print("[");
        for (Genre s : Genre.values()) {
            System.out.print(s + ", ");
        }
        System.out.print("]");

    }

    private void addMovieGenre() {
        System.out.println("enter movie genre");
        movieGenres();
        String genre = "";
        do {
            String movieGenre = sc.next();
            genre = movieGenre.toUpperCase();
        } while (Validate.readOnlyEnumClass(sc, genre));
        newMovie.setMovieGenre(Genre.valueOf(genre));
    }

    private void addMovieDirectors() {
        System.out.println("please enter how many directors to add");
        int directorsCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < directorsCount; i++) {
            System.out.println("enter directors name");
            String directorsName = sc.next();
            newMovie.setDirector(directorsName);
        }
    }

    private void addMovieActors() {
        System.out.println("please enter how many actors to add");
        int actorsCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < actorsCount; i++) {
            System.out.println("enter actors name");
            String actorsName = sc.next();
            newMovie.setActor(actorsName);
        }
    }

    private void addMovieWritors() {
        System.out.println("please enter how many writors to add");
        int writorsCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < writorsCount; i++) {
            System.out.println("enter writors name");
            String writorsrsName = sc.next();
            newMovie.setMovieWritors(writorsrsName);
        }
    }

    public void addMovie() {
        addMovieTitle();
        addMovieDiscription();
        addMovieRating();
        addMoviePrimerDate();
        addMovieGenre();
        addMovieDirectors();
        addMovieActors();
        addMovieWritors();
        newMovie.getMovieTitle();
        System.out.println("new movie added");
        System.out.println(newMovie);

    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;

    }
}

