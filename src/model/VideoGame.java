package model;
import model.*;

public class VideoGame{
   
    public static final int SIZE_OF_PLAYERS = 20; 
    public static final int LEVEL_SIZE = 10;
    public static final int ALL_ENEMIES = 25; 
    public static final int ALL_TREASURES = 50;

    private int x;
    private int y;


    private Player[] players;
    private Level[] levels;
    private Enemy[] enemies;
    private Treasure[] treasures;

    public VideoGame(){
        players = new Player[SIZE_OF_PLAYERS];
        levels = new Level[LEVEL_SIZE];
        enemies = new Enemy[ALL_ENEMIES];
        treasures = new Treasure[ALL_TREASURES];

        levels[0] = new Level(0, 5, 5);

    }

    
    public Player[] getPlayers(){
        return players;
    }

    public Level[] getLevel(){
        return levels;
    }

    public Enemy[] getEnemy(){
        return enemies;
    }
    
    public String addPlayer(String name, String idNick){
        String msj = " ";
       
        int compareIdNick = searchPersonById(idNick);

        if(compareIdNick != -1){
            msj = "This id already exits, try other. ";

        } else{

            Player newPlayer = new Player(name, idNick, 0);
            msj = "The capacity of players is full.";
            boolean isEmpty = false;

            for(int i = 0; i<SIZE_OF_PLAYERS && !isEmpty; i++){
                if(players[i] == null){
                    players[i] = newPlayer;
                    isEmpty = true;
                    msj = "New player added.";
                }
            }

        }
        return msj;
    }

    public String addLevel(int idLevel, int scoreNeccesary, int totalTreasures){
        

        String msj = " ";
        int compareIdentLevel = searchLevelByIdent(idLevel);

        if(idLevel == -1 || scoreNeccesary == -1 || totalTreasures == -1){
            msj = "Do not type letters if it requieres numbers. ";

        }else if(compareIdentLevel != -1){
            msj = "This identification level already exits, try other. ";

        } else{

            Level newLevel = new Level (idLevel, scoreNeccesary, totalTreasures);

            msj = "Can not add level, try again. ";
            boolean isEmpty = false;

            for(int i = 0; i<LEVEL_SIZE && !isEmpty;  i++){

                if(levels[i] == null && idLevel <= 10 && idLevel > 0){
                    levels[i] = newLevel;
                    isEmpty = true;
                    msj = "New level added.";
                }
            }

        }
        return msj;
    }

    public boolean hasEmptypos(){
        boolean isEmpty = false;
        for(int i = 0; i < SIZE_OF_PLAYERS && !isEmpty; i++){
            if(players[i] == null){
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    public int searchPersonById(String idNick){

        int pos = -1;
        boolean isFound = false;
    
        for (int i = 0; i < SIZE_OF_PLAYERS && !isFound; i++){

            if(players[i] != null && players[i].getidNick().equalsIgnoreCase(idNick)){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }
    
    public int searchLevelByIdent(int idLevel){
        int pos = -1;
        boolean isFound = false;

        for (int i = 0; i < LEVEL_SIZE && !isFound; i++){

            if(levels[i] != null){
                if(levels[i].getidLevel() == idLevel){
                pos = i;
                isFound = true;
                }
            }
        }
        return pos;
    }

    public int searchEnemy(String idEnemy, int idLevel){
        int pos = -1;
        boolean isFound = false;
        int posLevel = searchLevelByIdent(idLevel);
        for(int i = 0; i < ALL_ENEMIES && !isFound; i++){
            if(levels[posLevel].getEnemies()[i].getidEnemy().equalsIgnoreCase(idEnemy)){
                pos = i;
                isFound = true;
            } 
        }
        return pos;
    }
 
    public String addEnemyToLevel(String idEnemy, int typeEnemy, int giveScore, int takeScore, int idLevel){
         
        String msj = " ";
        Enemy newEnemy = new Enemy(idEnemy, typeEnemy, giveScore, takeScore, x, y);
        int posLevel = searchLevelByIdent(idLevel);
        boolean isAddedEnemyToLevel = false;
        int x = 1;
        int y = 2;
       
        if(typeEnemy == -1 || giveScore == -1 || takeScore == -1 || idLevel == -1){
            msj = "Do not type letters if it requieres numbers. ";
        }else if(posLevel == -1){
            msj = "This level does not exist. ";
        }
        else{

            for(int i = 0; i < ALL_ENEMIES && !isAddedEnemyToLevel; i++){
                if(levels[posLevel].getEnemies()[i] == null){
                    msj = levels[posLevel].addEnemyLevel(newEnemy);

                    isAddedEnemyToLevel = true;

                }

            }           

        }
        return msj;

    }

    public String addTreasureToLevel(String nameTreasure, int idLevel, String urlTreasure, int plusTreasure, int treasureForLevel){
        String msj = "Something went wrong. ";
        Treasure newTreasure = new Treasure(nameTreasure, urlTreasure, plusTreasure, treasureForLevel);
        int posLevel = searchLevelByIdent(idLevel);

        if(idLevel == -1 || plusTreasure == -1 || treasureForLevel == -1){
            msj = "Do not type letters if it requieres numbers. ";
        }else if(posLevel != -1){
            msj = levels[posLevel].addTreasureLevel(newTreasure);
        }
        return msj;

    }

    public String modifyScore(int playerScore, String idNick){
        String msj = "Player's score modified successfully. ";
        for(int i = 0; i < SIZE_OF_PLAYERS; i++){
            if(players[i] != null && players[i].getidNick().equalsIgnoreCase(idNick)){
                players[i].setScore(playerScore);


            }
        }
        return msj;
    }

    public String changeScore(int scorePlayer, String idNick){
        String msj = "Something went wrong. ";
        int posPlayer = searchPersonById(idNick);

        if(scorePlayer == -1){
            msj = "Do not type letters if it requieres numbers. ";
        }else if(posPlayer != -1){
            msj = modifyScore(scorePlayer, idNick);
        }
        return msj;
    }

    public String IncreaseLevelPlayer(String idNick){
        String msj = ("Something went wrong. Could not increase level of the player. ");
        int posPlayer = searchPersonById(idNick);

        for(int i = 0; i < SIZE_OF_PLAYERS; i++){
            if(players[i] != null && players[i].getidNick().equalsIgnoreCase(idNick)){
                if(posPlayer == -1){
                    msj = "The idNick does not match.";
                }else if(players[i].getScore() < levels[players[i].getLevel()].getScoreNeccesary()){
                    msj = "The player does not have the score required for increase level. ";    
                }else if(players[i].getLevel() == 10){
                    msj = "Tha player already get max level. ";
                }else{
                    players[i].setLevel(players[i].getLevel());
                    msj += "\n Level increase for: " +players[i].getLevel() +"\n\n";
                }
            }
        }
        return msj;

    }

    public String listEnemies(int level){
        String msj = "ENEMY ";
        for(int i = 0; i < ALL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getLevel().getidLevel() == level){
                msj += enemies[i].getidEnemy() + ", ";
            }
        }
        return msj;
    }

    public String listTreasures(int level){
        String msj = "TREASURE ";
        for(int i = 0; i < ALL_TREASURES; i++){
            if(treasures[i] != null && treasures[i].getLevel().getidLevel() == level){
                msj += treasures[i].getTreasureName()+ ", ";
            }
        }
        return msj;
    }
 
    public String informTreasureAndEnemy(int levelShow){
        String msj = "";
        
        if(levelShow != -1){
           int pos = searchLevelByIdent(levelShow);

           for(int i = 0; i < ALL_TREASURES; i++){
                if(levels[pos].treasures[i] != null){
                    msj += levels[pos].treasures[i].getTreasureName() +", ";  
                }              
            }

           for(int i = 0; i < ALL_ENEMIES; i++){
                if(levels[pos].enemies[i] != null){
                    msj += levels[pos].enemies[i].getidEnemy() +", "; 
                }
            }
      
        }
        return msj;

    }

    public String listOfOneTreasure(String nameTreasure){

        String msj = "Something went wrong.";
        int num = 0;

        for(int i = 0; i < LEVEL_SIZE; i++){
            if(levels[i] != null){
                for(int h = 0; h < ALL_TREASURES; h++){
                    if(levels[i].treasures[h] != null){
                        if(levels[i].treasures[h].getTreasureName().equalsIgnoreCase(nameTreasure)){
                        num++;
                        msj = "Exists " + num + " of that treasure.";
                        }
                    }                        
                }
            }
        }
        return msj;
    }

    public String ListOfOneEnemy(int type){

        String msj = "Something went wrong, maybe that enemy does not exists.";
        int num = 0;

        for(int i = 0; i < LEVEL_SIZE; i++){
            if(levels[i] != null){
                for(int h = 0; h < ALL_ENEMIES; h++){
                    if(levels[i].enemies[h] != null){
                        if(levels[i].enemies[h].getType() == type){
                        num++;
                        msj = "Exists " + num + " of that enemies.";
                        }
                    }                        
                }
            }
        }
        return msj;

    }

    public String mostTreasureRepeated(){
        String msj = "Something went wrong. Maybe there are no treasures \n";
        int num = 0;
        int maxTreasure = 0;
        String nameMostRepeated = null;

        for(int z = 0; z < LEVEL_SIZE; z++){
            if(levels[z] != null){
                for(int i = 0; i < ALL_TREASURES; i++){
                    if(treasures[i] != null){
                        for(int h = 0; h < ALL_TREASURES; h++){
                            if(treasures[h] != null){
                                if(treasures[i].getTreasureName().equalsIgnoreCase(treasures[h].getTreasureName())){
                                    num ++;
                                }
                            }
                        }
                        if(num > maxTreasure){
                            maxTreasure = num;
                            nameMostRepeated = treasures[i].getTreasureName();
                        }
                        
                    }
                }

            }

        }
        msj = "The most repeated is: "+ nameMostRepeated;
        return msj;

    }
    
    public String showEnemyGivesMaxScore(){

        String msj = " ";
        int max = 0;
        int numLevel = 0;
        String maxName = "";

        for(int i = 0; i < LEVEL_SIZE; i++){
            if(levels[i] != null){
                for(int h = 0; h < ALL_ENEMIES; h++){
                    if(levels[i].enemies[h] != null){
                        if(levels[i].enemies[h].getGiveScore() > max){
                            max = levels[i].enemies[h].getGiveScore();
                            maxName = levels[i].enemies[h].getidEnemy();
                            numLevel = levels[i].getidLevel();
                        }

                    }                                                         
                }
            }
        }
        msj = ("The enemy with highest score is " +maxName + " and give " +max+ " of Score and it is in level " +numLevel);
        return msj;

    }

    public String consonantsOfEnemies(){

		String cadena = "There are no consonants in enemies name.";
		int con = 0;

        for(int h = 0; h < levels.length ; h++){
            if(levels[h] != null){
                con += levels[h].countEnemiesConsonant();
            }
        }
		if(con>0){
            cadena = "there are "+ con + " consonants in enemies names.";
        }
        return cadena;
		
	}

    public String topfive(){
        String msj;
        
        return msj;
    }



}