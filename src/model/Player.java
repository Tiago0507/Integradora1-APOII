package model;

public class Player {

    private String name;
    private Player next;
    private double score;
    private Player left;
    private Player right;

    //Constructor
    public Player(String name){
        this.name = name;
    }

    
    //-----Getters and setters-----

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Player getNext() {
        return next;
    }
    public void setNext(Player next) {
        this.next = next;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public Player getLeft() {
        return left;
    }
    public void setLeft(Player left) {
        this.left = left;
    }
    public Player getRight() {
        return right;
    }
    public void setRight(Player right) {
        this.right = right;
    }

    
}
