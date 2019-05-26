package game1;

public class Player {
	
	private static int id;
	private static int lives=3;
	private static int current_room = 1;
	private static double score;
	private static double time;
	private static String name;
	
	public Player() {
		this.id=(int) Math.floor((Math.random() * 200) + 1);
		
	}
	
	
	public static double CalculateScore(int points) {
		//need to implement
		return 1;
	}
	
	
	public static int getLives() {
		return lives;
	}
	
	public static void addALife() {
		lives+=1;
	}
	
	public static void removeALife() {
		lives-=1;
	}
	public static String printScore() {
		return "Hey"+name+"\nYour score is"+score;
	}

	public static int getCurrentRoom() {
		return current_room;
	}
	
	public static void updateCurrentRoom() {
		current_room++;
	}

}
