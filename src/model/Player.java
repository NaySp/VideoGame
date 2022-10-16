package model;

public class Player{

	public static final int TOTAL_CLASSIFICATION = 5;

	private String name;
	private String idNick;
	private int score;

	public Player(String name, String idNick, Level level) {
		this.name = name;
		this.idNick = idNick;	
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


}