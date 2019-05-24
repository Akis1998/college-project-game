
public class Player {
	
	private static int id;
	private static int lives=3;
	private static int current_level = 0;
	private static double score;
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
	public static String printScore() {
		return "Hey"+name+"\nYour score is"+score;
	}

	public static int getCurrentLevel() {
		return current_level;
	}
	
	public static void updateCurrentLevel() {
		current_level++;
	}

}
