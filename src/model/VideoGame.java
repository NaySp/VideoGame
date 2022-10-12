package model;

import model.Player;
import model.Level;

public class VideoGame{
   
    public static final int SIZE_OF_PLAYERS = 20; 
    public static final int LEVEL_SIZE = 10;
    private Player[] players;
    private Level[] levels;

    public VideoGame(){
        players = new Player[SIZE_OF_PLAYERS];
        levels = new Level[LEVEL_SIZE];
    }

    public Player[] getPlayers(){
        return players;
    }

    public Level[] getLevel(){
        return levels;
    }


    public String addPlayer(String name, String idNick){
        String msj = " ";
       
        int compareIdNick = searchPersonById(idNick);

        if(compareIdNick != -1){
            msj = "This id already exits, try other. ";

        } else{

            Player newPlayer = new Player(name, idNick);
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

    public String addLevel(String identName){
        String msj = " ";

        int compareIdentLevel = searchLevelByIdent(identName);

        if(compareIdentLevel != -1){
            msj = "This identification level already exits, try other. ";

        } else{

            Level newLevel = new Level (identName);

            msj = "The levels are full.";
            boolean isEmpty = false;

            for(int i = 0; i<LEVEL_SIZE && !isEmpty; i++){
                if(levels[i] == null){
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
    
    public int searchLevelByIdent(String identName){

        int pos = -1;
        boolean isFound = false;

        for (int i = 0; i < LEVEL_SIZE && !isFound; i++){

            if(levels[i] != null && levels[i].getidentName().equalsIgnoreCase(identName)){
                pos = i;
                isFound = true;
            }
        }
        return pos;

    }



}