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
      random = new Random(); //Random para elegir el lugar de una escalera o una serpiente dentro del board.
        this.rows = rows;
        this.columns = columns;
        initBoard(rows, columns);
        fillSnakesAndLadders(snakes, ladders);
    }
    
    //Method to initialize the board, is called from the constructor
    public void initBoard(int rows, int columns){
        this.tail = null;
        this.head = new Box(1); //Se crea a la cabeza del board con el número 1.
        this.size = rows * columns; //Se halla el tamaño total del board, es decir, la cantidad de boxes que habrá.
        initBoard(size, head, 2); //Se comienza a crear el resto del tablero desde el número 2.
    }

    private void initBoard(int size, Box current, int number){
        if(number > size){ //Si el identificador (number) es mayor que el tamaño del board, se sale.
            return;
        }

        Box newBox = new Box(number); //Se crea el nuevo nodo (Box) del board.
        current.setNext(newBox); //Se crea la relación entre los nodos.
        newBox.setPrevious(current);
        tail = newBox; //Se pone como tail a la última caja creada.
        initBoard(size, current.getNext(), number + 1); //Se hace la recursividad hasta el tamaño del board.
    }

    // Print 

    public void print(){
        if(head == null){
            System.out.println("Lista vacia");
        }else{
          if (this.rows % 2 == 0) { //Si la cantidad de filas es par, se llama al método privado que comienza desde 2 para imprimir primero
              //al actual y después al resto de la fila.
                print(tail,2);
            }else{
                print(tail,1); //Si es impar, se comienza a imprimir desde el que más está a la derecha hasta el current.
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
        if (row % 2 == 0) { //Si la fila es par, imprime primero el current y luego el resto de la fila
          //Pair
          System.out.print(current.toString());
          boxito = printRow(current.getPrevious(), row, column += 1);

        } else { //Si la fila es impar, imprime primero al que más está a la izquierda hasta el current que el que está a la derecha
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
      int posHead = random.nextInt(3, this.size); //Comienza desde 3 porque al ser cabeza, debe de dejar por lo menos una casilla atrás.
      //Y ninguna serpiente ni escalera puede empezar en la primera casilla.
      Box headBox = getBoxByNumber(posHead); //Apunta a la cabeza.
      if (headBox.getIsSnake() || headBox.getIsLadder()) {//Si esa posición ya es una serpiente o escalera, se hace recursividad.
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
      headBox.setIdentifier(counter + 65);//Crea la serpiente a partir del contador y el ASCCI.
      tailBox.setIdentifier(counter + 65);
      headBox.setTailSnake(tailBox); //Se hace el link entre la cabeza y la cola de la serpiente.
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

    public void printSnakesAndLadders(){
      if(head == null){
          System.out.println("Lista vacia");
      }else{
          if(this.rows%2==0){
              printSnakesAndLadders(tail,2);
          }else{
              printSnakesAndLadders(tail,1);
          }
          
      }
  }

  private void printSnakesAndLadders(Box current, int row){
      int rows = this.rows;
      if(this.rows%2==0){
          rows+=1;
      }
      if(row > rows){
         return;
      }else{
          Box newCurrent = printRowSnakesAndLadders(current, row, 1);
          System.out.println("");
          printSnakesAndLadders(newCurrent, row+=1);
      }

  }

  private Box printRowSnakesAndLadders(Box current, int row, int column) {
    Box boxito;
    if (column > this.columns - 1) {
      System.out.print(current.toStringSnakesAndLadders());
      return current.getPrevious();

    } else {
      if (row % 2 == 0) {
        //Pair
        System.out.print(current.toStringSnakesAndLadders());
        boxito = printRowSnakesAndLadders(current.getPrevious(), row, column += 1);

      } else {
        //Odd

        boxito = printRowSnakesAndLadders(current.getPrevious(), row, column += 1);
        System.out.print(current.toStringSnakesAndLadders());
      }
    }
    return boxito;
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
