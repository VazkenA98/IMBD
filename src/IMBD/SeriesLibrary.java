package IMBD;

import Validate.Validate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class SeriesLibrary<K, V> implements DataRepository<K, V> {

    private K key;
    private V value;

    public static Series newSeries;


    private Scanner sc = new Scanner(System.in);


    public SeriesLibrary() {

    }

    private void addSerieTitle() {
        newSeries = new Series();
        System.out.println("enter Serie title");
        String serieTitle = sc.nextLine();
        newSeries.setSerieTitle(serieTitle);
    }

    private void addSerieDiscription() {
        System.out.println("enter serie discription");
        String serieDiscription = sc.nextLine();
        newSeries.setSerieDescription(serieDiscription);
    }

    private void addSerieRating() {
        System.out.println("enter serie rating");
        int serieRating = Validate.limitationOfRating(sc);
        newSeries.setSerieRating(serieRating);
    }

    private void addSeriePrimerDate() {
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
        newSeries.setSeriePremieredate(strDate);
    }

    private void seriesGenres() {
        System.out.println("type on of these");
        System.out.print("[");
        for (Genre s : Genre.values()) {
            System.out.print(s + ", ");
        }
        System.out.print("]");

    }

    private void addSerieGenre() {
        System.out.println("enter serie genre");
        seriesGenres();
        String genre = "";
        do {
            String serieGenre = sc.next();
            genre = serieGenre.toUpperCase();
        } while (Validate.readOnlyEnumClass(sc, genre));
        newSeries.setSerieGenre(Genre.valueOf(genre));
    }

    private void addSerieSeasons() {
        System.out.println("please enter how many Season to add");
        int seasonCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < seasonCount; i++) {
            System.out.println("enter season name");
            String seasonsName = sc.next();
            newSeries.setSeasons(seasonsName);
        }
    }

    private void addSerieEpisodes() {

        System.out.println("please enter how many Episodes to add");
        int episodCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < episodCount; i++) {
            System.out.println("enter episod name");
            String episodesName = sc.next();
            newSeries.setEpisods(episodesName);
        }
    }

    private void addSerieDirectors() {
        System.out.println("please enter how many directors to add");
        int directorsCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < directorsCount; i++) {
            System.out.println("enter directors name");
            String directorsName = sc.next();
            newSeries.setSeriesDirectors(directorsName);
        }
    }

    private void addSerieActors() {
        System.out.println("please enter how many actors to add");
        int actorsCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < actorsCount; i++) {
            System.out.println("enter actors name");
            String actorsName = sc.next();
            newSeries.setSeriesActors(actorsName);
        }
    }

    private void addSerieWritors() {
        System.out.println("please enter how many writors to add");
        int writorsCount = Validate.limitationOfStaff(sc);
        for (int i = 0; i < writorsCount; i++) {
            System.out.println("enter writors name");
            String writorsrsName = sc.next();
            newSeries.setSeriesWritors(writorsrsName);
        }
    }

    public void addSerie() {
        addSerieTitle();
        addSerieDiscription();
        addSerieRating();
        addSeriePrimerDate();
        addSerieGenre();
        addSerieSeasons();
        addSerieEpisodes();
        addSerieDirectors();
        addSerieActors();
        addSerieWritors();
        newSeries.getSerieTitle();
        // newMovie;
        System.out.println("new serie added");
        System.out.println(newSeries);

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
