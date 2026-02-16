package com.wallet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class JavaFXController {

    @FXML
    private Label statusLabel;

    @FXML
    protected void onHelloButtonClick() {
        statusLabel.setText("Saldo: 1,24 BTC - Pobrane z bazy!");
    }
}
