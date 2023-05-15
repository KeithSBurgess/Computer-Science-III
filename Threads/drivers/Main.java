import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

	public static final int THREAD_COUNT = 4;
	public static final int ARRAY_PER_THREAD = 4;
	// Do not Modify
	public static final int ARRAY_COUNT = THREAD_COUNT + ARRAY_PER_THREAD;
	public static final int ARRAY_SIZE = 100_000_000;
	
	
	public static BigInteger populatewithThread(int arrayPerThread, int arraySize, int threadCount) {
		ArrayList<Populate> pops = new ArrayList<>();
		
		for (int i = 0; i < threadCount; i++) {
			pops.add(new Populate(arrayPerThread, arraySize, "Process " + i));
			
		}
		ArrayList<Thread> threads = new ArrayList<>();
		
		for(Populate p : pops) {
		
		Thread t = new Thread(p);
		threads.add(t);
		t.start();
		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} //END for
	
		BigInteger total = BigInteger.valueOf(0);
		for (Populate p : pops) {
			total = total.add(p.getTotal());
		}
		return total;
	}
	
	/*//FOR SINGLE THREAD
	
	public static BigInteger arrayLoop(int num) {
		BigInteger sum = new BigInteger("0");
		for (int i=0; i < num;i++) {
			int[] array = createArray(); //Creates Array
			for(int j=0; j < array.length;j++) {
				sum = sum.add(BigInteger.valueOf(array[j]));
			}
			//System.out.println("SUM: " + sum);
		}
		return sum;
	}
	
	/*
	public static int[] createArray() {
		//
		//long StartTime = System
		
		//
		Random rand = new Random();
		int upperBound = 999;
		int[] array = new int[ARRAY_SIZE];
		
		for(int i=0;i<ARRAY_SIZE;i++) {
			array[i] = rand.nextInt(upperBound);
		}
		//
		return(array);
	} //END createArray
	*/
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		System.out.println("Total: " + populatewithThread(ARRAY_PER_THREAD,ARRAY_SIZE,THREAD_COUNT));

		System.out.println("END");
	}//END main	
		
}//END Main