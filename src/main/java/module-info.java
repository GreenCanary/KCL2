module com.mike.kcl2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.prefs;

    opens com.mike.kcl2 to javafx.fxml;
    exports com.mike.kcl2;
}