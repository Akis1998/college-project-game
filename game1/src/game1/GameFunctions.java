package game1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameFunctions {
	//Dialog boxes need to be implemented
	
	public static void Right_Answer(JFrame aframe) {
		
		Player.addALife();
		Player.updateCurrentRoom();
		Message_Box.show_message("Good job!\nOn to the next round!\nLives left: "+Player.getLives(),aframe);
		aframe.dispose();
		Main.openNewGamePanel();
		
	}
	
	public static void Wrong_Answer(JFrame aframe) {
		Player.removeALife();
		
		if (Player.getLives()==0) {
			Message_Box.show_message("GAME OVER!!!",aframe);
			System.exit(1);
		}
		Player.updateCurrentRoom();
		Message_Box.show_message("Wrong answer!\nLives left: "+Player.getLives(),aframe);
		aframe.dispose();
		Main.openNewGamePanel();
		
	}

}
