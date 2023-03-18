package ui;
import java.util.Scanner;


import model.LinkedListPlayerNode;
import model.Player;
import model.PlayersList;
import model.SnakesAndLadders;

public class Main {
    private Scanner reader;
    private SnakesAndLadders game;

    public Main() {
        reader = new Scanner(System.in);
	}
    public static void main(String[] args) {
        
		Main main = new Main(); 
        //main.cleanConsole();
		int option = 0; 
        
        main.menuController(-1);

		main.getReader().close();
    
    }

    public void menuController(int option){
        if(option != 0){
            game = new SnakesAndLadders();
            option = getOptionShowMenu(); 
            //cleanConsole();
			executeOption(option);
            reader.nextLine();
            reader.nextLine();
            //cleanConsole();
            menuController(option);
        }
        return;
    }

    public int getOptionShowMenu(){
        int option = 0; 
        System.out.println("<<<<< Snakes And Ladders >>>>>");
        System.out.println(
                "1. Jugar\n" +
                "0. Exit. ");
        option =  validateIntegerInput();
        return option; 
    }

    public void executeOption(int option){;
        switch(option) {
            case 1 :
                game.setPlayerList(new PlayersList());
                uiInitializeBoard();
                uiChoosePlayers(1);
                game.initTimer();
                play();
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
            // clear reader. 
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }

    public void uiInitializeBoard(){
        System.out.print("Rows: ");
        int rows = reader.nextInt();
        System.out.print("Columns: ");
        int columns = reader.nextInt();
        game.initializeBoard(rows, columns, 5 ,5);
    }

    public void uiChoosePlayers(int countPlayer){
        if(countPlayer <= game.NUMBER_OF_PLAYERS) {
            System.out.println("Choose the player " + countPlayer + " : * ! O X % $ # + &");
            String name = reader.next();
            LinkedListPlayerNode controllerPlayer = new LinkedListPlayerNode(new Player(name));
            LinkedListPlayerNode boxPlayer = new LinkedListPlayerNode(new Player(name));
            game.addPlayer(controllerPlayer, boxPlayer);
            uiChoosePlayers(countPlayer += 1);
        }else{
            return;
        }
    }

    public void play(){
        game.getBoard().print();
        uiShowPlayerOptions();
        int option = validateIntegerInput();
        System.out.println(game.play(option));
        if(game.getFinishGame()){
            float score = (600 - game.getTimer()) / 6;
            System.out.println("Tu puntaje a sido: " + score);
            return;
        }
        play();
    }

    public void uiShowPlayerOptions(){
        System.out.println("Jugador " + game.getCurrentPlayerName() + ", es tu turno.");
        System.out.println("1. Tirar dado");
        System.out.println("2. Ver escaleras y serpientes");
    }

    public void cleanConsole(){
        System.out.print("\033[H\033[2J");
    }

}