package itec324.labs;
import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {

	 private Data load;
	 private String name;
	 private final String terminator = "END"; 
	 
	 public Receiver(Data data, String name) {
		 
		 	this.name = name;
			this.load = data;
		}
	 
	    public void run() {
	    	String receivedMessage = load.receive();
	        while(!terminator.equals(receivedMessage)) {
	            
	            System.out.printf("%s recieved by %s%n",receivedMessage, name );

	            //Thread.sleep() to mimic heavy server-side processing
	            try {
	                Thread.sleep(ThreadLocalRandom.current().nextInt(10, 500));
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt(); 
	                System.err.println("Thread Interrupted"); 
	            }
	            // Receive new Message
	            receivedMessage = load.receive();
	        }
	        load.send(terminator);
	        System.out.printf("%s exited%n", name );
	    }
	  
}
