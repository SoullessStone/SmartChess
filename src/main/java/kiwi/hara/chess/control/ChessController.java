package kiwi.hara.chess.control;

import kiwi.hara.chess.boundry.Gui;
import kiwi.hara.chess.model.MoveNotPossibleException;
import kiwi.hara.chess.model.field.ChessBoard;
import kiwi.hara.chess.model.field.ChessMove;
import kiwi.hara.chess.model.field.Field;
import kiwi.hara.chess.model.figures.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SoullessStone on 11.03.2016.
 */
public class ChessController {
    private ChessBoard chessBoard = new ChessBoard();
    private List<ChessFigure> figures = getAllFigures();
    private Gui gui;

    public ChessController(Gui gui) {
        this.gui = gui;
        initFigures();
    }

    public void moveFigure(Field from, Field to) throws MoveNotPossibleException {
        Field fromReal = chessBoard.getBoard()[from.getRank()][from.getFile()];
        Field toReal = chessBoard.getBoard()[to.getRank()][to.getFile()];
        gui.changeImages(from.getRank(),from.getFile(), ChessFigure.ChessFigureName.NOTHING);
        gui.changeImages(to.getRank(),to.getFile(), fromReal.getFigure().getName());
        moveChessFigureOnModel(fromReal, toReal);
    }

    private void moveChessFigureOnModel(Field from, Field to) throws MoveNotPossibleException {
        ChessFigure figure = from.getFigure();
        if (figure == null)
            throw new MoveNotPossibleException(from, to, figure, "No figure.");
        if (to.getFigure() != null) {
            if (to.getFigure().getColor() == figure.getColor())
                throw new MoveNotPossibleException(from, to, figure, "Field occupied.");
            killFigure(to.getFigure());
        }
        from.setFigure(null);
        to.setFigure(figure);
    }

    private void killFigure(ChessFigure figure) {
        figure.kill();
        figures.remove(figure);
    }

    private List<Field> getPossibleMoves(Field field) {
        List<Field> possibleFields = new ArrayList<Field>();
        int rank = field.getRank();
        int file = field.getFile();

        // TODO Implement
        ChessMove chessMove = field.getFigure().getChessMove();
        if (chessMove.specialKing) {
            addIfInBounce(possibleFields, rank - 1, file - 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank - 1, file, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank - 1, file + 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank, file - 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank, file + 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank + 1, file - 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank + 1, file, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank + 1, file + 1, field.getFigure().getColor());
            return possibleFields;
        }
        if (chessMove.specialPawn) {
            addIfInBounce(possibleFields, rank - 1, file - 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank - 1, file, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank - 1, file + 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank, file - 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank, file + 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank + 1, file - 1, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank + 1, file, field.getFigure().getColor());
            addIfInBounce(possibleFields, rank + 1, file + 1, field.getFigure().getColor());
            return possibleFields;
        }


        return possibleFields;
    }

    private void addIfInBounce(List<Field> possibleFields, Integer rank, Integer file, ChessFigure.ChessFigureColor color) {
        Field candidate = null;
        try {
            candidate = chessBoard.getBoard()[rank][file];
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
        if (candidate.getFigure() == null) {
            possibleFields.add(candidate);
            return;
        }
        ChessFigure figureOnCandidate = candidate.getFigure();
        if (figureOnCandidate.getColor().equals(color))
            return;
        possibleFields.add(candidate);
    }

    private void initFigures() {
        chessBoard.getBoard()[0][0].setFigure(new Rook(ChessFigure.ChessFigureName.BLACK_ROOK, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[0][1].setFigure(new Knight(ChessFigure.ChessFigureName.BLACK_KNIGHT, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[0][2].setFigure(new Bishop(ChessFigure.ChessFigureName.BLACK_BISHOP, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[0][3].setFigure(new Queen(ChessFigure.ChessFigureName.BLACK_QUEEN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[0][4].setFigure(new King(ChessFigure.ChessFigureName.BLACK_KING, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[0][5].setFigure(new Bishop(ChessFigure.ChessFigureName.BLACK_BISHOP, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[0][6].setFigure(new Knight(ChessFigure.ChessFigureName.BLACK_KNIGHT, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[0][7].setFigure(new Rook(ChessFigure.ChessFigureName.BLACK_ROOK, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][0].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][1].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][2].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][3].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][4].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][5].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][6].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));
        chessBoard.getBoard()[1][7].setFigure(new Pawn(ChessFigure.ChessFigureName.BLACK_PAWN, ChessFigure.ChessFigureColor.BLACK));

        chessBoard.getBoard()[7][0].setFigure(new Rook(ChessFigure.ChessFigureName.WHITE_ROOK, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[7][1].setFigure(new Knight(ChessFigure.ChessFigureName.WHITE_KNIGHT, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[7][2].setFigure(new Bishop(ChessFigure.ChessFigureName.WHITE_BISHOP, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[7][3].setFigure(new Queen(ChessFigure.ChessFigureName.WHITE_QUEEN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[7][4].setFigure(new King(ChessFigure.ChessFigureName.WHITE_KING, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[7][5].setFigure(new Bishop(ChessFigure.ChessFigureName.WHITE_BISHOP, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[7][6].setFigure(new Knight(ChessFigure.ChessFigureName.WHITE_KNIGHT, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[7][7].setFigure(new Rook(ChessFigure.ChessFigureName.WHITE_ROOK, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][0].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][1].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][2].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][3].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][4].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][5].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][6].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
        chessBoard.getBoard()[6][7].setFigure(new Pawn(ChessFigure.ChessFigureName.WHITE_PAWN, ChessFigure.ChessFigureColor.WHITE));
    }

    private List<ChessFigure> getAllFigures() {
        List<ChessFigure> result = new ArrayList<ChessFigure>();
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard.getBoard()[i][j].getFigure() != null)
                    result.add(chessBoard.getBoard()[i][j].getFigure());
            }
        }
        return result;
    }
}
