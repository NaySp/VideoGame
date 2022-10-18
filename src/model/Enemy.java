package model;
import java.util.Random;



public class Enemy {



	private String idEnemy;

	private TypeEnemy typeEnemy;

    private int giveScore;
	private int takeScore;

	private Level level;

    private int posx;
    private int posy;
	


	public Enemy(String idEnemy, int typeEnemy, int giveScore, int taketScore, int x, int y) {
		this.idEnemy = idEnemy;
		this.giveScore = giveScore;
		this.takeScore = takeScore;
        
		this.posx = x;
		this.posy = y;


		switch(typeEnemy){
			case 1:
				this.typeEnemy = TypeEnemy.OGRO;
				break;

			case 2:

				this.typeEnemy = TypeEnemy.ABSTRACT;
				break;

			case 3:

				this.typeEnemy = TypeEnemy.BOSS;
				break;

			case 4:

				this.typeEnemy = TypeEnemy.MAGICAL;	
				break;
			

		}
	}

    
	/** 
	 * @return String the id enemy
	 */
	public String getidEnemy() {
		return idEnemy;
	}

	
	/** 
	 * @return Level the level 
	 */
	public Level getLevel(){
		return level;
	}

	
	/** 
	 * @param idEnemy the id enemy means name enemy
	 */
	public void setidEnemy(String idEnemy) {
		this.idEnemy = idEnemy;
	}

	
	/** 
	 * @return int the score that gives if the user kill it
	 */
	public int getGiveScore(){
		return giveScore;
	}

	
	/** 
	 * @param giveScore set the give score
	 */
	public void setGiveScore(int giveScore){
		this.giveScore = giveScore;
	}

	
	/** 
	 * @return int types of enemies
	 */
	public int getType(){
		switch(typeEnemy){
			case OGRO:
				return 1;

			case ABSTRACT:
				return 2;

			case BOSS:
				return 3;

			case MAGICAL:
				return 4;
				
			default:
				return 0;	
		}
	}

	
	/** 
	 * @return String information about everithing of the enemy
	 */
	public String toString(){
		return
		"Information about enemy: \n" +
		"Identification of enemy:" + this.idEnemy + "\n"+
		"Type enemy: " + this.typeEnemy + "\n "+
		"Score that gives:" + this.giveScore + "\n "+
		"Score that takes:" + this.takeScore + "\n "; 

	}


}