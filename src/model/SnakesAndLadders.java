package model;

public class SnakesAndLadders {

    private Board board;
    private PlayersList playerList;
    private PointTree pointTree;
    public final int NUMBER_OF_PLAYERS = 3;
    private LinkedListPlayerNode currentPlayer;
    private double timer;
    
    //Constructor
    public SnakesAndLadders(){
        playerList = new PlayersList();
    }
    public String play(int option){
        String msj = "";
        switch (option){
            case 1 -> msj = throwDice();
            case 2 -> printSnakesAndLadders();
            default -> msj = "Opcion incorrecta.";
        }
        return msj;
    }

    private String throwDice(){
        String msj = "";
        return msj;
    }

    private void printSnakesAndLadders(){
        board.printSnakesAndLadders();
    }

    public String getCurrentPlayerName(){
        String name = currentPlayer.getPlayer().getName();
        return name;
    }

    public void initializeBoard(int rows, int columns){
       this.board = new Board(rows, columns);
       this.board.getHead().setPlayersList(playerList);
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

    public void addPlayer(LinkedListPlayerNode player){
        if(currentPlayer == null) currentPlayer = player;
        playerList.add(player);
    }

    public PlayersList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayersList playerList) {
        this.playerList = playerList;
    }


}
