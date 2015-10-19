package view;

import controller.CellController;
import controller.GameStatusController;
import javafx.scene.control.Label;
import model.Board;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class View extends Application {
	private Label gameStatus = new Label();
	private Board board = new Board();

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane pane = new GridPane();
		pane.setPrefSize(2000, 2000);
		pane.setStyle("-fx-border-color: black");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Cell cell = new Cell(i, j, board);
				CellController cellController = new CellController(cell);
				board.addObserver(cellController);
				pane.add(cell, j, i);
			}
		}

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(gameStatus);
		Scene scene = new Scene(borderPane, 450, 200);
		primaryStage.setTitle("TicTacToe");// set the stage title
		primaryStage.setScene(scene);// place the scene in the stage


		// create GameStatusController
		GameStatusController gameStatusController = new GameStatusController(gameStatus);
		board.addObserver(gameStatusController);
		// send initial update to display text for first turn
		gameStatusController.update(board, null);


		primaryStage.show();// display the stage

	}

	public static void main(String[] args) {

		Application.launch();
	}

}
