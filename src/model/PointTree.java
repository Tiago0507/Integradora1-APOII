package model;

public class PointTree {

    private TreePlayerNode root;

    //Constructor
    public PointTree(){
        
    }

    //Binary search tree methods

    public void addScoreToTree(double score, String name){
        Player player = new Player(name);
        player.setScore(score);
        TreePlayerNode playerNode = new TreePlayerNode(player);
        if(root == null){
            root = playerNode;
        }else{
            add(root, playerNode);
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
    public void inOrderTop5(){
        inOrderTop5(root, 0);
    }
    private int inOrderTop5(TreePlayerNode current, int counter){
        if(current == null) return counter;
        counter = inOrderTop5(current.getRight(), counter+1);
        if(counter >= 5) return counter;
        System.out.println("Nombre: " + current.getPlayer().getName() + ", Puntaje: " + current.getPlayer().getScore() + "\n");
        counter = inOrderTop5(current.getLeft(), counter + 1);
        return counter;
    }

    
    //-----Getters and setters-----


    public TreePlayerNode getRoot() {
        return root;
    }

    public void setRoot(TreePlayerNode root) {
        this.root = root;
    }

}
