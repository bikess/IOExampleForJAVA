import java.util.LinkedList;

import java.util.concurrent.*;

class Client extends Thread{
	private String name;
	public Client(String name){
		this.name = name;
	}
	public void run(){
//		 LockManager.getLockManager().lock("adsf", LockState.excusive);
	}
}

public class SignalJAVA {

	/**
	 * @param args
	 */
	private static SignalJAVA locker = null;
	public static SignalJAVA getLocker(){
		if(locker == null){
			locker = new SignalJAVA();
		}
		return locker;
	}
	private volatile int count =1;
	private volatile LinkedList<Thread> waiting = new LinkedList<>();
	
	public synchronized void wait(String name){
		count--;
		System.out.println(name+"wait"+count);
		if(count<0){
			try{
//				wait 表示线程等待
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void signal(){
		count++;
		System.out.println("signal"+count++);
		if(count<=0){
//			唤醒阻塞的线程
			notify();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
