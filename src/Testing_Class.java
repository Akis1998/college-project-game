import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Testing_Class {
	
	public static void testMethod() {
		JFrame frame = new JFrame("The enemy is here!");
		JPanel mainPanel = new JPanel(new BorderLayout());	//mainPanel
		JLabel playerImage = new JLabel("");
		Image playerIcon = new ImageIcon("Images/enemy.jpg").getImage();
		playerImage.setIcon(new ImageIcon(playerIcon));
		Dimension size = playerImage.getPreferredSize();
	    playerImage.setBounds(200, 200, size.width, size.height);
		mainPanel.add(playerImage);
		frame.setContentPane(mainPanel);	//Frame settings - size settings need to be adjusted!
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setModalExclusionType(ModalExclusionType.NO_EXCLUDE );
		//frame.pack();
		
		Timer timer = new Timer(3000, new AbstractAction() {

		    public void actionPerformed(ActionEvent ae) {
		        frame.dispose();
		    }
		});
		timer.setRepeats(false);//the timer should only go off once

		//start timer to close JDialog as dialog modal we must start the timer before its visible
		timer.start();
		
		frame.setVisible(true);
	}
}
