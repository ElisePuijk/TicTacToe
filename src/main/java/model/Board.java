package model;

import java.util.Observable;

/**
 * Model for the TicTacToe Board
 */
public class Board extends Observable {

    public static final char PLAYER_X = 'x';
    public static final char PLAYER_O = 'o';
    public static final char EMPTY = ' ';

    private char player = PLAYER_X;
    private char[][] board = new char[3][3];

    public Board(){
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                board[i][j] = EMPTY;
            }
        }
    }

    public char getPlayer (){
        return player;
    }

    /**
     * @return The last player who has made a move
     */
    public char getPreviousPlayer(){
        if (player == PLAYER_O){
            return PLAYER_X;
        } else
            return PLAYER_O;
    }



    /**
     * Sets the next player in this board
     */
    private void setNextPlayer(){
        if (player == PLAYER_O){
            player = PLAYER_X;
        } else if (player == PLAYER_X){
            player = PLAYER_O;
        }
    }

    public void setMove(int i, int j){
        board[i][j] = player;
        setNextPlayer();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * get the move made on place i,j
     */
    public char getMove(int i, int j){
        return board[i][j];
    }

    public boolean isWon(char token){
        // checkt de rijen
        for (int i = 0; i < 3; i ++){
            if (getMove(i, 0) == token && getMove(i, 1)  == token && getMove(i, 2) == token){
                // iets van cell[i][0] setbackground, etc
                return true;
            }
        }
        // checkt de kolommen
        for (int j = 0; j< 3; j++){
            if (getMove(0, j) == token && getMove(1, j) == token && getMove(2, j) == token){

                return true;
            }
        }
        // checkt de diagonaal (vlnr)
        if (getMove(0, 0) == token && getMove(1, 1)== token && getMove(2, 2) == token){
            return true;
        }
        // checkt de diagonaal (vrnl)
        return getMove(0, 2) == token && getMove(1, 1) == token && getMove(2, 0) == token;

    }

    public String toString(){
        return "Board{ player = " + getPlayer() + '\n' +
                board[0][0] + board[0][1] + board[0][2] + '\n' +
                board[1][0] + board[1][1] + board[1][2] + '\n' +
                board[2][0] + board[2][1] + board[2][2] + "\n}";
    }
}
