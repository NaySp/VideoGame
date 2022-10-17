package model; 

public class Level{

	public static final int ALL_ENEMIES = 25; 
	public static final int ALL_TREASURES = 50;


	private int idLevel;  
	private int scoreNeccesary;
	private int totalTreasures;

	protected Enemy[] enemies;
	protected Treasure[] treasures;


	public Level (int idLevel, int scoreNeccesary, int totalTreasures){
		this.idLevel = idLevel;
		this.scoreNeccesary = scoreNeccesary;
		this.totalTreasures = totalTreasures;
		enemies = new Enemy[ALL_ENEMIES];
		treasures = new Treasure[ALL_TREASURES];


	}

	public int getidLevel(){
		return idLevel;
	}
	
	public void setidLevel(int idLevel){
		this.idLevel = idLevel;
	}

	public Enemy[] getEnemies(){
		return enemies;
	}
	
	public Treasure[] getTreasures(){
		return treasures;
	}
	
	public int getScoreNeccesary(){
		return scoreNeccesary;
	}

	public String addEnemyLevel(Enemy enemy){
        String msj = "Can not add enemy. ";
        boolean isEmpty = false;
        for(int i = 0; i < ALL_ENEMIES && !isEmpty; i++){
            if(enemies[i] == null){
                enemies[i] = enemy;
                isEmpty = true;
                msj = "Enemy added successfully "; 
            }
        }
        return msj;
    }

	public String addTreasureLevel(Treasure treasure){
		String msj = "Limit of treasures has been reached. ";
		boolean isEmpty = false;
		for(int i = 0; i< ALL_TREASURES && !isEmpty; i++){
			if(treasures[i] == null){
				treasures[i] = treasure;
				isEmpty = true;
				msj = "Treasure successfully added. ";
			}
		}
		return msj;
	}

	public int countEnemiesConsonant(){

		int num = 0;
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i] != null){
				num++;
			}
		}
		return num;
	
	}
	
}


