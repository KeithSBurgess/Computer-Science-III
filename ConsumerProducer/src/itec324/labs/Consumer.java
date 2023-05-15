package itec324.labs;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
	private String name;
	BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
	public Consumer(String name,BlockingQueue<Integer> queue) {
		this.name = name;
		this.queue = queue;
	}
	
	public void run() {
		int qsize;
		int num;
		while (true) {
			if (!queue.isEmpty()) {
				num = queue.poll();
				qsize = queue.size();
				System.out.println(name + ": " + num + " | Queue Size: " + qsize);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//END if
			if (Thread.activeCount() <= 6) { //TOTAL: 11 (5 pro, 5 cons, 1 main) | 11 - 5 (producers) = 6
				break;
			}
		}//END while
		System.out.println(name + " exiting");
	}//END run()
}
