import FileDataBase.File;
import IMBD.DataRepository;
import IMBD.MovieLibrary;

import java.io.IOException;

public class MainTest extends File {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

    testAddedMovieInfo();
    }

    private static void testAddedMovieInfo() throws IOException, ClassNotFoundException {

        DataRepository<String, Object> p = new MovieLibrary<>();
        ((MovieLibrary<String, Object>) p).addMovie();
        p.put(((MovieLibrary<String, Object>) p).newMovie.getMovieTitle(), ((MovieLibrary<String, Object>) p).newMovie);
        File<Object> boxInteger = File.createAndPut(p.getValue());
        boxInteger.setToFile(p.getKey(), p.getValue());

        assert p.getKey().equals(boxInteger.getMovieByNameToRate(p.getKey()).getMovieTitle()) : " yes";
        assert ((MovieLibrary<String, Object>) p).newMovie.getMovieDescription().equals(boxInteger.getMovieByNameToRate(p.getKey()).getMovieDescription()) : "yes";
        assert ((MovieLibrary<String, Object>) p).newMovie.getMovieRating() == (boxInteger.getMovieByNameToRate(p.getKey()).getMovieRating()) : "yes";
        assert ((MovieLibrary<String, Object>) p).newMovie.getMovieGenre().equals(boxInteger.getMovieByNameToRate(p.getKey()).getMovieGenre()) : "yes";
        assert ((MovieLibrary<String, Object>) p).newMovie.getMoviePremieredate().equals(boxInteger.getMovieByNameToRate(p.getKey()).getMoviePremieredate()) : "yes";
        assert ((MovieLibrary<String, Object>) p).newMovie.getMovieActors().equals(boxInteger.getMovieByNameToRate(p.getKey()).getMovieActors()) : "yes";
        assert ((MovieLibrary<String, Object>) p).newMovie.getMovieDirectors().equals(boxInteger.getMovieByNameToRate(p.getKey()).getMovieDirectors()) : "yes";
        assert ((MovieLibrary<String, Object>) p).newMovie.getMovieWritors().equals(boxInteger.getMovieByNameToRate(p.getKey()).getMovieWritors()) : "yes";

    }
}
