module chapter19 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens chapter19 to javafx.fxml;
    exports chapter19;
}
