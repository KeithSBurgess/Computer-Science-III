import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Submitting the tasks for execution...");
        executorService.submit(new MyTask( "A"));
        executorService.submit(new MyTask( "B"));
        executorService.submit(new MyTask( "C"));
        executorService.submit(new MyTask( "D"));
;

        executorService.shutdown();
	}

}
