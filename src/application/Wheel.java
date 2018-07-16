package application;

import java.util.Random;

public class Wheel extends Thread implements Runnable{
	
	static int position; 
	int speed;
	
	
	public Wheel (int position, int speed) {
		this.position = position;
		this.speed = speed;
	}
	
	
	
	public static int getPosition() {
		return position;
	}


	public void setPosition(int postition) {
		this.position = postition;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}

	Random randomizer = new Random();


	public Thread thread = new Thread(this);
	private boolean run;

	
	@Override
	synchronized public void run() {
	//	Random random = new Random();
		try {
			int range = 10 - 1;
			position = randomizer.nextInt(range);
			Wheel.sleep(6000);
			this.position += this.getSpeed();
			System.out.println("Wheel is at position " + position);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}

}
