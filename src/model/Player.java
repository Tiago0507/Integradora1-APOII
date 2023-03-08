package model;

public class Player {

    private String name;
    private double score;


    //Constructor
    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString(){
        return name; 
    }


    //-----Getters and setters-----



    
}
