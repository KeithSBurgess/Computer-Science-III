import java.math.BigInteger;
import java.util.Random;

public class Populate implements Runnable {

	private String name;
	private int count = 0;
	private int size = 0;
	private BigInteger total;
	
	public Populate(int count, int size, String name) {
		this.count = count;
		this.name = name;
		this.size = size;
		this.total = new BigInteger("0");
	}
	//private BigInteger sum = new BigInteger("0");
	
	@Override
	public void run() {
		System.out.println("Start run()");
		//BigInteger sum = new BigInteger("0");
		for (int i = 0; i < count; i++) {
			int[] array = createArray(size); //Creates Array
			total = total.add(getSum(array));
			
			//for (int j = 0; j < size; j++) {
			//	sum = sum.add(BigInteger.valueOf(array[j]));
			//}
			
			//int[] t = getLoadedArray_size();
			//BigInteger bi = getSum(t);
			//sum = sum.add(bi);
		}
		System.out.println("End run()");
	} //END run()
	
	
	public static int[] createArray(int size) {
		Random rand = new Random();
		int upperBound = 999;
		int[] array = new int[size];
		
		for(int i=0;i<size;i++) {
			array[i] = rand.nextInt(upperBound);
		}
		//
		return(array);
	} //END createArray
	
	
	public BigInteger getSum(int[] t) {
		BigInteger sum = new BigInteger("0");
		for(int i=0;i<t.length;i++) {
			sum = sum.add(BigInteger.valueOf(t[i]));
		}
		return sum;
	}
	
	public BigInteger getTotal() {
		return total;
	}
	//
	//private static int[] getLoadedArray_size() {
	//	return ;
	//}
	public String getName() {
		return name;
	}
	
}
