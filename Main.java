import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {	//Dummy Main(Game?) Class

	public static void main(String[] args) {
		openNewGamePanel();
	}
	
	public static void openNewGamePanel() {
//		Player.updateCurrentRoom();
//		Story.updateNextQuestion();
//		ArrayList<Integer> nextQuestion = Story.getNextQuestion();
		Story.findQuestion(Player.getCurrentLevel());
		new GamePanel();
	}
}
