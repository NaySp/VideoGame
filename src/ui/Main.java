package ui;

import java.util.Scanner;
import model.VideoGame;

public class Main{

    private Scanner reader;
	private VideoGame videoGame;

    public Main(){
        reader = new Scanner(System.in);
		videoGame = new VideoGame();
    }
    
    public Scanner getReader(){
		return reader;
	}

	public VideoGame getVideoGame(){
		return videoGame;
	}

    public static void main(String[] args){
        Main main = new Main();
        int option = 0;
                do{
                    option = main.getOptionShowMenu();
                    main.executeOption(option);

                }while(option !=0);

                main.getReader().close();

    }

    public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to the Video Game >>>>>");
		System.out.println(
				"1. Add player. \n" +
				"2. Add level. \n"+
				"3. Add enemy to a level. \n"+
				"4. Register treasure to a level. \n"+
				"5. Modify a player's score. \n"+
				"6. Increase level for a player. \n"+
				"7. \n"+
				"8. \n"+
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

    public void executeOption(int option){

        String namePlayer;
        String id;
        String msj;
		String identName;
		
		
	
		switch(option){
			case 1: 

                System.out.println("Type the name of the new player: ");
                namePlayer = reader.next();
                System.out.println("Please type your id. ");
                id = reader.next();
				msj = videoGame.addPlayer(namePlayer, id);
				System.out.println(msj);

				break; 

			case 2: 

				System.out.println("Type an idenfification for the level you want to create :p ");
				identName = reader.next();
				msj = videoGame.addLevel(identName);
				System.out.println(msj);
			
                break;
			case 3: 
	
				break; 
			case 4:

				break;
			case 0:
				//Ends the program 
				System.out.println("Vuelve pronto ;) ");
				break; 

			default: 
				//This happens if the person introduces an option that doesnt exist
				System.out.println("Opcion Invalida");
				break; 
		}
	}

}