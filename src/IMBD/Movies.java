package IMBD;


import java.io.Serializable;
import java.util.HashSet;

public class Movies implements Serializable {
    private String movieTitle;
    private String movieDescription;
    private int movieRating;
    private String moviePremieredate;
    private Genre movieGenre;
    private String movieActor;
    private String movieDirector;
    private String movieWritor;
    private HashSet<String> movieActors;
    private HashSet<String> movieDirectors;
    private HashSet<String> movieWritors;


    public Movies() {
        this.movieActors = new HashSet<String>();
        this.movieDirectors = new HashSet<String>();
        this.movieWritors = new HashSet<String>();
    }

    public Movies(String title, String description,
                  int movieRating, String premieredate,
                  Genre genre, String actor, String director, String writor) {
        this.movieTitle = title;
        this.movieDescription = description;
        this.movieRating = movieRating;
        this.moviePremieredate = premieredate;
        this.movieGenre = genre;
        this.movieActor = actor;
        this.movieDirector = director;
        this.movieWritor = writor;
        this.movieActors = new HashSet<String>();
        this.movieDirectors = new HashSet<String>();
        this.movieWritors = new HashSet<String>();
        splitForHashSet(actor, director, writor);
    }

    public void splitForHashSet(String movieActor, String movieDirector, String movieWritor) {
        String[] wordsActors = movieActor.split(",");
        String[] wordsDirectors = movieDirector.split(",");
        String[] wordsWtitors = movieWritor.split(",");
        for (String w : wordsActors) {
            movieActors.add(w);
        }
        for (String w : wordsDirectors) {
            movieDirectors.add(w);
        }
        for (String w : wordsWtitors) {
            movieWritors.add(w);
        }

    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public String getMoviePremieredate() {
        return moviePremieredate;
    }

    public void setMoviePremieredate(String moviePremieredate) {

        this.moviePremieredate = moviePremieredate;
    }

    public Genre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(Genre movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieWritor() {
        return movieWritor;
    }

    public void setMovieWritor(String movieWritor) {
        this.movieWritor = movieWritor;
    }

    public HashSet<String> getMovieActors() {
        return movieActors;
    }

    public void setActor(String movieActor) {
        this.movieActor = movieActor;
        movieActors.add(movieActor);
    }

    public HashSet<String> getMovieDirectors() {
        return movieDirectors;
    }

    public void setDirector(String movieDirector) {
        this.movieDirector = movieDirector;
        movieDirectors.add(movieDirector);
    }

    public HashSet<String> getMovieWritors() {
        return movieWritors;
    }

    public void setMovieWritors(String movieWritor) {
        this.movieWritor = movieWritor;
        movieWritors.add(movieWritor);
    }


    @Override
    public String toString() {
        return "Movies{" +
                "title='" + movieTitle + "\n" +
                ", description='" + movieDescription + "\n" +
                ", movieRating=" + movieRating + "\n" +
                ", premieredate='" + moviePremieredate + "\n" +
                ", genre=" + movieGenre + "\n" +
                ", actors=" + movieActors + "\n" +
                ", directors=" + movieDirectors + "\n" +
                ", writors=" + movieWritors + "\n" +
                '}';
    }
}
