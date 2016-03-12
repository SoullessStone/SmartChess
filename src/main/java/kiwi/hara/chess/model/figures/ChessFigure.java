package kiwi.hara.chess.model.figures;

import kiwi.hara.chess.model.field.ChessMove;

/**
 * Created by SoullessStone on 11.03.2016.
 */
public abstract class ChessFigure {
    private ChessFigureName name;
    private ChessFigureColor color;
    private ChessMove chessMove;
    private Boolean alive = true;

    public ChessFigure(ChessFigureName name, ChessFigureColor color) {
        this.name = name;
        this.color = color;
    }

    protected abstract ChessMove getSpecialicedChessMove();

    public ChessFigureColor getColor() {
        return color;
    }

    public void setColor(ChessFigureColor color) {
        this.color = color;
    }

    public ChessFigureName getName() {
        return name;
    }

    public Boolean isAlive() {
        return alive;
    }

    public void kill() {
        this.alive = false;
    }

    public ChessMove getChessMove() {
        return chessMove;
    }

    public void setChessMove(ChessMove chessMove) {
        this.chessMove = chessMove;
    }

    public enum ChessFigureColor {
        BLACK, WHITE
    }

    public enum ChessFigureName {

        BLACK_KING,
        BLACK_QUEEN,
        BLACK_BISHOP,
        BLACK_ROOK,
        BLACK_PAWN,
        BLACK_KNIGHT,
        WHITE_KING,
        WHITE_QUEEN,
        WHITE_BISHOP,
        WHITE_ROOK,
        WHITE_PAWN,
        WHITE_KNIGHT,
        NOTHING
    }
}
