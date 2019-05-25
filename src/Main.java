import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		openNewGamePanel();
	}
	
	public static void openNewGamePanel() {
		
		Story.findQuestion(Player.getCurrentRoom());
		new GamePanel();
	}
}
