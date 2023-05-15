package itec324.labs;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
	BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
	private String name;
	private int count;
	
	public Producer(String name, int count,BlockingQueue<Integer> queue) {
		this.name = name;
		this.count = count;
		this.queue = queue;
	}
	
	public void run() {
		//System.out.println("Thread Count: "+Thread.activeCount());
		Random rand = new Random();
		int upperBound = 500;
		for (int i=0; i < count; i++) {
			int num = rand.nextInt(upperBound);
			int qsize;
			try {
				queue.put(num);
				qsize = queue.size();
				System.out.println(name + ": " + num + " | Queue Size: " + qsize);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name + " exiting");
	} //END run()
}
