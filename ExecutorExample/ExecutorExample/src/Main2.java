 import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class Main2 {
	public static final int THREAD_COUNT = 4 ;
	public static final int ARRAY_PER_THREAD = 4;
	// Do not Modify
	public static final int ARRAY_COUNT = THREAD_COUNT * ARRAY_PER_THREAD  ;
	public static final int ARRAY_SIZE = 100_000_000;
	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Submitting the tasks for execution...");
        ArrayList<Populate> pops = new ArrayList<>();
		
		for (int i = 0; i < THREAD_COUNT; i++) {
					
			pops.add(new Populate(ARRAY_PER_THREAD, ARRAY_SIZE, "Process " + i));
			
			
		}
        
		ArrayList<Future<BigInteger>> fut = new ArrayList<>();
		for (Populate p : pops ){
			fut.add(executorService.submit(p));
		}
     
		BigInteger total = BigInteger.valueOf(0);
		try {
			for(Future<BigInteger> f : fut )
			{
				//BigInteger total = BigInteger.valueOf(0);
				System.out.println(f.get());
				total = total.add(f.get());
			}
			
			System.out.println("Total: " + total);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}

        executorService.shutdown();
	}

}
