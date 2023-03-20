package ui;
import java.util.Scanner;

import model.LinkedListPlayerNode;
import model.Player;
import model.PlayersList;
import model.PointTree;
import model.SnakesAndLadders;

public class Main {
    private Scanner reader;
    private SnakesAndLadders game;
    private PointTree pointTree;

    public Main() {
        reader = new Scanner(System.in);
        pointTree = new PointTree();
	}
    public static void main(String[] args) {
        
		Main main = new Main();
        main.cleanConsole();        
        main.menuController(-1);

		main.getReader().close();
    
    }

    public void menuController(int option){
        if(option != 0){
            game = new SnakesAndLadders();
            option = getOptionShowMenu(); 
            if (option != 2) cleanConsole();
			executeOption(option);
            try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            if (option != 2) cleanConsole();
            menuController(option);
            
        }
        return;
    }

    public int getOptionShowMenu(){
        int option = 0; 
        System.out.println("<<<<< Snakes And Ladders >>>>>");
        System.out.println(
                "1. Jugar\n" +
                "2. Ver top 5 de puntajes\n" +
                "0. Exit. ");
        option =  validateIntegerInput();
        return option; 
    }

    public void executeOption(int option){;
        switch(option) {
            case 2:
                uiShowTop5Score();
                break;
            case 1 :
                game.setPlayerList(new PlayersList());
                uiInitializeBoard();
                uiChoosePlayers(1);
                game.initTimer();
                play(0);
                break;
            case 0: 
                
                break; 
            default: 
                System.out.println("Invalid Option");
                break; 
        }
    }
    
    public Scanner getReader(){
        return reader; 
    }

    public int validateIntegerInput(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.nextLine(); 
            option = -1; 
        }
        return option; 
    }

    public void uiInitializeBoard(){
        int rows;
        int columns;
        boolean repeat = false;
        do {
            System.out.println("Input the rows and columns (Minimum 4 each, Maximum 20 each)");
            System.out.print("Rows: ");
            rows = validateIntegerInput();
            System.out.print("Columns: ");
            columns = validateIntegerInput();
            if(rows < 4 || columns < 4 || rows > 20 || columns > 20) repeat = true;
            if(repeat) System.out.println("Wrong ammount of columns and/or rows.");
        } while (repeat);
        int snakes;
        int ladders;
        int maxSnakesAndLadders = rows * columns/3;
        do {
            System.out.println("Input the snakes and ladders (The sum of the quantity must not exceed " + maxSnakesAndLadders +  ")");
            System.out.println("Also there's a limit of max 26 snakes.");
            System.out.print("Snakes: ");
            snakes = reader.nextInt();
            System.out.print("Ladders: ");
            ladders = reader.nextInt();
            if(snakes + ladders > maxSnakesAndLadders || snakes > 26) System.out.println("Too much snakes and/or ladders, please try again.");
        } while (snakes + ladders > maxSnakesAndLadders || snakes > 26);
        game.initializeBoard(rows, columns, snakes ,ladders);
    }

    public void uiChoosePlayers(int countPlayer){
        if(countPlayer <= game.NUMBER_OF_PLAYERS) {
            boolean playerExists = false;
            LinkedListPlayerNode controllerPlayer;
            LinkedListPlayerNode boxPlayer;
            do {
                System.out.println("Choose the player " + countPlayer + " : * ! O X % $ # + &");
                String name = reader.next();
                controllerPlayer = new LinkedListPlayerNode(new Player(name));
                boxPlayer = new LinkedListPlayerNode(new Player(name));
                playerExists = game.getPlayerList().checkIfPlayerExists(name);
                if(playerExists) System.out.println("A player with this name already exists, choose another.");
            } while (playerExists);
            game.addPlayer(controllerPlayer, boxPlayer);
            uiChoosePlayers(countPlayer += 1);
        }else{
            return;
        }
    }

    public void play(int previousOption){
        if (previousOption != 2) game.getBoard().print();
        uiShowPlayerOptions();
        int option = validateIntegerInput();
        System.out.println(game.play(option));
        if(game.getFinishGame()){
            float score = (600 - game.getTimer()) / 6;
            uiSetPlayerScoreOnBoard(score);
            return;
        }
        play(option);
    }

    public void uiShowPlayerOptions(){
        System.out.println("Jugador " + game.getCurrentPlayerName() + ", es tu turno.");
        System.out.println("1. Tirar dado");
        System.out.println("2. Ver escaleras y serpientes");
    }

    public void uiSetPlayerScoreOnBoard(double score){
        System.out.println("Tu puntaje a sido: " + score);
        System.out.println("Ingresa el nombre que deseas que se guarde en la lista de puntajes");
        reader.nextLine();
        String name = reader.nextLine();
        pointTree.addScoreToTree(score, name);
    }

    public void uiShowTop5Score(){
        pointTree.inOrderTop5();
    }

    public void cleanConsole(){
        System.out.print("\033[H\033[2J");
    }

}