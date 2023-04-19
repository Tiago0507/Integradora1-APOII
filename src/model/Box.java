package model;

public class Box {

  private int number;
    private Box next;
    private Box previous;
    private Box tailSnake;
    private Box headLadder;
    private boolean isSnake = false;
    private boolean isLadder = false;
    private int identifier;

    private PlayersList playersList;

    //Constructor
    public Box(int number){
        this.playersList = new PlayersList();
        this.number = number;
    }
    

    //----------Getters and setters----------

    public String toString()
    {
        String list = "";
        if(playersList != null && playersList.getHead() != null){
            list = playersList.print(playersList.getHead());
        }
        
        //String players = getStringPlayers(playersList.getHead());
        return "[" + this.number + ((list != "")?" ":"") + list +"]";
    }

    public String toStringSnakesAndLadders(){
      return "[" + ((isSnake) ? (char) identifier : ((isLadder) ? identifier : " ")) + "]";//Pregunta si es una serpiente, si sí lo es
      //se castea el identificador como char. Si no es una serpiente pero es una escalera, se pone el identificador sin castear. Si no es
      //ninguno de los dos, solo se pone un espacio.
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Box getNext() {
        return next;
    }

    public void setNext(Box next) {
        this.next = next;
    }

    public Box getPrevious() {
        return previous;
    }

    public void setPrevious(Box previous) {
        this.previous = previous;
    }

    public Box getTailSnake() {
        return tailSnake;
    }

    public void setTailSnake(Box tailSnake) {
        this.tailSnake = tailSnake;
    }

    public Box getHeadLadder() {
        return headLadder;
    }

    public void setHeadLadder(Box headLadder) {
        this.headLadder = headLadder;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public PlayersList getPlayersList() {
        return playersList;
    }

    public void setPlayersList(PlayersList playersList) {
      this.playersList = playersList;
    }


    public boolean getIsSnake() {
      return isSnake;
    }


    public void setIsSnake(boolean isSnake) {
      this.isSnake = isSnake;
    }


    public boolean getIsLadder() {
      return isLadder;
    }


    public void setIsLadder(boolean isLadder) {
      this.isLadder = isLadder;
    }
    
}
