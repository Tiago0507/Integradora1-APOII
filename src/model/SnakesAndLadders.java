package model;

public class SnakesAndLadders {

    private Board board;
    private PlayersList playerList;
    private PointTree pointTree;
    public final int NUMBER_OF_PLAYERS = 3;
    //Constructor
    public SnakesAndLadders(){
        playerList = new PlayersList();
    }
    public void play(){
        board.print();
    }

    public void initializeBoard(int rows, int columns){
        
       this.board = new Board(rows, columns);
       this.board.getHead().setPlayersList(playerList);
       play();
    }

    public Board getBoard(){
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public PointTree getPointTree() {
        return pointTree;
    }

    public void setPointTree(PointTree pointTree) {
        this.pointTree = pointTree;
    }



    public PlayersList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayersList playerList) {
        this.playerList = playerList;
    }


}
