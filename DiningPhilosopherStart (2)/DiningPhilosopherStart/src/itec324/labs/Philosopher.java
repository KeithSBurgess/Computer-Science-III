package itec324.labs;


public class Philosopher implements Runnable {
	  private final int id;
	    private final Fork leftFork;
	    private final Fork rightFork;
	    private boolean hasLeft = false;
	    private boolean hasRight = false;
	    public Philosopher(int id, Fork leftFork, Fork rightFork) {
	        this.id = id;
	        this.leftFork = leftFork;
	        this.rightFork = rightFork;
	    }

	    @Override
	    public void run() {
	        
	    	//Semaphore semaphore = new Semaphore(0);
	    	//Semaphore semaphore2 = new Semaphore(0);
	    	
	    	for (;;) {
	            System.out.println("Philosopher " + id + " is thinking...");
	            
	            if (leftFork.id > rightFork.id) {
		            while(!rightFork.forkAvailable());
		            // Danger Zone two philosophers could be here 
		            // try to get the same fork
		            
		            rightFork.take(this);
		            this.hasRight = true;
		            System.out.println("Philosopher " + id + " took the right fork " + rightFork.id);
	            }
	            
	            else {
		            while(!leftFork.forkAvailable());
		            // Danger Zone two philosophers could be here 
		            // try to get the same fork
		            
		            leftFork.take(this);
		            this.hasLeft = true;
		            
		            //if left < right
		            //else swap^
		            System.out.println("Philosopher " + id + " took the left fork " + leftFork.id);
		            System.out.println("Philosopher " + id + " is eating...");
		            leftFork.put(this);
		            this.hasRight = false;
		            System.out.println("Philosopher " + id + " has put down the left fork " + leftFork.id);
		            rightFork.put(this);
		            hasLeft = false;
		            System.out.println("Philosopher " + id + " has put down the right fork " + rightFork.id);
	            }
	         }
	    }

		public boolean hasLeft() {
			return hasLeft;
		}

		public boolean hasRight() {
			return hasRight;
		}
}
