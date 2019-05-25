import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GameFunctions {
	//Dialog boxes need to be implemented
	
	public static void showMessage(String info, JFrame aframe) {
		final JOptionPane optionPane = new JOptionPane(info, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

		final JDialog dialog = new JDialog();
		dialog.setTitle("Message");
		dialog.setModal(true);

		dialog.setContentPane(optionPane);

		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.pack();
		dialog.setLocationRelativeTo(aframe);
		//create timer to dispose of dialog after 5 seconds
		Timer timer = new Timer(3000, new AbstractAction() {

		    public void actionPerformed(ActionEvent ae) {
		        dialog.dispose();
		    }
		});
		timer.setRepeats(false);//the timer should only go off once

		//start timer to close JDialog as dialog modal we must start the timer before its visible
		timer.start();
		dialog.setVisible(true);
	}
	
	public static void rightAnswer(JFrame aframe) {
		if (Player.getLives() < 5)
			Player.addALife();
		Player.updateCurrentRoom();
		Player.updateScore();
		showMessage("Good job!\nOn to the next round!\nLives left: "+Player.getLives(),aframe);
		aframe.dispose();
		Main.openNewGamePanel();
	}
	
	public static void wrongAnswer(JFrame aframe) {
		Player.removeALife();
		if (Player.getLives() == 0) {
			showMessage("GAME OVER!!!",aframe);
			System.exit(1);
		}
		Player.updateCurrentRoom();
		showMessage("Wrong answer!\nLives left: "+Player.getLives(),aframe);
		aframe.dispose();
		Main.openNewGamePanel();
	}
	
	public static void skipBtn(JFrame aframe) {
		if (Player.isSkipAvailable()) {
			if(Player.getLives() > 1) {
				showMessage("You skipped the question!" + System.lineSeparator() + "The correct answer was: " + Story.getRightAnswer() + System.lineSeparator() + "You lost 1 life!", aframe);
				Player.removeALife();
				Player.setSkipNotAvailable();
				Player.updateCurrentRoom();
				Main.openNewGamePanel();
			}
			else
				showMessage("You don't have enough lives to skip the question!", aframe);
		}
		else
			showMessage("You already used the skip option once!", aframe);
	}
}
