package model;

public class SnakesAndLadders {

    private Board board;
    private PointTree pointTree;

    //Constructor
    public SnakesAndLadders(){

    }

    public void play(){
        board.print();
        return;
    }

    public void initializeBoard(int rows, int columns){
        this.board = new Board(rows, columns);
        play();
    }

    public Board getBoard(){
        return this.board;
    }

}
