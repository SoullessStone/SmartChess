package kiwi.hara.chess.boundry;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import kiwi.hara.chess.control.ChessController;
import kiwi.hara.chess.model.MoveNotPossibleException;
import kiwi.hara.chess.model.field.Field;
import kiwi.hara.chess.model.figures.ChessFigure;

import java.util.HashMap;
import java.util.Map;


public class Gui extends Application {
    ChessController chessController = new ChessController(this);

    GridPane gridPane = new GridPane();
    ImageView[][] imageViews = new ImageView[8][8];
    Map<ChessFigure.ChessFigureName, Image> figureNameToImageMap;


    // TODO Remove
    private int counter = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initFigureNameToImageMap();

        primaryStage.setTitle("Chess");

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);

        resetGameField();

        Scene scene = new Scene(gridPane, 500, 500);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                try {
                    // Beispiel: Grünfeld-Indische Verteidigung
                    switch (counter){
                        case 0:
                            chessController.moveFigure(new Field("", 0, 6), new Field("", 2, 5));
                            break;
                        case 1:
                            chessController.moveFigure(new Field("", 6, 3), new Field("", 4, 3));
                            break;
                        case 2:
                            chessController.moveFigure(new Field("", 1, 6), new Field("", 2, 6));
                            break;
                        case 3:
                            chessController.moveFigure(new Field("", 7, 3), new Field("", 6, 3));
                            break;
                        case 4:
                            chessController.moveFigure(new Field("", 1, 3), new Field("", 3, 3));
                            break;
                        case 5:
                            chessController.moveFigure(new Field("", 7, 1), new Field("", 5, 2));
                            break;
                    }
                    counter++;
                } catch (MoveNotPossibleException e) {
                    e.printStackTrace();
                }
                System.out.println("klick");
            }
        });

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initFigureNameToImageMap() {
        figureNameToImageMap = new HashMap<ChessFigure.ChessFigureName, Image>();
        final Image blackKing = new Image("BLACK_KING.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.BLACK_KING, blackKing);
        final Image blackQueen = new Image("BLACK_QUEEN.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.BLACK_QUEEN, blackQueen);
        final Image blackBishop = new Image("BLACK_BISHOP.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.BLACK_BISHOP, blackBishop);
        final Image blackRook = new Image("BLACK_ROOK.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.BLACK_ROOK, blackRook);
        final Image blackPawn = new Image("BLACK_PAWN.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.BLACK_PAWN, blackPawn);
        final Image blackKnight = new Image("BLACK_KNIGHT.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.BLACK_KNIGHT, blackKnight);
        final Image whiteKing = new Image("WHITE_KING.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.WHITE_KING, whiteKing);
        final Image whiteQueen = new Image("WHITE_QUEEN.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.WHITE_QUEEN, whiteQueen);
        final Image whiteBishop = new Image("WHITE_BISHOP.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.WHITE_BISHOP, whiteBishop);
        final Image whiteRook = new Image("WHITE_ROOK.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.WHITE_ROOK, whiteRook);
        final Image whitePawn = new Image("WHITE_PAWN.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.WHITE_PAWN, whitePawn);
        final Image whiteKnight = new Image("WHITE_KNIGHT.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.WHITE_KNIGHT, whiteKnight);
        final Image nothing = new Image("NOTHING.png");
        figureNameToImageMap.put(ChessFigure.ChessFigureName.NOTHING, nothing);
    }

    private void resetGameField() {
        clearGridPane();
        imageViews[0][0].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_ROOK));
        imageViews[0][1].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_KNIGHT));
        imageViews[0][2].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_BISHOP));
        imageViews[0][3].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_QUEEN));
        imageViews[0][4].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_KING));
        imageViews[0][5].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_BISHOP));
        imageViews[0][6].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_KNIGHT));
        imageViews[0][7].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_ROOK));
        imageViews[1][0].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));
        imageViews[1][1].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));
        imageViews[1][2].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));
        imageViews[1][3].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));
        imageViews[1][4].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));
        imageViews[1][5].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));
        imageViews[1][6].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));
        imageViews[1][7].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.BLACK_PAWN));

        imageViews[7][0].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_ROOK));
        imageViews[7][1].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_KNIGHT));
        imageViews[7][2].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_BISHOP));
        imageViews[7][3].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_QUEEN));
        imageViews[7][4].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_KING));
        imageViews[7][5].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_BISHOP));
        imageViews[7][6].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_KNIGHT));
        imageViews[7][7].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_ROOK));
        imageViews[6][0].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
        imageViews[6][1].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
        imageViews[6][2].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
        imageViews[6][3].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
        imageViews[6][4].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
        imageViews[6][5].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
        imageViews[6][6].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
        imageViews[6][7].setImage(figureNameToImageMap.get(ChessFigure.ChessFigureName.WHITE_PAWN));
    }

    public void changeImages(int rank, int file, ChessFigure.ChessFigureName chessFigureName){
        imageViews[rank][file].setImage(figureNameToImageMap.get(chessFigureName));
    }

    private void clearGridPane() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final Pane pane = new Pane();
                final ImageView imageView = new ImageView(figureNameToImageMap.get(ChessFigure.ChessFigureName.NOTHING));
                imageViews[i][j] = imageView;
                pane.getChildren().addAll(imageView);
                gridPane.add(pane, j, i);
            }
        }
    }
}

