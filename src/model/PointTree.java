package model;

public class PointTree {

    private Player root;

    //Constructor
    public PointTree(){
        
    }

    //Binary search tree methods

    public void add(Player player){
        if(root == null){
            root = player;
        }else{
            add(root, player);
        }
    }
    private void add(Player current, Player player){
        if(player.getScore() < current.getScore()){
          //Meter a la izquierda
            if(current.getLeft() == null){
                current.setLeft(player);
            }else{
                add(current.getLeft(), player);
            }
        }else if(player.getScore() > current.getScore()){
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
    private String inOrder(Player current){
        String msj = "";
        if(current == null){
            return msj;
        }
        msj += inOrder(current.getRight());
        msj += ("Nombre: " + current.getName() + ", Puntaje: " + current.getScore() + "\n");
        msj += inOrder(current.getLeft());
        return msj;
    }

    
    //-----Getters and setters-----


    public Player getRoot() {
        return root;
    }

    public void setRoot(Player root) {
        this.root = root;
    }

}
