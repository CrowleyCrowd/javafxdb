module com.project.efrenn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.project.efrenn to javafx.fxml;

    exports com.project.efrenn;

    opens com.project.models;

    exports com.project.models;

    opens com.project.dbhandler;

    exports com.project.dbhandler;
}
