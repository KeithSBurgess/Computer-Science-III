import java.util.ArrayList;


public class Main {

	public static final int THREAD_COUNT = 4;
	public static final int ARRAY_PER_THREAD = 4;
	// Do not Modify
	public static final int ARRAY_COUNT = THREAD_COUNT + ARRAY_PER_THREAD;
	public static final int ARRAY_SIZE = 500_000_000;
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		//Thread thread = new MyThread();
		
		//thread.start();
		
		ArrayList<MyThread> threads = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			threads.add(new MyThread());
		}
		
		threads.forEach((t) -> t.run());
      
		for(Thread t : threads) {
    	  
    	  try {
    		  t.join();
    	  } catch (InterruptedException e) {
    		  //TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
    	  
       }
		
		int sum = 0;
		int count = 0;
		int totalEven = 0;
		int totalOdd = 0;
		for (MyThread t : threads) {
			//System.out.println(t.getNumberFound());
			sum += t.getNumberFound();
			count += t.getCount();
			totalEven += t.getEvenCount();
			totalOdd += t.getOddCount();
		}
		System.out.println("Count of Even Numbers: " + totalEven);
		System.out.println("Count of Odd Numbers: " + totalOdd);
		//System.out.println("The Sum is: " + sum);
		//System.out.println("The Count is: " + count);
		System.out.println("The Average is: " + (sum/count));
		
    
		
	}//END main	
		
}//END Main