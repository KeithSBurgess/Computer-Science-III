import java.util.Random;

public class MyThread extends Thread {
	private int count;
	private int oddCount;
	private int evenCount;
	private int numberFound;
	private int divisibleBy = 2;
	
	
	public void run() {
		System.out.println("Inside run()");
		
		while(evenCount < 10) {
			Random r = new Random();
			numberFound = r.nextInt(500); //gets random number between 0-500 inclusive
			count++;
			//System.out.println("Number Found: " + numberFound);	//TEST STATEMENT
			if (numberFound % divisibleBy == 0) {
				evenCount++;
				//System.out.println("Count: " + count);	//TEST STATEMENT
			}
			else {
				oddCount++;
				//System.out.println("oddCount: " + oddCount);	//TEST STATEMENT
			}
			
			try {
				sleep(numberFound);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} //END while
		//System.out.println("Even Numbers: " + count);		//TEST STATEMENT
		//System.out.println("Odd Numbers: " + oddCount);	//TEST STATEMENT
		System.out.println("End run()");
		
	} //END run
	
	public int getNumberFound() {
		return numberFound;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getOddCount() {
		return oddCount;
	}
	
	public int getEvenCount() {
		return evenCount;
	}
}