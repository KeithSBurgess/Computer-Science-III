package csis.examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		CallableTask ct = new CallableTask();
		Future<String> future = executorService.submit(ct);
		
		try {
			String result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
