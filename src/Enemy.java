import java.util.Random;

public class Enemy {
	
	public static int reduceTime() {
		int reduced_time=new Random().nextInt(Player.getRemainingTime()/2);
		return reduced_time;
	}

}
