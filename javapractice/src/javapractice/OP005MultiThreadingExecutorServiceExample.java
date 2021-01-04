package javapractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OP005MultiThreadingExecutorServiceExample {

	public OP005MultiThreadingExecutorServiceExample() {
		// TODO Auto-generated constructor stub
	}

	//driver method
	public static void main(String[] args) {
		ExecutorService executeService = Executors.newFixedThreadPool(10);//10 threads
		for(int i = 0; i < 20 ; i++) {
			executeService.execute(new OP005MultiThreadingExecutorServiceExampleThreadClass());
		}
		executeService.shutdown();
		while(!executeService.isTerminated()) {}
		System.out.println("Threads terminated");

	}

}
