package itec324.labs;
import java.util.ArrayList;

public class Main {

	
	
	public static void main(String[] args) {

		ArrayList<Philosopher> philosophers = createPhilosophers(8);
        philosophers.forEach(n -> new Thread(n).start()); 
        
	
     

    }
	 public static ArrayList<Philosopher> createPhilosophers(int n) {

	        Fork[] forks = new Fork[n];

	        for (int i = 0; i < n; i++) {
	            forks[i] = new Fork(i);
	        }

	        ArrayList<Philosopher> philosophers = new ArrayList<Philosopher>();

	        for (int i = 0; i < n ; i++) {

	           philosophers.add(new Philosopher(i, forks[i], forks[(i + 1)]));

	        }
	      
	        return philosophers;

	    }

}
