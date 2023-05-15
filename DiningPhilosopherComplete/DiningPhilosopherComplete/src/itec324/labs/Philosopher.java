package itec324.labs;

import java.util.Random;

public class Philosopher implements Runnable {
	    public final int id;
	    public String name;
	    private final Fork leftFork;
	    private final Fork rightFork;
	    private boolean hasLeft = false;
	    private boolean hasRight = false;
	    private Random random = new Random();
	    
	    public Philosopher(int id, Fork leftFork, Fork rightFork, String name) {
	        this.id = id;
	        this.leftFork = leftFork;
	        this.rightFork = rightFork;
	        this.name = name;
	    }

	    private void think()
	    {
	    	 System.out.println(name + " is thinking...");
	    	 try {
				Thread.sleep(random.nextLong(1000,5000));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	    	 
	    }
	    private void eat()
	    {
	    	 System.out.println(name + " is eating...");
	    	 try {
				Thread.sleep(random.nextLong(1000,5000));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	    	 
	    }
	    
	    private void putdownForks()
	    {
	    	String format = "%s put down the %s fork %d%n";
	    	leftFork.put(this);
    		this.hasLeft = false;
    		System.out.printf(format,name, "left", leftFork.id);
    		rightFork.put(this);
    		this.hasRight = false;
    		System.out.printf(format, name, "right", rightFork.id);
	    }
	    
	    
	    private void getForks()
	    {
	    	String format = "%s took the %s fork %d%n";
	    	if(leftFork.id > rightFork.id)
	    	{
	    		leftFork.take(this);
	    		this.hasLeft = true;
	    		System.out.printf(format, name, "left", leftFork.id);
	    		rightFork.take(this);
	    		this.hasRight = true;
	    		System.out.printf(format, name, "right", rightFork.id);
	    	}
	    	else
	    	{
	    		rightFork.take(this);
	    		this.hasRight = true;
	    		System.out.printf(format, name, "right", rightFork.id);
	    		leftFork.take(this);
	    		this.hasLeft = true;
	    		System.out.printf(format, name, "left", leftFork.id);
	    	}
	    }
	    
	    @Override
	    public void run() {
	        for (;;) {
	           
	        	think();	        	
	           
	        	getForks();
	        	
	        	eat();
	        	
	        	putdownForks();          
	           
	        }
	    }

		public boolean hasLeft() {
			return hasLeft;
		}

		public boolean hasRight() {
			return hasRight;
		}
}
