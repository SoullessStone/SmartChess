package kiwi.hara.chess.model.field;

/**
 * Created by SoullessStone on 11.03.2016.
 */
public class ChessMove {
    public final Boolean diagonalAllowed;
    public final Boolean backwardAllowed;

    public final Boolean specialPawn;
    public final Boolean specialKnight;
    public final Boolean specialKing;

    public ChessMove(Boolean diagonalAllowed, Boolean backwardAllowed, Boolean specialPawn, Boolean specialKnight, Boolean specialKing) {
        this.diagonalAllowed = diagonalAllowed;
        this.backwardAllowed = backwardAllowed;
        this.specialPawn = specialPawn;
        this.specialKnight = specialKnight;
        this.specialKing = specialKing;
    }

    public ChessMove(boolean diagonalAllowed, boolean backwardAllowed) {
        this(diagonalAllowed, backwardAllowed, false, false, false);
    }
}
