import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Message_Box {
	
	public static void show_message(String info, JFrame aframe) {
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
		    @Override
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
