package model;

public class LinkedListPlayerNode{
    private Player player;
    private LinkedListPlayerNode next;

    public LinkedListPlayerNode(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LinkedListPlayerNode getNext() {
        return next;
    }

    public void setNext(LinkedListPlayerNode next) {
        this.next = next;
    }
}