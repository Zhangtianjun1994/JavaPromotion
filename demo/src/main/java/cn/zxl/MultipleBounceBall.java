package cn.zxl;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MultipleBounceBall extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MultipleBallPane ballPane = new MultipleBallPane();
		ballPane.setStyle("-fx-border-color:yellow");
		Button btAdd = new Button("+");
		Button btSubtract = new Button("-");
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(btAdd,btSubtract);
		hBox.setAlignment(Pos.CENTER);
		btAdd.setOnAction(e -> ballPane.add());
		btSubtract.setOnAction(e->ballPane.subtract());
		
		ballPane.setOnMousePressed(e->ballPane.pause());
		ballPane.setOnMouseReleased(e->ballPane.play());
		
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(20);
		sbSpeed.setValue(10);
		ballPane.rateProperty().bind(sbSpeed.valueProperty());
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setTop(sbSpeed);
		pane.setBottom(hBox);
		
		Scene scene = new Scene(pane,250,150);
		primaryStage.setTitle("µ¯µ¯µ¯");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MultipleBounceBall exam = new MultipleBounceBall();
		//exam.start(null);
		launch(args);

	}

}
