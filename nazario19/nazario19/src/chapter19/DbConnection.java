package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	public static boolean VerifyDBClassLoaded() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	public static Connection getConnection() {
		try {
			 System.out.println("Got here");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cop2251", "root", "sesame");
			 System.out.println("Database Connected");
			return conn;
		} catch (SQLException e) {
			return null;
		}
	}
	public static DataSetGeneric<Book> ReadFromDataBaseBooks() {
		try {
			DataSetGeneric<Book> books = new DataSetGeneric<>();
			Connection connection = DbConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from books");
			while (resultSet.next()) {
				String title = resultSet.getString(1);
				String author = resultSet.getString(2);
				String genre = resultSet.getString(3);
				String subgenre = resultSet.getString(4);
				int pages = Integer.parseInt(resultSet.getString(5));
				String publisher = resultSet.getString(6);
				Book book = new Book(title, author, genre, subgenre, pages, publisher);
				books.add(book);
			}
			connection.close();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static DataSetGeneric<Simpsons> ReadFromDataBaseSimpsons() {
	    try {
	        DataSetGeneric<Simpsons> simpsonsEpisodes = new DataSetGeneric<>();
	        Connection connection = DbConnection.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM simpsons");

	        while (resultSet.next()) {
	            int episodeNumber = resultSet.getInt("episodeNumber");
	            String title = resultSet.getString("title");
	            int season = resultSet.getInt("season");
	            double rating = resultSet.getDouble("rating");
	            int votes = resultSet.getInt("votes");

	            Simpsons episode = new Simpsons(episodeNumber, title, season, rating, votes);
	            simpsonsEpisodes.add(episode);
	        }
	        connection.close();
	        return simpsonsEpisodes;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public static DataSetGeneric<Movie> ReadFromDataBaseMovies() {
	    try {
	        DataSetGeneric<Movie> movies = new DataSetGeneric<>();
	        Connection connection = DbConnection.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM movies");

	        while (resultSet.next()) {
	            String name = resultSet.getString("name");
	            String rating = resultSet.getString("rating");
	            double score = resultSet.getDouble("score");
	            String star = resultSet.getString("star");
	            int votes = resultSet.getInt("votes");
	            int year = resultSet.getInt("year");

	            Movie movie = new Movie(name, rating, score, star, votes, year);
	            movies.add(movie);
	        }
	        connection.close();
	        return movies;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public static DataSetGeneric<TheOffice> ReadFromDataBaseTheOffice() {
	    try {
	        DataSetGeneric<TheOffice> episodes = new DataSetGeneric<>();
	        Connection connection = DbConnection.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM the_office");

	        while (resultSet.next()) {
	            int recordNumber = resultSet.getInt("recordNumber");
	            int season = resultSet.getInt("season");
	            String episodeTitle = resultSet.getString("episodeTitle");
	            String about = resultSet.getString("about");
	            double rating = resultSet.getDouble("rating");
	            int votes = resultSet.getInt("votes");
	            double viewership = resultSet.getDouble("viewerShip");
	            int duration = resultSet.getInt("duration");
	            String date = resultSet.getString("date");
	            String guestStars = resultSet.getString("guestStars");
	            String director = resultSet.getString("director");
	            String writer = resultSet.getString("writer");

	            TheOffice episode = new TheOffice(recordNumber, season, episodeTitle, about, rating, votes, viewership, duration, date, guestStars, director, writer);
	            episodes.add(episode);
	        }
	        connection.close();
	        return episodes;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
