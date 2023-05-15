

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class Populate implements Callable<BigInteger> {

	private String name;
	private int count = 0;
	private int size = 0;
	
	
	public Populate(int count, int size, String name) {
		this.count = count;
		this.name = name;
		this.size = size;
		
	}
	private BigInteger sum = BigInteger.ZERO;
	
	

	public BigInteger getSum() {
		return sum;
	}
	
	private static int[] getLoadedArray( int size)
	{
		Random r = new Random();

		int[] numbers = new int[size];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(1000);
		}
		return numbers;
	}

	private BigInteger getSum(int[] numbers)
	{
		BigInteger sub = BigInteger.ZERO;
		
		for (int i = 0; i < numbers.length; i++) {
						
			sub = sub.add(BigInteger.valueOf(numbers[i]));
		}
		return sub;
	}

	public String getName() {
		return name;
	}

	@Override
	public BigInteger call() throws Exception {
		
		for (int i = 0; i < count; i++) {
			int[] t =  getLoadedArray(size);
			BigInteger bi =  getSum(t);
			sum = sum.add(bi);
		}
		
		return sum;
	}

}
