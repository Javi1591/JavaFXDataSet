package chapter19;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DataSetGenericFX extends Application {

	DataSetGeneric<Book> books = new DataSetGeneric<>();
	DataSetGeneric<TheOffice> episodes = new DataSetGeneric<>();
	DataSetGeneric<Simpsons> simpsonsEpisodes = new DataSetGeneric<>();
	DataSetGeneric<Movie> movies = new DataSetGeneric<>();

	public void start(Stage primaryStage) {

		TextArea textArea = new TextArea();
		textArea.setWrapText(true);
		Button btLoadShowBooks = new Button("Load/Show Books");
		Button btLoadShowMovies = new Button("Load/Show Movies");
		Button btLoadShowTheOffice = new Button("Load/Show 'The Office'");
		Button btLoadShowSimpsons = new Button("Load/Show 'Simpsons'");

		HBox hBoxTop = new HBox(btLoadShowBooks, btLoadShowMovies, btLoadShowTheOffice, btLoadShowSimpsons);
		hBoxTop.setSpacing(10);
		hBoxTop.setAlignment(Pos.CENTER);
		hBoxTop.setPadding(new Insets(5, 5, 5, 5));

		Button btShowMinMaxBook = new Button("Min/Max Book");
		Button btShowMinMaxMovie = new Button("Min/Max Movie");
		Button btShowMinMaxTheOffice = new Button("Min/Max 'The Office'");
		Button btShowMinMaxSimpsons = new Button("Min/Max 'Simpsons'");

		Button btClearAnswers = new Button("Clear");
		Button btnExit = new Button("Exit");
		HBox hBoxBottom = new HBox(btShowMinMaxBook, btShowMinMaxMovie, btShowMinMaxTheOffice, btShowMinMaxSimpsons,
				btClearAnswers, btnExit);
		hBoxBottom.setSpacing(10);
		hBoxBottom.setAlignment(Pos.CENTER);
		hBoxBottom.setPadding(new Insets(5, 5, 5, 5));

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(hBoxTop);
		borderPane.setBottom(hBoxBottom);
		borderPane.setCenter(textArea);

		btLoadShowBooks.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String output = "";
				books = DbConnection.ReadFromDataBaseBooks();
				if (books.size() > 0) {
					output = "books loaded - " + books.size() + "\n";
				} else {
					output = "failure loading books \n";
				}
				for (Book book : books) {
					output += book + "\n";
				}
				textArea.setText(output);
			}
		});
		btLoadShowMovies.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				 String output = "";
				 DataSetGeneric<Movie> movies = DbConnection.ReadFromDataBaseMovies();
				 if (movies.size() > 0) {
					 output = "Movies loaded - " + movies.size() + "\n";
					 for (Movie movie : movies) {
						 output += movie + "\n";
					 }
				 } else {
					 output = "Failure loading movies\n";
				 }
				 textArea.setText(output);
				 }
			 });

		btLoadShowTheOffice.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String output = "";
				DataSetGeneric<TheOffice> episodes = DbConnection.ReadFromDataBaseTheOffice();
			    if (episodes.size() > 0) {
			        output = "Episodes loaded - " + episodes.size() + "\n";
			        for (TheOffice episode : episodes) {
			            output += episode + "\n";
			        }
			    } else {
			        output = "Failure loading 'The Office' episodes\n";
			    }
				textArea.setText(output);
				}
			});

		btLoadShowSimpsons.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String output = "";
				DataSetGeneric<Simpsons> simpsonsEpisodes = DbConnection.ReadFromDataBaseSimpsons();
			    if (simpsonsEpisodes.size() > 0) {
			        output = "Simpsons episodes loaded - " + simpsonsEpisodes.size() + "\n";
			        for (Simpsons episode : simpsonsEpisodes) {
			            output += episode + "\n";
			        }
			    } else {
			        output = "Failure loading 'Simpsons' episodes\n";
			    }
				textArea.setText(output);
			}
		});

		btShowMinMaxBook.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String output = "";
				textArea.setText(output);
			}
		});

		btShowMinMaxMovie.setOnAction(e -> {
		    if (movies.size() > 0) {
		        textArea.setText("Min Movie: " + movies.getMin() + "\nMax Movie: " + movies.getMax());
		    } else {
		        textArea.setText("No movies loaded.");
		    }
		});


		btShowMinMaxTheOffice.setOnAction(e -> {
		    if (episodes.size() > 0) {
		        textArea.setText("Min Episode: " + episodes.getMin() + "\nMax Episode: " + episodes.getMax());
		    } else {
		        textArea.setText("No episodes loaded.");
		    }
		});


		btShowMinMaxSimpsons.setOnAction(e -> {
		    if (simpsonsEpisodes.size() > 0) {
		        textArea.setText("Min Simpsons Episode: " + simpsonsEpisodes.getMin() + 
		                         "\nMax Simpsons Episode: " + simpsonsEpisodes.getMax());
		    } else {
		        textArea.setText("No Simpsons episodes loaded.");
		    }
		});


		btClearAnswers.setOnAction(new EventHandler<ActionEvent>() {
			@Override // Override the handle method
			public void handle(ActionEvent e) {
				textArea.setText("");
			}
		});

		btnExit.setOnAction(e -> {
			System.exit(0);
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 750, 400);
		primaryStage.setTitle("Generic Data Set");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Image myIcon = new Image(getClass().getResourceAsStream("SP_icon.png"));
		primaryStage.getIcons().add(myIcon);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}