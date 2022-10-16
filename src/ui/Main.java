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
				"3. Register enemy to a level. \n"+
				"4. Register treasure to a level. \n"+
				"5. Modify a player's score. \n"+
				"6. Increase level for a player. \n"+
				"7. \n"+
				"8. \n"+
				"9. \n"+
				"10. \n"+
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

    public void executeOption(int option){

        String msj;
		
		String namePlayer;
        String id;
		String idEnemy;
		String nameTreasure;
		String urlTreasure;
	
		int idLevel;
		int scoreNeccesary;
		int totalTreasures;
		int enemyType;
		int giveScore;
		int takeScore;
		int plusTreasure;
		int treasureForLevel;

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

				System.out.println("Type a number from 1 to 10 for the level you want to create :p ");
				idLevel = reader.nextInt();
				System.out.println("Type the score that will be neccesary to reach the next level: ");
				scoreNeccesary = reader.nextInt();
				System.out.println("Type how many treasures you want in this level: ");
				totalTreasures = reader.nextInt();


				msj = videoGame.addLevel(idLevel, scoreNeccesary, totalTreasures);
				System.out.println(msj);
			
                break;
			case 3: 

				System.out.println("Type the number of the level that you want to add the new enemy:");
				idLevel = reader.nextInt();

				System.out.println("Type an identification for the enemy: ");
				idEnemy = reader.next();

				System.out.println("Type which option of these enemies you want to choose:\n"+
				"\n1. Ogro"+
				"\n2. Abstracto"+
				"\n3. Jefe"+
				"\n4. Magico");
				enemyType = reader.nextInt();

				System.out.println("Type how much score this enemy will give: ");
				giveScore = reader.nextInt();

				System.out.println("Type how much score this enemy will take: ");
				takeScore = reader.nextInt();

				msj = videoGame.addEnemyToLevel(idEnemy, enemyType, giveScore, takeScore, idLevel);
				System.out.println(msj);

				break; 

			case 4:

				System.out.println("Type a name for the treasure: ");
				nameTreasure = reader.next();
				System.out.println("Type the number of the level that u want to register this treasure: ");
				idLevel = reader.nextInt();
				System.out.println("Type the link (url) of the treasure: ");
				urlTreasure = reader.next();
				System.out.println("Type how much score this treasure will give: ");
				plusTreasure = reader.nextInt();
				System.out.println("Type how many of this treasure u want in this level: ");
				treasureForLevel = reader.nextInt();

				msj = videoGame.addTreasureToLevel(nameTreasure, idLevel, urlTreasure, plusTreasure, treasureForLevel);
				System.out.println(msj);

				break;

			case 5:
				System.out.println("Type the idNick of the player u want to modify score: ");
				id = reader.next();
				System.out.println("Type the new score for the player. ");
				System.out.println(videoGame.changeScore(reader.nextInt(), id));
				break;

			case 6:



				break;

			case 7:

				break;

			case 8:

				break;

			case 9:

				break;

			case 10:

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