package model;

import java.util.Random;

public class Board {

    private Box head;
    private Box tail;
    private int rows;
    private int columns;
    private int size;
    private Random random;

    //Constructor
    public Board(int rows, int columns, int snakes, int ladders) {
      random = new Random();
        this.rows = rows;
        this.columns = columns;
        initBoard(rows, columns);
        fillSnakesAndLadders(snakes, ladders);
        printSnakesAndLadders();
    }
    
    //Method to initialize the board, is called from the constructor
    public void initBoard(int rows, int columns){
        this.tail = null;
        this.head = new Box(1);
        this.size = rows * columns;
        initBoard(size, head, 2);
    }

    private void initBoard(int size, Box current, int number){
        if(number > size){
            return;
        }

        Box newBox = new Box(number);
        current.setNext(newBox);
        newBox.setPrevious(current);
        tail = newBox;
        initBoard(size, current.getNext(),number + 1);
    }

    // Print 

    public void print(){
        if(head == null){
            System.out.println("Lista vacia");
        }else{
            if(this.rows%2==0){
                print(tail,2);
            }else{
                print(tail,1);
            }
            
        }
    }

    private void print(Box current, int row){
        int rows = this.rows;
        if(this.rows%2==0){
            rows+=1;
        }
        if(row > rows){
           return;
        }else{
            Box newCurrent = printRow(current, row, 1);
            System.out.println("");
            print(newCurrent, row+=1);
        }

    }

    private Box printRow(Box current, int row, int column) {
      Box boxito;
      if (column > this.columns - 1) {
        System.out.print(current.toString());
        return current.getPrevious();

      } else {
        if (row % 2 == 0) {
          //Pair
          System.out.print(current.toString());
          boxito = printRow(current.getPrevious(), row, column += 1);

        } else {
          //Odd

          boxito = printRow(current.getPrevious(), row, column += 1);
          System.out.print(current.toString());
        }
      }
      return boxito;
    }
    
    public void fillSnakesAndLadders(int snakes, int ladders) {
      fillSnakes(snakes, 0);
      fillLadders(ladders, 0);
    }

    private void fillSnakes(int snakes, int counter) {
      if (counter >= snakes)
        return;
      int posHead = random.nextInt(3, this.size);
      Box headBox = getBoxByNumber(posHead);
      if (headBox.getIsSnake() || headBox.getIsLadder()) {
        fillSnakes(snakes, counter);
        return;
      }
      int posTail = random.nextInt(2, posHead);
      Box tailBox = getBoxByNumber(posTail);
      if (tailBox.getIsSnake() || tailBox.getIsLadder()) {
        fillSnakes(snakes, counter);
        return;
      }
      headBox.setIsSnake(true);
      tailBox.setIsSnake(true);
      headBox.setIdentifier(counter + 65);
      tailBox.setIdentifier(counter + 65);
      headBox.setTailSnake(tailBox);
      fillSnakes(snakes, counter + 1);
    }
    
    private void fillLadders(int ladders, int counter) {
      if (counter >= ladders)return;
      int posTail = random.nextInt(2, this.size-1);
      Box tailBox = getBoxByNumber(posTail);
      if (tailBox.getIsSnake() || tailBox.getIsLadder()) {
        fillLadders(ladders, counter);
        return;
      }
      int posHead = random.nextInt(posTail + 1, this.size);
      Box headBox = getBoxByNumber(posHead);
      if (headBox.getIsSnake() || headBox.getIsLadder()) {
        fillLadders(ladders, counter);
        return;
      }

      headBox.setIsLadder(true);
      tailBox.setIsLadder(true);
      headBox.setIdentifier(counter + 1);
      tailBox.setIdentifier(counter + 1);
      tailBox.setHeadLadder(headBox);
      fillLadders(ladders, counter+1);
    }

    //Print snakes and ladders

    public void printSnakesAndLadders() {
      for (int i = 0; i < this.size; i++) {

        if (getBoxByNumber(i) != null) {
          if (getBoxByNumber(i).getIsLadder() || getBoxByNumber(i).getIsSnake()) {
          System.out.println("Ladder or snake: id: " + getBoxByNumber(i).getIdentifier() + " on box n " + i);
        }
        }
      }
    }
    //Get box by number

    public Box getBoxByNumber(int number){
        return getBoxByNumber(number, head);
    }

    private Box getBoxByNumber(int number, Box current) {
        if (current == null) return null;
        if(current.getNumber() == number) return current;
        return getBoxByNumber(number, current.getNext());
    }

    //-----Getters and setters-----


    public Box getHead() {
        return head;
    }

    public void setHead(Box head) {
        this.head = head;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getBoxAmmount(){
        return rows * columns;
    }


}
