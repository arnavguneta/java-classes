package guneta.two.interfaces;

import java.util.Random;

/*
APCS-A PSET 3-1
Arnav Guneta
Period 2
Johns Creek High School
10/22/17 
 */
public class Car implements Races {

	// prefix string used in print
	private String pref;
	// field variables
	private String name;
	private String company;
	private boolean running;
	private boolean started;
	private boolean stopped;
	private boolean idle;
	private int speed;
	// empty constructor
	public Car() {
		this("UNDEF", "UNDEF", false, false, true, true, 0);
	}
	// full constructor
	public Car(String name, String company, boolean running, boolean started, boolean stopped, boolean idle,
			int speed) {
		this.name = name;

		pref = "[" + this.getName().toUpperCase() + "] ";

		this.company = company;
		this.running = running;
		this.started = started;
		this.stopped = stopped;
		this.idle = idle;
		this.speed = speed;
	}
	// reports the speed of the car
	@Override public String speeds() {
		return pref + "Speed: " + this.getSpeed() + " MPH";
	}

	// checks if boat is started to start accel, or boost accel if already moving
	@Override public String run() {
		Random rand = new Random();

		if (this.isRunning()) {
			this.setSpeed(speed + rand.nextInt(26) + 10);
			return pref + "Run: acceleration boosted";
		} else if (this.isIdle() && this.isStarted() && !this.isStopped()) {
			this.setSpeed(speed + rand.nextInt(26) + 25);
			this.setRunning(true);
			this.setIdle(false);
			return pref + "Run: starting acceleration";
		} else {
			return pref + "Run: idle or not started";
		}
	}
	// checks if the car is idle. if it isnt, it makes it idle
	@Override public String idle() {
		if (this.isIdle()) {
			return pref + "Idle: idle";
		} else {
			this.setIdle(true);
			return pref + "Idle: idle";
		}
	}
	// checks if the car isnt stopped and stops it
	@Override public String stop() {
		if (!this.isStopped()) {
			this.setSpeed(0);
			this.setStopped(true);
			this.setStarted(false);
			this.setRunning(false);
			this.setIdle(true);

			return pref + "Stop: stopped";
		} else {
			return pref + "Stop: already stopped";
		}
	}
	// checks if the car is started, if not then it starts it
	@Override public String start() {
		if (this.isStarted()) {
			return pref + "Start: already started";
		} else {
			this.setSpeed(0);
			this.setStarted(true);
			this.setStopped(false);
			this.setIdle(true);
			this.setRunning(false);

			return pref + "Start: started";
		}
	}
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return pref + "Company: " + company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isIdle() {
		return idle;
	}

	public void setIdle(boolean idle) {
		this.idle = idle;
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
