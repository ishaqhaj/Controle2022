module com.controle {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.controle to javafx.fxml; // Allows FXMLLoader to access classes in com.controle
    opens com.controle.Controllers to javafx.fxml; // Specifically opens the Controllers package
    exports com.controle;
}
