package model;

public class Player{

	public static final int TOTAL_CLASSIFICATION = 5;

	private String name;
	private String idNick;
	


	public Player(String aname, String aidNick) {
		name = aname;
		idNick = aidNick;	
	}

    public String getName() {
		return name;
	}

	public void setName(String aname) {
		name = aname;
	}

	public String getidNick(){
		return idNick;
	}




}