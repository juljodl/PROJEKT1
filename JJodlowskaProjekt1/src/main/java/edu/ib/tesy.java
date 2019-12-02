package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class tesy {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> MetodaChoiceBox;

    @FXML
    private TextField OdlText;

    @FXML
    private TextField EksText;

    @FXML
    private TextField DoklText;

    @FXML
    private TextField czasText;

    @FXML
    private ScatterChart<?, ?> chartXY;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button btnRysuj;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSave;

    @FXML
    void onbtnClear(ActionEvent event) {

    }

    @FXML
    void onbtnRysuj(ActionEvent event) {

    }

    @FXML
    void onbtnSave(ActionEvent event) {

    }

    @FXML
    void onczasText(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert MetodaChoiceBox != null : "fx:id=\"MetodaChoiceBox\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert OdlText != null : "fx:id=\"OdlText\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert EksText != null : "fx:id=\"EksText\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert DoklText != null : "fx:id=\"DoklText\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert czasText != null : "fx:id=\"czasText\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert chartXY != null : "fx:id=\"chartXY\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert xAxis != null : "fx:id=\"xAxis\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert yAxis != null : "fx:id=\"yAxis\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert btnRysuj != null : "fx:id=\"btnRysuj\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";

    }
}

