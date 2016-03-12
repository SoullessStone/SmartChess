package kiwi.hara.chess.model;

import kiwi.hara.chess.model.field.Field;
import kiwi.hara.chess.model.figures.ChessFigure;

/**
 * Created by SoullessStone on 11.03.2016.
 */
public class MoveNotPossibleException extends Exception {

    public MoveNotPossibleException(Field from, Field to, ChessFigure figure, String message) {
        super("Could not move " + figure + " from " + from + " to " + to + ".");
    }
}
