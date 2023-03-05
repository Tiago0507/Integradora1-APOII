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

    public void removePlayer(Player player){
        removePlayer(player, head);
    }
    private void removePlayer(Player player, Player current){
        if (current.getNext() == null) return;
        if (player == head){
            if(player.getNext() == null){
                head = null;
            } else {
                head = player.getNext();
            }
            return;
        }
        if (current.getNext() == player){
            if(player.getNext() == null){
                current.setNext(null);
            } else {
                current.setNext(player.getNext());
            }
        } else {
            removePlayer(player, current.getNext());
        }
    }


    //-----Getters and setters-----


    public Player getHead() {
        return head;
    }
    public void setHead(Player head) {
        this.head = head;
    }

}
