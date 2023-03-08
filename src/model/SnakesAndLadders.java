package model;

import java.util.concurrent.ThreadLocalRandom;

public class SnakesAndLadders {

    private Board board;
    private PlayersList playerList;
    private PointTree pointTree;
    public final int NUMBER_OF_PLAYERS = 3;
    private LinkedListPlayerNode currentPlayer;
    private long timer;
    private boolean finishGame = false;
    
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
        int dice = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        msj = "Has sacado " + dice;
        int newPlayerPos = currentPlayer.getPlayer().getPosition() + dice;  
        if(newPlayerPos >= board.getBoxAmmount()){
            this.finishGame = true;
            return msj = "Has llegado a la casilla final, has ganado.";
        } 
        movePlayerOnBoard(newPlayerPos);
        return msj;
    }

    private void movePlayerOnBoard(int newPlayerPos){
        Box currentPlayerBox = getBoxByNumber(currentPlayer.getPlayer().getPosition());
        Box newPlayerBox = getBoxByNumber(newPlayerPos);
        LinkedListPlayerNode playerOnBox = currentPlayerBox.getPlayersList().searchPlayerByName(getCurrentPlayerName());
        currentPlayerBox.getPlayersList().delete(getCurrentPlayerName());
        newPlayerBox.getPlayersList().add(playerOnBox);
        currentPlayer.getPlayer().setPosition(newPlayerPos);
        currentPlayer = currentPlayer.getNext();
    }

    private Box getBoxByNumber(int number){
        return board.getBoxByNumber(number);
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

    public void addPlayer(LinkedListPlayerNode controllerPlayer, LinkedListPlayerNode boxPlayer){
        if(currentPlayer == null) currentPlayer = controllerPlayer;
        playerList.add(controllerPlayer);
        board.getHead().getPlayersList().add(boxPlayer);
    }

    public PlayersList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayersList playerList) {
        this.playerList = playerList;
    }

    public boolean getFinishGame(){
        return this.finishGame;
    }

    public void initTimer(){
        this.timer = System.currentTimeMillis();
    }

    public float getTimer(){
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - timer) / 1000F;
        return seconds;
    }


}
