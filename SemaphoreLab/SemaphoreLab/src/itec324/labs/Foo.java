package itec324.labs;

//import java.util.concurrent.Semaphore;

public class Foo {

	//private Semaphore semaphore = new Semaphore(0);
	//private Semaphore semaphore2 = new Semaphore(0);
	
	public void first() {
		
		System.out.print("first");
		//semaphore.release();
	
	}
	public void second() {
		/*try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.print("second");
		//semaphore2.release();
		
	}
	public void third() { 
		/*try {
			semaphore2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.print("third"); 
		//semaphore.release();
	}
}
