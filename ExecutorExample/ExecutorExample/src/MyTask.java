
public class MyTask implements Runnable{
	
	  // Class data members
    String name;
    
 
    // Constructor
    MyTask( String name)
    {
 
        // this keyword refers to current instance itself
        this.name = name;
        
 
    }
 
    // Method
    // Called automatically when thread is started
    public void run()
    {
 
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
          
        }
    }

}
