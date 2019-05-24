import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameFunctions {
	//Dialog boxes need to be implemented
	
	public static void Right_Answer(JFrame aframe) {
		
		Player.addALife();
		Message_Box.show_message("Good job! On to the next round!");
		aframe.dispose();
		Main.openNewGamePanel();
		
	}
	
	public static void Wrong_Answer(JFrame aframe) {
		
		System.out.println("GF WRONG!");
		Player.removeALife();
		Message_Box.show_message("Wrong answer! Lives left: "+Player.getLives());
		if (Player.getLives()==0) {
			Message_Box.show_message("GAME OVER!");
			System.exit(1);
		}
		
		aframe.dispose();
		Main.openNewGamePanel();
		
	}

}
