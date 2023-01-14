package guneta.two.interfaces;

/*
APCS-A PSET 3-1
Arnav Guneta
Period 2
Johns Creek High School
10/22/17 
 */
public class Boat implements Runs, Floats {

	// prefix string with the vehicles name
	private String pref;
	// field variables
	private String name;
	private String company;
	private boolean running;
	private boolean started;
	private boolean stopped;
	private boolean idle;
	private boolean docked;

	// empty constructor
	public Boat() {
		this("UNDEF", "UNDEF", false, false, true, true, true);
	}
	// full constructor
	public Boat(String name, String company, boolean running, boolean started, boolean stopped, boolean idle,
			boolean docked) {
		this.name = name;

		pref = "[" + this.getName().toUpperCase() + "] ";

		this.company = company;
		this.running = running;
		this.started = started;
		this.stopped = stopped;
		this.idle = idle;
		this.docked = docked;
	}

	// checks if the boat is idle and stopped in order to dock
	@Override public String docks() {
		if (this.isStopped()) {
			this.setDocked(true);
			return pref + "Docks: docked";
		} else {
			return pref + "Docks: not stopped";
		}
	}

	// checks if boat is docked and stopped in order to launch
	@Override public String launches() {
		if (this.isStopped() && this.isDocked()) {
			return pref + "Lauches: launched";
		} else {
			return pref + "Launches: not docked and/ or not stopped";
		}
	}

	// checks if boat is started to start accel, or boost accel if already moving
	@Override public String run() {

		if (this.isRunning()) {
			return pref + "Run: acceleration boosted";
		} else if (this.isIdle() && this.isStarted() && !this.isStopped()) {
			this.setRunning(true);
			this.setIdle(false);
			return pref + "Run: starting acceleration";
		} else {
			return pref + "Run: idle or not started";
		}
	}

	// checks if vehicle is idle, if not then it makes it idle
	@Override public String idle() {
		if (this.isIdle()) {
			return pref + "Idle: idle";
		} else {
			this.setIdle(true);
			return pref + "Idle: idle";
		}
	}

	// checks if they vehicle isnt stopped. if it isnt, it stops it
	@Override public String stop() {
		if (!this.isStopped()) {
			this.setStopped(true);
			this.setStarted(false);
			this.setRunning(false);
			this.setIdle(true);

			return pref + "Stop: stopped";
		} else {
			return pref + "Stop: already stopped";
		}
	}

	// checks if the vehicle is started or not. If not started, it starts it
	@Override public String start() {
		if (this.isStarted()) {
			return pref + "Start: already started";
		} else {
			this.setStarted(true);
			this.setStopped(false);
			this.setIdle(true);
			this.setRunning(false);
			this.setDocked(false);

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

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public boolean isIdle() {
		return idle;
	}

	public void setIdle(boolean idle) {
		this.idle = idle;
	}

	public boolean isDocked() {
		return docked;
	}

	public void setDocked(boolean docked) {
		this.docked = docked;
	}
}
