package kiwi.hara.chess.model.field;

import kiwi.hara.chess.model.figures.ChessFigure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SoullessStone on 11.03.2016.
 */
public class ChessBoard {

    private Field[][] board;

    public ChessBoard() {
        board = new Field[8][8];
        initFields();
    }

    private void initFields() {
        String[] numberToChar = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Field(numberToChar[j] + (i + 1), i, j);
            }
        }
    }

    public Field[][] getBoard() {
        return board;
    }
}
