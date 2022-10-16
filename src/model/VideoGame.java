package model;
import model.*;

public class VideoGame{
   
    public static final int SIZE_OF_PLAYERS = 20; 
    public static final int LEVEL_SIZE = 10;
    public static final int ALL_ENEMIES = 25; 

    private int x;
    private int y;


    private Player[] players;
    private Level[] levels;
    private Enemy[] enemies;

    public VideoGame(){
        players = new Player[SIZE_OF_PLAYERS];
        levels = new Level[LEVEL_SIZE];
        enemies = new Enemy[ALL_ENEMIES];

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

            Player newPlayer = new Player(name, idNick, levels[0]);
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

        
        if(compareIdentLevel != -1){
            msj = "This identification level already exits, try other. ";

        } else{

            Level newLevel = new Level (idLevel, scoreNeccesary, totalTreasures);

            msj = "Can not add level, try again. ";
            boolean isEmpty = false;

            for(int i = 0; i<LEVEL_SIZE && !isEmpty; i++){

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


    public String posEnemy(){
        String msj = "spaces availables ";
        if(enemies[0] == null){
            msj = "There are not enemies. "; 
        }else if(enemies[ALL_ENEMIES-1] != null){
            msj = "The limit of enemies is complete. ";
        }
        return msj;
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
       
    
        if(posLevel == -1){
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
        if(posLevel != -1){
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
        if(posPlayer != -1){
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
                }else if(players[i].getScore() < players[i].getLevel().getScoreNeccesary()){
                    msj = "The player does not have the score required for increase level. ";    
                }else if(players[i].getLevel().getidLevel() == 10){
                    msj = "Tha player already get max level. ";
                }else{
                    players[i].setLevel(levels[players[i].getLevel().getidLevel()]);
                    msj += "\n Level increase for: " +players[i].getLevel().getidLevel() +"\n\n";
                }
            }
        }
        return msj;

    }




}