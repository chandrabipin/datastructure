package javapractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OP005MultiThreadingExecutorServiceExampleThreadClass implements Runnable{

	public OP005MultiThreadingExecutorServiceExampleThreadClass() {
		// TODO Auto-generated constructor stub
	}
	public void run() {
		System.out.println("Thread Name:" + Thread.currentThread().getName());
		try {
			Thread.sleep(400);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
