package itec324.labs;
public class Main {

	public static void main(String[] args) {
		 Data data = new Data();
		    Thread sender = new Thread(new Sender(data, "Sender 1"));
		    Thread receiver = new Thread(new Receiver(data,"Reciever 1"));
		    
		    Thread receiver2 = new Thread(new Receiver(data,"Reciever 2"));
		  		    
		    sender.start();
		    receiver.start();
		   receiver2.start();

	}

}
