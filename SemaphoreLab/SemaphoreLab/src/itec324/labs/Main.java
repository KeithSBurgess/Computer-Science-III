package itec324.labs;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(0);
		Semaphore semaphore2 = new Semaphore(0);
		
		Foo foo = new Foo();
		// Lambda Runnable
		Runnable task1 = () -> { try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				} foo.first();semaphore.release(); };
		
		// Lambda Runnable
		Runnable task2 = () -> { try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} foo.second();semaphore2.release(); };
		
		// Lambda Runnable
		Runnable task3 = () -> { try {
			semaphore2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} foo.third(); };
		
		Thread three = new Thread(task3);
		Thread one = new Thread(task1);
		Thread two = new Thread(task2);
				
		one.start();
		two.start();
		three.start();
		

	}

}
