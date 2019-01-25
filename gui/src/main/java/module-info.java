module gui {
    requires logic;
    requires javafx.controls;
    requires javafx.fxml;

    opens daxtery.gui to javafx.fxml, javafx.graphics;

}