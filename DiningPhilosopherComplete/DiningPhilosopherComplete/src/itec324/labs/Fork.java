package itec324.labs;

public class Fork {
	public final int id;

	private Philosopher philosopherUsingThisFork;

	public boolean forkAvailable() {
		return philosopherUsingThisFork == null;
	}

	public Fork(int id) {
		this.id = id;
	}

	public synchronized void take(Philosopher philosopher) {

		// Philosopher will enter this method
		// Only on can be in at a time (synchronized)
		// if the fork is available drop out of the loop

		while (!forkAvailable()) {
			try {
				System.out.println("Oh fork!*** " + philosopherUsingThisFork.name + " has fork " + philosopher.name + " needs");
				System.out.println(philosopher.name + " is waiting for fork " + this.id);
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		// track the philosopher using 
		philosopherUsingThisFork = philosopher;

	}

	public synchronized void put(Philosopher philosopher) {

		if(philosopher == this.philosopherUsingThisFork)
		{
			philosopherUsingThisFork = null;
			notify();
		}

	}
}
