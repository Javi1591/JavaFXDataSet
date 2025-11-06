package chapter19;

public class Simpsons implements Measurable {
    private int episodeNumber;
    private String title;
    private int season;
    private double rating;
    private int votes;

    public Simpsons(int episodeNumber, String title, int season, double rating, int votes) {
        this.episodeNumber = episodeNumber;
        this.title = title;
        this.season = season;
        this.rating = rating;
        this.votes = votes;
    }

    @Override
    public int getMeasure() {
        return votes;
    }

    @Override
    public String toString() {
        return "Simpsons [Episode " + episodeNumber + ", Title=" + title + ", Season=" + season +
                ", Rating=" + rating + ", Votes=" + votes + "]";
    }
}
