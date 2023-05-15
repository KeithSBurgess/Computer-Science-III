package csis324.labs; 
import java.util.function.Consumer;

public class FindPalindrome implements Runnable {

	private Consumer<String> consumer;
	private long start = 0;
	private long end = 0;

	public FindPalindrome(Consumer<String> consumer, long start, long end) {
		super();
		this.consumer = consumer;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		
		while (start < end) {
			isPaladrome(start);			
			start++;
		}

	} //END run()

	private synchronized boolean isPaladrome(long number) {
			
			String num = number + "";
			for (int i=0, j=num.length()-1; i < j; i++,j--) {
				if (num.charAt(i) != num.charAt(j)) {
					return false;
				}
			}
			
		System.out.println("Number: " + num + " is Paladrome");
		//consumer.accept(num);	//works but prints out of order
		
		return true;
	} //END isPaladrome();

}
