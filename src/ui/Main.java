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
				"7. List treasures and enemies of a level. \n"+
				"8. List all treasures of one type. \n"+
				"9. List all enemies of one type. \n"+
				"10. Inform the most repeated treasure in all levels. \n"+
				"11. Inform the enemy that gives the highest score and the level where is located.\n"+
				"12. Inform the number of consonants found in the names of enemies in the game.\n"+
				"13. Show the top 5 of the players according to the score. \n"+
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

	public int validateInt(){
		int option = 0;
		
		if(reader.hasNextInt()){
			option = reader.nextInt();
		}
		else{
			reader.next();
			option = -1;
		}

		return option;
	}


    public void executeOption(int option){

        String msj;
		String msg;
		
		String namePlayer;
        String id;
		String idEnemy;
		String nameTreasure;
		String urlTreasure;
		
		int consonat;
		int idLevel;
		int scoreNeccesary;
		int totalTreasures;
		int enemyType;
		int giveScore;
		int takeScore;
		int plusTreasure;
		int treasureForLevel;
		int levelShow;
		int toLevel;
		

		
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
				idLevel = validateInt();
				System.out.println("Type the score that will be neccesary to reach the next level: ");
				scoreNeccesary = validateInt();
				System.out.println("Type how many treasures you want in this level: ");
				totalTreasures = validateInt();


				msj = videoGame.addLevel(idLevel, scoreNeccesary, totalTreasures);
				System.out.println(msj);
			
                break;
			case 3: 

				System.out.println("Type the number of the level that you want to add the new enemy:");
				idLevel = validateInt();

				System.out.println("Type an identification for the enemy: ");
				idEnemy = reader.next();

				System.out.println("Type which option of these enemies you want to choose:\n"+
				"\n1. Ogro"+
				"\n2. Abstracto"+
				"\n3. Jefe"+
				"\n4. Magico");
				enemyType = validateInt();

				System.out.println("Type how much score this enemy will give: ");
				giveScore = validateInt();

				System.out.println("Type how much score this enemy will take: ");
				takeScore = validateInt();

				msj = videoGame.addEnemyToLevel(idEnemy, enemyType, giveScore, takeScore, idLevel);
				System.out.println(msj);

				break; 

			case 4:

				System.out.println("Type a name for the treasure: ");
				nameTreasure = reader.next();

				System.out.println("Type the number of the level that u want to register this treasure: ");
				idLevel = validateInt();

				System.out.println("Type the link (url) of the treasure: ");
				urlTreasure = reader.next();

				System.out.println("Type how much score this treasure will give: ");
				plusTreasure = validateInt();

				System.out.println("Type how many of this treasure u want in this level: ");
				treasureForLevel = validateInt();

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

				System.out.println("Type the idNick of the player that u want to increase of level: ");
				id = reader.next();
				System.out.println("Type the new level where u want to change player. ");
				toLevel = validateInt();
				
				msj = videoGame.IncreaseLevelPlayer(id, toLevel);
				System.out.println(msj);


				break;

			case 7: 

				System.out.println("Type the level that u want to search for treasures and enemies: ");
				levelShow = validateInt();
				msj = videoGame.informTreasureAndEnemy(levelShow);
				System.out.println(msj);

			
				break;

			case 8:

				System.out.println("Type the name of the treasure u want to list: ");
				nameTreasure = reader.next();
				msj = videoGame.listOfOneTreasure(nameTreasure);
				System.out.println(msj);


				break;

			case 9:

				System.out.println("Type which enemy u want to list:\n"+
				"\n 1. OGRO"+
				"\n 2. ABSTRACT"+
				"\n 3. BOSS"+
				"\n 4. MAGICAL");
				enemyType = validateInt();
				msj = videoGame.ListOfOneEnemy(enemyType);
				System.out.println(msj);

				break;

			case 10:
				System.out.println(" == The most repeated treasure in all levels is ==");
				

				break;
			
			case 11:
				System.out.println(" ==    ==");
				msj = videoGame.showEnemyGivesMaxScore();
				System.out.println(msj);


				break;

			case 12:
				System.out.println("- The number of consonants in enemies name are: ");
				consonat = videoGame.consonantsOfEnemies();
				System.out.println(consonat);

				break;

			case 13:

				System.out.println("<=== Here is top 5 ===>");
				msj = videoGame.topfive();
				System.out.println(msj);

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