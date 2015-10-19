package view;

import javafx.scene.layout.Pane;
import model.Board;

public class Cell extends Pane {

    private int x;
    private int y;

    public Cell(int x, int y, Board b) {
        setStyle("-fx-border-color: black");
        this.x = x;
        this.y = y;
        this.setPrefSize(2000, 2000);
        this.setOnMouseClicked(e -> {
            // TODO move to controller
            if (b.getMove(x, y) == Board.EMPTY) {
                b.setMove(x, y);
            }
        });
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}