import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Player {
	
	private static String name;
	private static int lives = 3;
	private static int current_room = 1;
	private static boolean skipAvailable = true;
	private static int time = 300;
	private static int timeLeft= 10;
	private static int timeCounterStart = 300;
	private static int timeCounterEnd;
	private static int score = 0;
	
	public static int getLives() {
		return lives;
	}
	
	public static void addALife() {
		lives += 1;
	}
	
	public static void removeALife() {
		lives -= 1;
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

	public static void setFirstTimer(JLabel aLabel, JFrame aFrame) {
		Timer timer = new Timer(1000, new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				time--;
				int minutes = (int)time / 60;
				int seconds = (int)time % 60;
				aLabel.setText("Time: " + minutes + " : " + seconds);
				if (time == 0) {
					GameFunctions.showMessage("GAME OVER!!!",aFrame ,2500);
					System.exit(1);
				}
			}
		});
		timer.start();
	}
	
	public static void setSecondPlusTimer(JLabel aLabel) {
		Timer timer = new Timer(1000, new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int minutes = (int)time / 60;
				int seconds = (int)time % 60;
				aLabel.setText("Time: " + minutes + " : " + seconds);
			}
		});
		timer.start();
	}

	public static int getScore() {
		return score;
	}
	
	public static void updateScore() {
		timeCounterEnd = time;
		int bonus = 20 - (timeCounterStart - timeCounterEnd);
		if (bonus < 0)
			bonus = 0;
		System.out.print(bonus);
		score = score + 1000 + (bonus * 100);
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
}
