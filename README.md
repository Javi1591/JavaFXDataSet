# COP2251 – Java Assignment 19

## Summary
This advanced JavaFX assignment demonstrates graphical user interface design, database interaction, generics, and polymorphism. The project integrates multiple concepts — custom interfaces, measurable data classes, and reusable dataset utilities — to display and analyze structured data (books, movies, and TV shows) from a database within a JavaFX application.

## Program Behavior
- Measurable  
  - Defines an interface requiring `getMeasure()` so objects can be compared quantitatively (e.g., by pages, ratings, or runtime).

- Book / Movie / TheOffice / Simpsons  
  - Implement `Measurable`, representing different media categories.  
  - Provide attributes such as title, author, genre, and other descriptive fields.  
  - Override `getMeasure()` to return a numeric measure relevant to the object (like pages or episode counts).

- DataSetGeneric  
  - A generic class to calculate aggregate data such as average, minimum, and maximum measurements for any type implementing `Measurable`.

- DataSetGenericFX  
  - The JavaFX front-end controller that integrates buttons and labels for displaying loaded data.  
  - Allows users to load datasets (e.g., books, movies, “The Office,” and “Simpsons” data) from the database and view computed statistics interactively.  
  - Implements event-driven behavior through JavaFX button actions.

- DbConnection  
  - Manages SQL connection setup to a local MySQL database (e.g., `root` / `tiger` credentials).  
  - Contains methods like `ReadFromDataBaseMovies()` and `ReadFromDataBaseTheOffice()` to populate data objects and return results for UI display.

- application.css  
  - Defines the JavaFX stylesheet for consistent UI appearance and layout.

## Key Concepts Demonstrated
- JavaFX GUI: Event-driven programming with FXML, CSS styling, and interactive components.  
- Interfaces & Polymorphism: Using `Measurable` to enforce common structure across diverse object types.  
- Generics: The `DataSetGeneric` class supports reusable computations for any measurable type.  
- Database Connectivity: Establishing and querying MySQL databases with JDBC.  
- Data Aggregation: Computing averages, minimums, and maximums dynamically based on interface-defined measures.  
- Modular Design: Separate source modules and packages organized under `chapter19`.

## How to Compile and Run
Requirements:
- JavaFX SDK and Java Development Kit (JDK) 17 or later  
- MySQL Server (local instance with schema configured for books, movies, and TV shows)  
- IDE (IntelliJ IDEA, Eclipse, or VS Code) with JavaFX module setup

Commands (from the `nazario19/src` directory):
javac -d ../out module-info.java chapter19/*.java  
java --module-path "<path_to_javafx_lib>" --add-modules javafx.controls,javafx.fxml -cp ../out chapter19.DataSetGenericFX
