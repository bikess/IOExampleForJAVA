package test;

public class ThreadMTest implements Runnable {

	public ThreadMTest(){
		Thread me = new Thread(this);
		me.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Mary");
		while(true){
			//do something here
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadMTest my = new ThreadMTest();
	}

}
