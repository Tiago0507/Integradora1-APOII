package model;

public class Player {

    private String name;
    private double score;
    private int position;

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString(){
        return name; 
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    
}
