package model;

public class Treasure{

    public static final int ALL_TREASURES = 50;
    private String nameTreasure;
    private String urlTreasure;
    private int givePlayer;
    private double pixelesPos;
    private int treasureForLevel;

    public Treasure(String nameTreasure, String urlTreasure, int givePlayer, int treasureForLevel){
        this.nameTreasure = nameTreasure;
        this.urlTreasure = urlTreasure;
        this.givePlayer = givePlayer;
        this.treasureForLevel = treasureForLevel;

    }

    public String getTreasureName(){
        return nameTreasure;
    }

    public void setNameTreasure(String nameTreasure){
        this.nameTreasure = nameTreasure;
    }

    public String getUrl(){
        return urlTreasure;
    }

    public void setUrl(String urlTreasure){
        this.urlTreasure = urlTreasure;
    }

    public int getGivePlayer(){
        return givePlayer;
    }

    public void setGivePlayer(){
        this.givePlayer = givePlayer;
    }


}