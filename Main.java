import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {	//Dummy Main(Game?) Class

	public static void main(String[] args) {
		Story.fillQuestionsAnswers();
		openNewGamePanel();
	}
	
	public static void openNewGamePanel() {
		Player.updateCurrentRoom();
		Story.updateNextQuestion();
		ArrayList<Integer> nextQuestion = Story.getNextQuestion();
		new GamePanel(Player.getLives(), nextQuestion.get(0), nextQuestion.get(1),nextQuestion.get(2), nextQuestion.get(3));
	}
	
	public static void confirmRestart() {
		int response = JOptionPane.showOptionDialog(null, "Are you sure you want to Restart?", "Restart", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (response == JOptionPane.YES_NO_OPTION)
			System.exit(0);	//Later this should restart the application!
	}
	public static void confirmExit() {
		int response = JOptionPane.showOptionDialog(null, "Are you sure you want to Exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (response == JOptionPane.YES_NO_OPTION)
			System.exit(0);
	}
}
