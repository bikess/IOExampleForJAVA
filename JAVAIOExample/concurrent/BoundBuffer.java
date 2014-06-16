package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 此类中将Condition实例绑定到一个锁上。要为特定Lock实例获得Condition实例，则可以使用newCondition()方法。
 * 
 * 例如下面举一个例子，若试图在空的缓冲区执行take操作，则在items有可用数据之前线程将一直阻塞；若试图在满的缓冲区上
 * 执行put操作，则在空间变的可用之前，线程将一直阻塞
 * @author bike
 *
 */
// 此类实现的这个缓冲区，实际上也是LinkedBlockingDeque所采用的方法，也是定义一个互斥的可重入锁Lock，两个条件变量分别标示队列满队列空
public class BoundBuffer {
	
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();
	
	final Object[] items = new Object[100];
	
//	在这里下面的这些变量都是临界资源，访问这些临界资源都要先用锁进行锁上
	int putptr,takeptr,count;
	
	public void put(Object x) throws InterruptedException{
//		向缓冲区中放某个物品，首先获得互斥锁,也就是
		lock.lock();
		try {
//			一旦已经满了，则该线程阻塞在条件notFull上
			while(count == items.length)
				notFull.await();
			items[putptr] = x;
			if(++putptr==items.length)
				putptr = 0;
			++count;
//			唤醒在notEmpty上阻塞的线程
			notEmpty.signal();			
		}finally{
//			释放缓冲区的锁
			lock.unlock();
		}
	}
	
	public Object take() throws InterruptedException{
		lock.lock();
		try{
//			一旦已经空了，则线程阻塞在条件notEmpty上
			while(count==0)
				notEmpty.await();
			Object x = items[takeptr];
			if(++takeptr ==items.length)
				takeptr = 0;
			--count;
//			唤醒在notFull上阻塞的线程
			notFull.signal();
			return x;
		}finally{
//			释放缓冲区的锁
			lock.unlock();
		}
	}
	
}
