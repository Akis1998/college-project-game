
public class Player {
	
	
	private static int lives = 3;
	private static int current_room = 1;
	private static int score = 0;
	private static double time;
	private static String name;
	private static boolean skipAvailable = true;
	private static int timeLeft= 10;
	
	
	public static int getScore() {
		return score;
	}
	
	public static void updateScore(/*int points*/) {	//Need Implementation!
		int x = 1000;
		
		score = score + x;
	}
	
	public static int getLives() {
		return lives;
	}
	
	public static void addALife() {
		lives += 1;
	}
	
	public static void removeALife() {
		lives -= 1;
	}
	
	public static int getRemainingTime() {
		return timeLeft;
	}
	
	public static void reduceTime(int time) {
		timeLeft-=time;
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
	
	public static boolean isSkipAvailable() {
		return skipAvailable;
	}
	
	public static void setSkipNotAvailable() {
		skipAvailable = false;
	}
}
