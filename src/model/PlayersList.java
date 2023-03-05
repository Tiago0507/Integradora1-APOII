package model;

public class PlayersList {

    private Player head;

    //Methods

    public void add(Player player){
        if(head == null){
            head = player;
        }else{
            add(head, player);
        }
    }
    private void add(Player current, Player player){
        if(current.getNext() == null){
            current.setNext(player);
            return;
        }
        add(current.getNext(), player);
    }


    //-----Getters and setters-----


    public Player getHead() {
        return head;
    }
    public void setHead(Player head) {
        this.head = head;
    }

}
