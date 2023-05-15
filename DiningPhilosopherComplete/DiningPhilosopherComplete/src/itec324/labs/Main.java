package itec324.labs;
import java.util.ArrayList;

public class Main {

	
	
	public static void main(String[] args) {

		String names[] = {"Aristotle" ,"Plato",	"Chanakya", "Spinoza","Kant", "Spencer","Russell",
				"Osho"};
	
		ArrayList<Philosopher> philosophers = createPhilosophers(names);
        philosophers.forEach(n -> new Thread(n).start());     

    }
	 public static ArrayList<Philosopher> createPhilosophers(String names[]) {

	        Fork[] forks = new Fork[names.length];
	        for (int i = 0; i < names.length; i++) {
	            forks[i] = new Fork(i);
	        }
	        ArrayList<Philosopher> philosophers = new ArrayList<Philosopher>();
	        for (int i = 0; i < names.length ; i++) {

	           philosophers.add(new Philosopher(i, forks[i], forks[(i + 1)% names.length] , names[i]));

	        }
	        return philosophers;

	    }

}
