package kiwi.hara.chess.model.field;

import kiwi.hara.chess.model.figures.ChessFigure;

/**
 * Created by SoullessStone on 11.03.2016.
 */
public class Field {
    private String name;
    private ChessFigure figure;
    private Integer rank;
    private Integer file;

    public Field(String name, Integer rank, Integer file){
        this.name = name;
        this.rank = rank;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getFile() {
        return file;
    }

    public Boolean isEmpty(){
        return figure==null;
    }

    public void setFigure(ChessFigure figure) {
        this.figure = figure;
    }

    public ChessFigure getFigure(){
        return figure;
    }
}
