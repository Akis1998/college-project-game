package game1;

import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ReverseTimer extends TimerTask {
	int seconds = 0;
	JLabel label;
	JFrame frame;
	
	ReverseTimer(JFrame frame, JLabel timerlabel, int secs){
		super();
		seconds = secs;
		label = timerlabel;
		this.frame = frame;
	}
	
	public void Update(){
		seconds -= 1;
		if (seconds == 0){
			System.out.println("Stop!");
			this.cancel();
		}
	}
    public void run() {
       System.out.println(seconds/60 + ":" + seconds % 60); 
       this.Update();
       label.setText(String.format("Time left: %02d:%02d", seconds / 60, seconds % 60));
       frame.invalidate();
       //frame.repaint();
    }
}