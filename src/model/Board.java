package model;

public class Board {

    private Box head;
    private int rows;
    private int columns;

    //Constructor
    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        initBoard(rows, columns);
    }
    
    //Method to initialize the board, is called from the constructor
    public void initBoard(int rows, int columns){
        this.head = new Box(1);
        int size = rows * columns;
        initBoard(size, head, 2);
    }

    private void initBoard(int size, Box current, int number){
        if(number > size){
            return;
        }

        Box newBox = new Box(number);
        current.setNext(newBox);
        newBox.setPrevious(current);

        initBoard(size, current.getNext(),number + 1);
    }

    // Print 

    public void print(){
        if(head == null){
            System.out.println("Lista vacia");
        }else{
            print(head);
        }
    }

    private void print(Box current){
        if(current.getNext() == null){
            System.out.println(current.getNumber());
        }else{
            System.out.print(current.getNumber() + ", ");
            print(current.getNext());
        }

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


}
