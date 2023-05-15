package itec324.labs;
public class Fork {
	 public final int id;
	  
	    private Philosopher philosopherUsingThisFork;

	    public boolean forkAvailable()
	    {
	    	return philosopherUsingThisFork == null;
	    }
	    public Fork(int id) {
	        this.id = id;
	    }

	    public void take(Philosopher philosopher) {
	       
	    	try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
				

	    	if(philosopherUsingThisFork != null)
	    	{
	    		System.out.println("Error double Use");
	    		System.exit(-1);
	    	}
	        philosopherUsingThisFork = philosopher;

	      

	    }

	    public void put(Philosopher philosopher) {

	    	if(philosopher == philosopherUsingThisFork)
	    	{
	    		philosopherUsingThisFork = null;
	    	}

	    }
}
