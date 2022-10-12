package model;

public class Enemy{

	private String nameEnemy;
	private String typeEnemy;
    private double doScore;
    private String posx;
    private String posy;
	


	public Player(String anameEnemy, String atypeEnemy, double adoScore) {
		nameEnemy = anameEnemy;
		typeEnemy = atypeEnemy;
        doScore = adoScore;
	}

    public String getName() {
		return name;
	}

	public void setName(String anameEnemy) {
		nameEnemy = anameEnemy;
	}
	
}