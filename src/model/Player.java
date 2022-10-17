package model;

public class Player{

	public static final int TOTAL_CLASSIFICATION = 5;

	private String name;
	private String idNick;
	private int score;
	private int level;

	public Player(String name, String idNick, int level) {
		this.name = name;
		this.idNick = idNick;	
		score = 10;
		this.level = level;

	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getidNick(){
		return idNick;
	}

	public int getScore(){
		return score;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getLevel(){
		return level;
	}

	public void setLevel(int level){
		this.level = level;
	}


}