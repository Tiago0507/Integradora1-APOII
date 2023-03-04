package model;

public abstract class SpecialBox {

    protected Box head;
    protected Box tail;
    protected String identifier;


    //-----Getters and Setters-----

    
    public Box getHead() {
        return head;
    }
    public void setHead(Box head) {
        this.head = head;
    }
    public Box getTail() {
        return tail;
    }
    public void setTail(Box tail) {
        this.tail = tail;
    }
    public String getIdentifier(){
        return identifier;
    }
    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }
}
