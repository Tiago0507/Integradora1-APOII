package model;

public class TreePlayerNode {
    private Player player;
    private TreePlayerNode left;
    private TreePlayerNode right;

    public TreePlayerNode(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TreePlayerNode getLeft() {
        return left;
    }

    public void setLeft(TreePlayerNode left) {
        this.left = left;
    }

    public TreePlayerNode getRight() {
        return right;
    }

    public void setRight(TreePlayerNode right) {
        this.right = right;
    }
}
