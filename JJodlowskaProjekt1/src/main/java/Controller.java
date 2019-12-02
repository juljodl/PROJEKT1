import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.ib.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> MetodaChoiceBox;
    private ObservableList<String> listaMetod= FXCollections.observableArrayList("Bisekcja","MetodaFalsi","PktStaly","Sieczne","Styczne");


    @FXML
    private TextField OdlText;

    @FXML
    private TextField czasText;

    @FXML
    private TextField EksText;

    @FXML
    private TextField DoklText;

    @FXML
    private ScatterChart<Number, Number> chartXY;

    @FXML
    private NumberAxis xAxisx;

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
       chartXY.getData().clear();



    }

    @FXML
    void onczasText(ActionEvent event) {

    }
    @FXML
    private TextField nazwaPliku;

    @FXML
    void onNazwaPliku(ActionEvent event) {

    }

    @FXML
    void onbtnRysuj(ActionEvent event)
    {
        Double a=Double.valueOf(OdlText.getText());
        Double e=Double.valueOf(EksText.getText());
        Double ea2=Double.valueOf(DoklText.getText());
        Double T=Double.valueOf(czasText.getText());
        String metoda=MetodaChoiceBox.getSelectionModel().getSelectedItem();
        ArrayList<double[]> wyniki=new ArrayList<>();

        switch (metoda)
        {
            case "Bisekcja":
                Bisekcja bisekcja=new Bisekcja(0,ea2,e,a,T,new Funkcje(),2*Math.PI);
                wyniki=bisekcja.trajektoria();
                break;
            case "MetodaFalsi":
                MetodaFalsi metodaFalsi=new MetodaFalsi(0,ea2,e,a,T,new Funkcje(),2*Math.PI);
                wyniki=metodaFalsi.trajektoria();
                break;
            case "PktStaly":
                PktStaly pktStaly=new PktStaly(0.5,ea2,e,a,T,new Funkcje());
                wyniki=pktStaly.trajektoria();
                break;
            case "Sieczne":
                Sieczne sieczne=new Sieczne(Math.PI/2,ea2,e,a,T, new Funkcje(),0);
                wyniki=sieczne.trajektoria();
                break;
            case "Styczne":
                Styczne styczne=new Styczne(0, ea2,e,a,T,new Funkcje());
                wyniki=styczne.trajektoria();
        }

        XYChart.Series series= new XYChart.Series();
        for (int i = 0; i <wyniki.size() ; i++)
        {
            series.getData().add(new XYChart.Data(wyniki.get(i)[0],wyniki.get(i)[1]));
        }
            chartXY.getData().addAll(series);


    }

    @FXML
    void onbtnSave(ActionEvent event) {
        Double T = Double.valueOf(czasText.getText());
        double x;
        double y;
        String fileName = "src/test/resources/" + nazwaPliku.getText() + ".txt";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int i = 1; i <= T; i++) {
                fileWriter.write(xAxisx.getValueForDisplay(i) + "\t" + yAxis.getValueForDisplay(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        @FXML
    void initialize() {
        assert MetodaChoiceBox != null : "fx:id=\"MetodaChoiceBox\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert OdlText != null : "fx:id=\"OdlText\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert EksText != null : "fx:id=\"EksText\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert DoklText != null : "fx:id=\"DoklText\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert chartXY != null : "fx:id=\"chartXY\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert xAxisx != null : "fx:id=\"xAxis\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert yAxis != null : "fx:id=\"yAxis\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert btnRysuj != null : "fx:id=\"btnRysuj\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'trajektoriaFX.fxml'.";
        MetodaChoiceBox.setItems(listaMetod);

    }




}
