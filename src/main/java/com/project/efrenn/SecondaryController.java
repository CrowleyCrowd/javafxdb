package com.project.efrenn;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    /**
     * Let change of controller
     * @throws IOException
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}