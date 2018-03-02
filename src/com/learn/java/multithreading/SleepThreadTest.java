package com.learn.java.multithreading;

public class SleepThreadTest {

	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable());
		thread.start();
		thread.interrupt();
	}
}

class MyRunnable implements Runnable{
	public void run() {
		while(true) {
			System.out.println("Woke up...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

