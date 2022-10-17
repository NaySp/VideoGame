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
    
    /**
     * This method allows the user to add a player to the array of players.
     * @param name The name of the new player
     * @param idNick The identification of the new player
     * @return msj Shows the user if the player was added or not. 
     * 
    */
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


    /**
     * This methow allows the user to add new levels in the array levels
     * @param id level this is an identification for the level that will be from 1 to 10
     * because the level 0 is already intialized.
     * @param scoreNeccesary it will be the point that the player has to get for pass the next level.
     * @param totalTreasures for level the user most type how many treasures the level would have.
     * @return msj is a message that shows if the level was added or not. 
    */
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

    /**
     *  This method will help us to search for an empty position and allows the method
     *  addLevel and addPlayer add the object in the firste empty space
     *  @return A boolean that indicates the availability in the arrays. 
     * 
     */
    public boolean hasEmptypos(){
        boolean isEmpty = false;
        for(int i = 0; i < SIZE_OF_PLAYERS && !isEmpty; i++){
            if(players[i] == null){
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    /**
     * This method allows to search for a player with it identification in the array of players.
     * @param idNicik the identification of the player
     * @return The player that was found.
     */
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
    
    /**
     * This method allows to search for a level with it identification (0-10) in the array of levels.
     * @param idLevel the identification of the level
     * @return the level object that was found.
     */
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

    /**
     * This method allows to search for a enemy with it name identification in the array of levels.
     * @param idEnemy the name of the enemy
     * @param idlevel the identification of the level
     * @return the enemy object was found.
     */
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
 
    /**
     * This method allows the user to add a enemy of a type to the levels.
     * @param IdEnemy the name of the new enemy
     * @param typeEnemy the type enemy "ogro, boss, magical, abstract"
     * @param giveScore the score that the enemy will give if the player kill it
     * @param takeScore The score that the enemy will take if hits the player
     * @param idLevel the identification of the level where the enemy will be added.
     * @return A message if the level was added or not.
     */
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

    /**
     * This method allows the user to add treasures to levels.
     * @param nameTreasure name of the new treasure
     * @param idLevel the identification of the level where the enemy will be added.
     * @param urlTreasure the url image of the treasure
     * @param plusTreasure the score that the player will get if obtains it
     * @param treasureForLevel how many treasures will be added in a level.
     * @return A message if the treasure was added or not.
     */
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

    /**
     * This method allows to modify a players score.
     * @param playerScore the score that the player has
     * @param idNicik the identification of the player
     * @return A message if the score was modified.
    */
    public String modifyScore(int playerScore, String idNick){
        String msj = "Player's score modified successfully. ";
        for(int i = 0; i < SIZE_OF_PLAYERS; i++){
            if(players[i] != null && players[i].getidNick().equalsIgnoreCase(idNick)){
                players[i].setScore(playerScore);
            }
        }
        return msj;
    }

    
    /**
     * This method allows to change a players score.
     * @param playerScore the score that the player has
     * @param idNicik the identification of the player
     * @return A message if the score was modified.
    */
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


    
    /**
     * This method allows to increase a player level if it has the neccessary score.
     * @param idNick the identification of the player
     * @return A message if the players level was modified or not.
    */
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
 
    
    /**
     * This method allows to know how many treasures and enemies are in a level.
     * @param levelShow The level where the enemy want to look
     * @return A message with the list.
    */
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


    
    /**
     * This method allows to know a treasure of a level and how many are.
     * @param nameTreasure the name of the treasure
     * @return A message with the quantity of treasures.
     */
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


    
    /**
     * This method allows to list how many enemies are of one type.
     * @param type the type of the enemy
     * @return A message with how many are of that enemy.
    */
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


    
    /**
     * This method shows the most repeated treasure with it quantity 
     * @return A message with the information.
    */
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
    
    /**
     * This method shows the enemy that gives more score if the player kill it 
     * and the level where it is
     * @return A message with the information.
    */
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


    /**
     * This method shows how many consonants have the enemies names.
     * @return A message with the information.
    */
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

    /**
     * This method shows the top five of players
     * @return A message with the information.
    */
    public String topfive(){
        String msj;
        
        return msj;
    }



}