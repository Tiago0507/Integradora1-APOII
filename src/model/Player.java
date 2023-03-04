package model;

public class Player {

    private String name;
    private Player next;
    private double score;


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

    
}
