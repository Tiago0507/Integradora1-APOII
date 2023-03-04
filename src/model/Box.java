package model;

public class Box {

    private int number;
    private Box next;
    private Box previous;
    private Snake snake;
    private Ladder ladder;
    private Player player;

    //Constructor
    public Box(int number){
        this.number = number;
    }
    

    //----------Getters and setters----------


    //
    public Snake getSnake() {
        return snake;
    }
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    public Ladder getLadder() {
        return ladder;
    }
    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Box getNext(){
        return next;
    }
    public void setNext(Box next){
        this.next = next;
    }
    public Box getPrevious(){
        return previous;
    }
    public void setPrevious(Box previous){
        this.previous = previous;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

}
