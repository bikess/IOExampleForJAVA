package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  这里是一个卖火车票的例子来展现一下JAVA的多线程，也就是卖火车票的时候
 *  我们每一卖火车票 的窗口就是一个线程，而火车票必须是线程互斥的，否则会导致
 *  卖出相同的票，或者导致没有票了还继续卖票
 * @author bike
 *
 */
public class TicketSource implements Runnable{

//	票的总数,这个是临界资源，需要加锁！！
	private int ticket = 10;
	private Lock lock = new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		这是模拟买票的人，这里每个窗口50个买票的，这里很多代码块不需要
//		同步，只需要将对ticket修改的操作同步就可以，因此只对那部分代码进行进程
//		同步利用Synchronized关键词进行同步
		for(int i=1;i<50;i++){
			try{
//				休眠1s中，为了让效果更加明显
				Thread.sleep(1000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
//			this.sale();
			this.Locksale();
		}
	}

	private synchronized void sale() {
		// TODO Auto-generated method stub
		if(ticket>0){
			System.out.println(Thread.currentThread().getName()+"号窗口卖出"+this.ticket--+"号票");
		}
	}
	private  void Locksale(){
		lock.lock();
		try{
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"号窗口卖出"+this.ticket--+"号票");
			}
		}finally{
			lock.unlock();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketSource mt = new TicketSource();
		new Thread(mt,"a").start();
		new Thread(mt,"b").start();
		new Thread(mt,"c").start();
	}
}
