package com.learn.java.multithreading;

public class ThreadLocalTest {

    public static class MyRunnable implements Runnable {

/*        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();*/
    	
        private ThreadLocal<InfoHolder> threadLocal =
                new ThreadLocal<InfoHolder>();

        @Override
        public void run() {
            threadLocal.set(new InfoHolder((int) (Math.random() * 100D)));
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get().getInfo());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }
}


class InfoHolder{
	int info;
	
	InfoHolder(int info){
		this.info = info;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
}

