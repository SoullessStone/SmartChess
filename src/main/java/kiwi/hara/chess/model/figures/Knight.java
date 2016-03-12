package kiwi.hara.chess.model.figures;

import kiwi.hara.chess.model.field.ChessMove;

/**
 * Created by SoullessStone on 11.03.2016.
 */
public class Knight extends ChessFigure {
    public Knight(ChessFigureName name, ChessFigureColor color) {
        super(name, color);
        super.setChessMove(getSpecialicedChessMove());
    }

    @Override
    protected ChessMove getSpecialicedChessMove() {
        return new ChessMove(false, true, false, true, false);
    }
}
