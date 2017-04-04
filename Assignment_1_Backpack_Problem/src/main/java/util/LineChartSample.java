package util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import model.BackpackProblem;
import service.RandomSearch;
 
 
public class LineChartSample extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Assignment 1 -> DISI, @Author = Beniamin Scridon");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Iteration");
        yAxis.setLabel("Backpack value");
        //creating the chart
        final AreaChart<Number,Number> lineChart = 
                new AreaChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Random Search, 20 objects");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio??");
        
        
        RandomSearch randomSearch= new RandomSearch();
        
        
        //populating the series with data
        int i = 1;
		while (i <= 10) {
			BackpackProblem problem = util.FileReader
					.readFromFile("src/main/resources/input/rucsac-20.txt");
            double value=randomSearch.computeSolution(problem).getValue();
			System.out.println("value:"+value);
			
			 series.getData().add(new XYChart.Data(i,value));
			 i++;
		}
        
   /*     series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));*/
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}