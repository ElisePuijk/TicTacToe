package controller;

import javafx.scene.control.Label;
import model.Board;

import java.util.Observable;
import java.util.Observer;

/**
 * Controller for the game status
 */
public class GameStatusController implements Observer {

    private Label gameStatus;

    public GameStatusController(Label gameStatusLabel){
        this.gameStatus = gameStatusLabel;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Board){
            Board b = (Board) o;

            // check if some player has won
            if (b.isWon(b.getPreviousPlayer())){
                gameStatus.setText("Einde spel, speler " + b.getPreviousPlayer() + " heeft gewonnen");
            } else {
                gameStatus.setText("Speler " + b.getPlayer() + " is aan de beurt");
            }


        }
    }
}
