module org.example.junittesting4t {

    exports Hotel;
    exports User;

    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    exports examples;
    opens examples to javafx.fxml;
}