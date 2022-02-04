package mp3.uf5.dam.tutorialfxml.control;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class MovieGraphController {


    @FXML BarChart bchartPop;
    @FXML CategoryAxis xAxis;
    @FXML NumberAxis yAxis;

    XYChart.Series<String,Integer> dataSeries1 = new XYChart.Series();
    XYChart.Series<String,Integer> dataSeries2 = new XYChart.Series();
    XYChart.Series<String,Integer> dataSeries3 = new XYChart.Series();

    public MovieGraphController() {
    }

    @FXML
    private void initialize() {

        xAxis.setLabel("dia");
        yAxis.setLabel("precipitació");

        dataSeries1.setName("00:00");
        dataSeries1.getData().add(new XYChart.Data<String,Integer>("dia1",10));
        dataSeries1.getData().add(new XYChart.Data<String,Integer>("dia2",5));
        dataSeries1.getData().add(new XYChart.Data<String,Integer>("dia3",5));
        bchartPop.getData().add(dataSeries1);

        dataSeries2.setName("12:00");
        dataSeries2.getData().add(new XYChart.Data<String,Integer>("dia1",6));
        dataSeries2.getData().add(new XYChart.Data<String,Integer>("dia2",7));
        dataSeries2.getData().add(new XYChart.Data<String,Integer>("dia3",8));
        bchartPop.getData().add(dataSeries2);

        dataSeries3.setName("18:00");
        dataSeries3.getData().add(new XYChart.Data<String,Integer>("dia1",15));
        bchartPop.getData().add(dataSeries3);

    }


}
