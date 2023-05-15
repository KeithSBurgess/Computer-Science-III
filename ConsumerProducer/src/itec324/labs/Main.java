package itec324.labs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	
	public static final int PRODUCER_THREADS = 5;
	public static final int CONSUMER_THREADS = 5;
	public static final int COUNT = 5;
	public static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
	
	public static void main(String[] args) {		
		//System.out.println("Creating Producers");
		for (int i=0; i < PRODUCER_THREADS; i++) {
			String name = "producer" + i;
			Thread producer = new Thread(new Producer(name,COUNT,queue));
			//System.out.println("Producer" + i + " created");
			producer.start();
		}		
		//System.out.println("Creating Consumers");
		for (int j=0; j < CONSUMER_THREADS; j++) {
			String name = "consumer " + j;
			Thread consumer = new Thread(new Consumer(name,queue));
			//System.out.println("Consumer" + j + " created");
			consumer.start();
		}
	}

}
