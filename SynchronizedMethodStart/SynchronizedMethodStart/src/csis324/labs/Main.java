package csis324.labs; 
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.function.Consumer;


public class Main {

	public static final int THREAD_COUNT = 4 ;
	public static final int start = 0;
	public static final long end = 1000000;
	
	public static void main(String[] args) {
		long newStart = start;
		long newEnd = end;
		
		/*for (int i=0; i < THREAD_COUNT; i++) {
			FindPalindrome fp =  new FindPalindrome((n)-> print(n),newStart, newEnd);
			fp.run();
			newStart = newEnd + 1;
			newEnd = newEnd + 1000000;
		}*/
		
		for (int i=0; i < THREAD_COUNT; i++) {
			Thread Palindrome =  new Thread(new FindPalindrome((n)-> print(n),newStart, newEnd));
			Palindrome.start();
			newStart = newEnd + 1;
			newEnd = newEnd + 1000000;
		}
		

		// 1 Complete the run method
		// 2 complete the private boolean isPaladrome(long number)
		 
		// In Main
		// 3 Create 4 FindPalindrome objects
		//   first should look like this 
		//   FindPalindrome fp =  new FindPalindrome((n)-> print(n),start, end);
		//   make start = end + 1 and  end = end + 1000000 for each new FindPalindrome
		
		// 4 Create 4 threads with the FindPalindrome
		
		// 5 Start the threads
		
		// What's wrong?
		// Fix it!
		
		
	
	}
	
	public static void print(String print) {
		
		for(char c : print.toCharArray()) { 
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(c);}
		System.out.print('\n');
	}

}
