package model;

public class Board {

    private Box head;
    private Box tail;
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
        this.tail = null;
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

    private Box printRow(Box current, int row, int column){
        Box boxito; 
        if(column > this.columns-1){
            System.out.print(current.toString());
            return current.getPrevious();

        }else{
            if(row%2==0){
                //Pair
                System.out.print(current.toString());
                boxito = printRow(current.getPrevious(), row, column+=1); 
                
            }
            else{
                //Odd
                
                boxito = printRow(current.getPrevious(), row, column+=1); 
                System.out.print(current.toString());
            }
        }
        return boxito;
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
