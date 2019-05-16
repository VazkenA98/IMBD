package IMBD;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Series implements Serializable {
    private static final long serialVersionUID = 3202269712232916319L;
    private String serieTitle;
    private String serieDescription;
    private int serieRating;
    private String seriePremieredate;
    private Genre serieGenre;
    private String serieActor;
    private String serieDirector;
    private String serieWritor;
    private String serieSeason;
    private String serieEpisod;
    private HashSet<String> serieSeasons;
    private HashSet<String> serieEpisodes;
    private HashSet<String> serieActors;
    private HashSet<String> serieDirectors;
    private HashSet<String> serieWritors;
    private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    public Series() {
        this.serieSeasons = new HashSet<String>();
        this.serieEpisodes = new HashSet<String>();
        this.serieActors = new HashSet<String>();
        this.serieDirectors = new HashSet<String>();
        this.serieWritors = new HashSet<String>();
    }

    public Series(String title, String description,
                  int movieRating, String premieredate,
                  Genre genre, String serieSeason, String serieEpisod, String actor, String director, String writor) {
        this.serieTitle = title;
        this.serieDescription = description;
        this.serieRating = movieRating;
        this.seriePremieredate = premieredate;
        this.serieGenre = genre;
        this.serieActor = actor;
        this.serieDirector = director;
        this.serieWritor = writor;
        this.serieEpisod = serieEpisod;
        this.serieSeason = serieSeason;
        this.serieSeasons = new HashSet<String>();
        this.serieEpisodes = new HashSet<String>();
        this.serieActors = new HashSet<String>();
        this.serieDirectors = new HashSet<String>();
        this.serieWritors = new HashSet<String>();
        splitForHashSet(serieSeason, serieEpisod, actor, director, writor);

    }

    public void splitForHashSet(String serieSeason, String serieEpisod, String serieActor, String serieDirector, String serieWritor) {
        String[] wordSerieSeasons = serieSeason.split(",");
        String[] wordSerieEpisodes = serieEpisod.split(",");
        String[] wordSerieActors = serieActor.split(",");
        String[] wordSerieDirectors = serieDirector.split(",");
        String[] wordSerieWritors = serieWritor.split(",");
        for (String w : wordSerieSeasons) {
            serieSeasons.add(w);
        }
        for (String w : wordSerieEpisodes) {
            serieEpisodes.add(w);
        }
        for (String w : wordSerieActors) {
            serieActors.add(w);
        }
        for (String w : wordSerieDirectors) {
            serieDirectors.add(w);
        }
        for (String w : wordSerieWritors) {
            serieWritors.add(w);
        }

    }

    public String getSerieTitle() {
        return serieTitle;
    }

    public void setSerieTitle(String serieTitle) {
        this.serieTitle = serieTitle;
    }

    public String getSerieDescription() {
        return serieDescription;
    }

    public void setSerieDescription(String serieDescription) {
        this.serieDescription = serieDescription;
    }

    public int getSerieRating() {
        return serieRating;
    }

    public void setSerieRating(int serieRating) {
        this.serieRating = serieRating;
    }

    public String getSeriePremieredate() {
        return seriePremieredate;
    }

    public void setSeriePremieredate(String seriePremieredate) {
        this.seriePremieredate = seriePremieredate;
    }

    public Genre getSerieGenre() {
        return serieGenre;
    }

    public void setSerieGenre(Genre serieGenre) {
        this.serieGenre = serieGenre;
    }

    public String getSerieActor() {
        return serieActor;
    }

    public void setSerieActor(String serieActor) {
        this.serieActor = serieActor;
    }

    public String getSerieDirector() {
        return serieDirector;
    }

    public void setSerieDirector(String serieDirector) {
        this.serieDirector = serieDirector;
    }

    public String getSerieWritor() {
        return serieWritor;
    }

    public void setSerieWritor(String serieWritor) {
        this.serieWritor = serieWritor;
    }

    public String getSerieSeason() {
        return serieSeason;
    }

    public void setSerieSeason(String serieSeason) {
        this.serieSeason = serieSeason;
    }

    public String getSerieEpisod() {
        return serieEpisod;
    }

    public void setSerieEpisod(String serieEpisod) {
        this.serieEpisod = serieEpisod;
    }

    public HashSet<String> getSeriesSeasons() {
        return serieSeasons;
    }

    public void setSeasons(String serieSeason) {
        this.serieSeason = serieSeason;
        serieSeasons.add(serieSeason);
    }

    public HashSet<String> getSeriesEpisodes() {
        return serieEpisodes;
    }

    public void setEpisods(String serieEpisod) {
        this.serieEpisod = serieEpisod;
        serieEpisodes.add(serieEpisod);
    }

    public HashSet<String> getSeriesActors() {
        return serieActors;
    }

    public void setSeriesActors(String serieActor) {
        this.serieActor = serieActor;
        serieActors.add(serieActor);
    }

    public HashSet<String> getSeriesDirectors() {
        return serieDirectors;
    }

    public void setSeriesDirectors(String serieDirector) {
        this.serieDirector = serieDirector;
        serieDirectors.add(serieDirector);
    }

    public HashSet<String> getSeriesWritors() {
        return serieWritors;
    }

    public void setSeriesWritors(String serieWritor) {
        this.serieWritor = serieWritor;
        serieWritors.add(serieWritor);
    }

    public int getSeasonsSize() {
        return serieSeasons.size();
    }


    @Override
    public String toString() {
        return "Serie{" +
                "title='" + serieTitle + "\n" +
                ", description='" + serieDescription + "\n" +
                ", movieRating=" + serieRating + "\n" +
                ", premieredate='" + seriePremieredate + "\n" +
                ", genre=" + serieGenre + "\n" +
                ", Seasons=" + serieSeasons + "\n" +
                ", Episodes=" + serieEpisodes + "\n" +
                ", directors=" + serieDirectors + "\n" +
                ", actors=" + serieActors + "\n" +
                ", writors=" + serieWritors + "\n" +
                '}';
    }
}


