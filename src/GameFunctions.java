
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class GameFunctions {
	//Dialog boxes need to be implemented
	
	
	
	public static void showMessage(String info, JFrame aframe) {
		JOptionPane optionPane = new JOptionPane(info, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
		
		final JDialog dialog = new JDialog();
		dialog.setTitle("Message");
		dialog.setModal(true);

		dialog.setContentPane(optionPane);

		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.pack();
		dialog.setLocationRelativeTo(aframe);
		//create timer to dispose of dialog after 3 seconds
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
	
	
	public static int coinflip() {
		//return (int)(Math.random()*1); //testing
		int x= (int)(Math.random()*2); //[0,2)
		System.out.println(x);
		return x;
	}
	
	public static void rightAnswer(JFrame aframe) {
		if (Player.getLives() < 5)
			Player.addALife();
		Player.updateCurrentRoom();
		Player.updateScore();
		showMessage("Good job!\nOn to the next round!\nLives left: "+Player.getLives(),aframe);
		
		if (coinflip()==1) {
			int reducedTime=Enemy.reduceTime();
			showEnemy(aframe,reducedTime);
			if (Player.getRemainingTime()-reducedTime<=0) {
				showMessage("GAME OVER!!!",aframe);
				System.exit(1);
			}
			else
				Player.reduceTime(reducedTime);
			
		}
		
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
		
		if (coinflip()==1) {
			int reducedTime=Enemy.reduceTime();
			showEnemy(aframe,reducedTime);
			if (Player.getRemainingTime()-reducedTime<=0) {
				showMessage("GAME OVER!!!",aframe);
				System.exit(1);
			}
			else
				Player.reduceTime(reducedTime);
			
		}
		
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
	
	public static void showEnemy(JFrame aframe,int reducedTime) {
		String message= "The enemy has cut "+reducedTime+" second(s) off of your time!";
		
		JOptionPane optionPane = new JOptionPane(message, JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
		optionPane.add(new JLabel(new ImageIcon("Images/enemy.jpg"),SwingConstants.CENTER));
		
		JDialog dialog = new JDialog();
		dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setTitle("DANGER!");
        dialog.setBackground(Color.LIGHT_GRAY);
        dialog.setContentPane(optionPane);
        

        dialog.pack();
        
        dialog.setLocationRelativeTo(aframe);
        
		//create timer to dispose of dialog after 4 seconds
		Timer timer = new Timer(4000, new AbstractAction() {

		    public void actionPerformed(ActionEvent ae) {
		        dialog.dispose();
		    }
		});
		timer.setRepeats(false);//the timer should only go off once

		//start timer to close JDialog as dialog modal we must start the timer before its visible
		timer.start();
		dialog.setVisible(true);
		
		
	}
}
