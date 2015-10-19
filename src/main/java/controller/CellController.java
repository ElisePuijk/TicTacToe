package controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import model.Board;
import view.Cell;

import java.util.Observable;
import java.util.Observer;

/**
 * Controller for cells
 */
public class CellController implements Observer {

    private Cell cell;

    public CellController(Cell cell){
        this.cell = cell;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Board){
            Board b = (Board) o;
            repaint(b.getMove(cell.getX(), cell.getY()));
        }
    }

    /**
     * Paints x or o in the cell
     * @param player the player which has made a move in this cell
     */
    public void repaint(char player){
        if (player == 'x'){
            Line line1 = new Line(10, 10, cell.getWidth() - 10, cell.getHeight() - 10);
            line1.endXProperty().bind(cell.widthProperty().subtract(10));
            line1.endYProperty().bind(cell.heightProperty().subtract(10));
            Line line2 = new Line(10, cell.getHeight() - 10, cell.getWidth() - 10, 10);
            line2.startYProperty().bind(cell.heightProperty().subtract(10));
            line2.endXProperty().bind(cell.widthProperty().subtract(10));
            // add the lines to the pane
            cell.getChildren().addAll(line1, line2);
        } else if (player == 'o') {
            Ellipse ellipse = new Ellipse(cell.getWidth() / 2, cell.getHeight() / 2, cell.getWidth() / 2 - 10, cell.getHeight() / 2 - 10);
            ellipse.centerXProperty().bind(cell.widthProperty().divide(2));
            ellipse.centerYProperty().bind(cell.heightProperty().divide(2));
            ellipse.radiusXProperty().bind(cell.widthProperty().divide(2).subtract(10));
            ellipse.radiusYProperty().bind(cell.heightProperty().divide(2).subtract(10));
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.WHITE);
            cell.getChildren().add(ellipse); // add the ellipse to the pane
        }
    }
}
