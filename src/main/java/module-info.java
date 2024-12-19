module com.example.jvprod_3_5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.jvprod_3_5 to javafx.fxml;
    exports com.example.jvprod_3_5;
}