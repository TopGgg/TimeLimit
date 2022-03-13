module net.adarw.timelimit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens net.adarw.timelimit to javafx.fxml;
    exports net.adarw.timelimit;
}