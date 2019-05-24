
public class Player {	//Dummy Player Class
	private static int livesLeft = 3;
	private static int currentRoom = 0;
	
	private Player() {
	}
	
	public static int getLives() {
		return livesLeft;
	}
	
	public static int getCurrentRoom() {
		return currentRoom;
	}
	
	public static void updateCurrentRoom() {
		currentRoom++;
	}
}
