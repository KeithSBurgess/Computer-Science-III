package csis.examples;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		return "String Hello From Differnt Thread";
	}

}
