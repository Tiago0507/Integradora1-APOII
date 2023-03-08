package model;

public class PlayersList{

    private LinkedListPlayerNode head;

    //Methods

    public LinkedListPlayerNode searchPlayerByName(String name){
        return searchPlayerByName(name, head);
    }
    private LinkedListPlayerNode searchPlayerByName(String name, LinkedListPlayerNode current){
        if(current == null) return null;
        if(current.getPlayer().getName().equals(name)) return current;
        return searchPlayerByName(name, current.getNext());
    }

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


    public void delete(String goal){
        delete(head, goal);
    }
    private void delete(LinkedListPlayerNode player, String goal){
        if (player == null) return;
        if(player.getPlayer().getName().equals(goal)){
            if(player == head){
                if(head.getPrevious() == head && head.getNext() == head){
                    head = null;
                } else {
                    head.getPrevious().setNext(head.getNext());
                    head.getNext().setPrevious(head.getPrevious());
                    head = head.getNext();
                }

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
