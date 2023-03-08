package model;

public class PlayersList {

    private LinkedListPlayerNode head;

    //Methods

    public void add(LinkedListPlayerNode player){
        if(head == null){
            head = player;
            head.setNext(head);
            head.setPrevious(head);
        }else{
            LinkedListPlayerNode tail = head.getPrevious();
            player.setNext(head);
            head.setPrevious(player);
            tail.setNext(player);
            player.setPrevious(tail);
        }
    }

    public String print(LinkedListPlayerNode player){
        if(player == head.getPrevious()){
            return player.getPlayer().toString();
        }
        return print(player.getNext()) + " " + player.getPlayer().toString(); 
    }


    public void delete(LinkedListPlayerNode player, String goal){
        if(player.getPlayer().getName().equals(goal)){
            if(player == head){
                head.getPrevious().setNext(head.getNext());
                head.getNext().setPrevious(head.getPrevious());
                head = head.getNext();
            }else{
                LinkedListPlayerNode prev = player.getPrevious();
                LinkedListPlayerNode next = player.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
            }
            return;
        }
        if(player.getNext() == head){
            return;
        }
        delete(player.getNext(), goal);

    }

    //-----Getters and setters-----


    public LinkedListPlayerNode getHead() {
        return head;
    }
    public void setHead(LinkedListPlayerNode head) {
        this.head = head;
    }

}
