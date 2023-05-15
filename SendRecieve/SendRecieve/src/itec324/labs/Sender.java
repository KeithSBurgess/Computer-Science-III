package itec324.labs;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {

	private final int PACKET_COUNT = 50;
	private final String terminator = "END";
	private Data data;
	private String name;
	 public Sender(Data data, String name) {
		 
		 	this.name = name;
			this.data = data;
		}
	@Override
	public void run() {
		String[] packets = new String[PACKET_COUNT + 1];
		for (int i = 0; i < PACKET_COUNT; i++) {
			packets[i] = "Packet-" + i;
		}
		packets[PACKET_COUNT] = terminator;

		for (String packet : packets) {
			data.send(packet);
			System.out.printf("%s sent by %s%n",packet, name );

			// Thread.sleep() to mimic heavy server-side processing
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println("Thread Interrupted");
			}
		}
		  System.out.printf("%s exited%n", "Sender" );
	}

}
