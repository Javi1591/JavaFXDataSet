package chapter19;

public class TheOffice implements Measurable  {
	private int recordNumber;
	private int season;
	private String episodeTitle;
	private String about;
	private double rating;
	private int votes;
	private double viewerShip;
	private int duration;
	private String date;
	private String guestStars;
	private String director;
	private String writer;
	
	public TheOffice(int recordNumber, int season, String episodeTitle, String about, double rating, int votes,
			double viewerShip, int duration, String date, String guestStars, String director, String writer) {
		this.recordNumber = recordNumber;
		this.season = season;
		this.episodeTitle = episodeTitle;
		this.about = about;
		this.rating = rating;
		this.votes = votes;
		this.viewerShip = viewerShip;
		this.duration = duration;
		this.date = date;
		this.guestStars = guestStars;
		this.director = director;
		this.writer = writer;
	}

	public int getRecordNumber() {
		return recordNumber;
	}


	@Override
	public String toString() {
		return "TheOffice [recordNumber=" + recordNumber + ", season=" + season + ", episodeTitle=" + episodeTitle
				+ ", about=" + about + ", rating=" + rating + ", votes=" + votes + ", viewerShip=" + viewerShip
				+ ", duration=" + duration + ", date=" + date + ", guestStars=" + guestStars + ", director=" + director
				+ ", writer=" + writer + "]";
	}

	@Override
	public int getMeasure() {
		return votes;
	}
}
