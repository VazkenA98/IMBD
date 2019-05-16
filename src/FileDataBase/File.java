package FileDataBase;

import IMBD.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

public class File<V> implements Serializable {
    private static final long serialVersionUID = 3202269712232916319L;
    private AccountsFile aff = new AccountsFile();
    private V object;
    private java.io.File file;

    public void put(V object) {
        this.object = object;
    }

    public V pick() {
        return object;
    }

    public static <E> File<E> createAndPut(Object e) {
        File<E> box = new File<>();
        box.put((E) e);
        return box;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public static Object fromString(String s) throws IOException,
            ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /**
     * Write the object to a Base64 string.
     */
    public static String toString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    ///////////////////////////////////////////////////////////////////////////////
    public void setToFile(String key, Object value) throws IOException {

        try {

            String content = key + " (" + value.getClass() + ")" + "-" + toString((Serializable) value);
            file = new java.io.File("VideoLibrary.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (!file.exists()) {
                file.createNewFile();
            }

            bw.write(content);
            bw.newLine();
            bw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateFile(String key) throws IOException {

        try {

            String content = key;
            file = new java.io.File("VideoLibrary.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (!file.exists()) {
                file.createNewFile();
            }

            bw.write(content);
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getFromFile(String key) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(key)) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Object some = (Object) fromString(obj);
                System.out.println(some);
            }
        }
    }

    public void getAllMovies() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("(class IMBD.Movies)")) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Movies some = (Movies) fromString(obj);
                System.out.println(some);
            }
        }
    }

    public void getAllSeries() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("IMBD.Series")) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Object some = (Object) fromString(obj);
                System.out.println(some);
            }
        }
    }

    public void getAllIMBDElements() throws IOException, ClassNotFoundException {
        getAllMovies();
        getAllSeries();
    }

    public Movies getMovieByName(String movieName) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        Movies specialMovie = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("(class IMBD.Movies)") && line.contains(movieName)) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Movies some = (Movies) fromString(obj);
                specialMovie = some;
            }
        }
        if (specialMovie == null) {
            System.out.println("we dont have movie such a name " + movieName);
        }
        return specialMovie;
    }

    public Series getSerieByName(String serieName) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        Series specialSerie = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("(class IMBD.Series)") && line.contains(serieName)) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Series some = (Series) fromString(obj);
                specialSerie = some;
            }
        }
        if (specialSerie == null) {
            System.out.println("we dont have serie such a name " + serieName);
        }
        return specialSerie;
    }

    public void getMoviesByDate(Date d) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("(class IMBD.Movies)")) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Movies some = (Movies) fromString(obj);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(some.getMoviePremieredate());
                long diff = d.getTime() - date.getTime();
                long diffDays = diff / (24 * 60 * 60 * 1000);
                if (diffDays >= 0) {
                    System.out.println(some);
                }

            }
        }
    }

    public void getSeriesByDate(Date d) throws IOException, ParseException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("(class IMBD.Series)")) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Series some2 = (Series) fromString(obj);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(some2.getSeriePremieredate());
                long diff = d.getTime() - date.getTime();
                long diffDays = diff / (24 * 60 * 60 * 1000);
                if (diffDays >= 0) {
                    System.out.println(some2);
                }

            }
        }
    }

    public void getAllByDate(Date d) throws ParseException, IOException, ClassNotFoundException {
        getMoviesByDate(d);
        getSeriesByDate(d);

    }

    public Movies getMovieByNameToRate(String movieName) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        Movies specialMovie = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("(class IMBD.Movies)") && line.contains(movieName)) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Movies some = (Movies) fromString(obj);
                specialMovie = some;
            }
        }
        if (specialMovie == null) {
            System.out.println("we dont have movie such a name " + movieName);
        }
        return specialMovie;
    }

    public void setMovieRate(String title, int newRate) throws IOException, ClassNotFoundException {

        Movies m = getMovieByNameToRate(title);
        m.setMovieRating(newRate);
        DataRepository<String, Object> p = new MovieLibrary<>();
        p.put(m.getMovieTitle(), m);
        File<Object> boxInteger = File.createAndPut(p.getValue());
        boxInteger.setToFile(p.getKey(), p.getValue());
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        String str = title + " (class IMBD.Movies)-" + toString(getMovieByNameToRate(title));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(title)) {
                list.remove(i);
                i = list.size();
            }
        }
        deleteAndCreate(list);
    }


    public Series getSerieByNameToRate(String serieName) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        Series specialSerie = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("(class IMBD.Series)") && line.contains(serieName)) {
                String obj = line.substring(line.indexOf("-") + 1, line.length());
                Series some = (Series) fromString(obj);
                specialSerie = some;
            }
        }
        if (specialSerie == null) {
            System.out.println("we dont have serie such a name " + serieName);
        }
        return specialSerie;
    }

    public void setSerieRate(String title, int newRate) throws IOException, ClassNotFoundException {

        Series m = getSerieByNameToRate(title);
        m.setSerieRating(newRate);
        DataRepository<String, Object> p = new SeriesLibrary<>();
        p.put(m.getSerieTitle(), m);
        File<Object> boxInteger = File.createAndPut(p.getValue());
        boxInteger.setToFile(p.getKey(), p.getValue());
        Scanner scanner = new Scanner(new java.io.File("VideoLibrary.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        String str = title + " (class IMBD.Series)-" + toString(getSerieByNameToRate(title));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(title)) {
                list.remove(i);
                i = list.size();
            }
        }
        deleteAndCreate(list);
    }

    public void deleteAndCreate(ArrayList<String> list) throws IOException {
        file = new java.io.File("VideoLibrary.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());

        try {
            file.delete();
            file.createNewFile();



        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            updateFile(list.get(i));
        }
    }


}
