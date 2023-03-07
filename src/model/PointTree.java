package model;

public class PointTree {

    private TreePlayerNode root;

    //Constructor
    public PointTree(){
        
    }

    //Binary search tree methods

    public void add(TreePlayerNode player){
        if(root == null){
            root = player;
        }else{
            add(root, player);
        }
    }
    private void add(TreePlayerNode current, TreePlayerNode player){
        if(player.getPlayer().getScore() < current.getPlayer().getScore()){
          //Meter a la izquierda
            if(current.getLeft() == null){
                current.setLeft(player);
            }else{
                add(current.getLeft(), player);
            }
        }else if(player.getPlayer().getScore() > current.getPlayer().getScore()){
            //Meter a la derecha
            if(current.getRight() == null){
                current.setRight(player);
            }else{
                add(current.getRight(), player);
            }

        }else{
            //No hacer nada
        }
    }

    //In order from highest to lowest
    public String inOrder(){
        return inOrder(root);
    }
    private String inOrder(TreePlayerNode current){
        String msj = "";
        if(current == null){
            return msj;
        }
        msj += inOrder(current.getRight());
        msj += ("Nombre: " + current.getPlayer().getName() + ", Puntaje: " + current.getPlayer().getScore() + "\n");
        msj += inOrder(current.getLeft());
        return msj;
    }

    
    //-----Getters and setters-----


    public TreePlayerNode getRoot() {
        return root;
    }

    public void setRoot(TreePlayerNode root) {
        this.root = root;
    }

}
