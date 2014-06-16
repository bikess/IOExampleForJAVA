package concurrent;
//此类是为Map添加读写锁，从而把Map类封装成一个可以线程同步的Map类
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMap<K,V> {
	private final Map<K,V> map;
//	 定义一个读写锁
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();
	public ReadWriteLockMap(Map<K, V> map){
		this.map = map;
	}
//	为Map的写操作添加写锁，写锁是只允许一个线程持有写锁，对Map执行写操作
	public V put(K key, V value){
		w.lock();
		try{
			return map.put(key, value);
		}finally{
			w.unlock();
		}
	}
	
//	为Map的度操作添加读锁，读锁是可以允许多个线程持有读锁，对Map执行读操作
	public V get(K key){
		r.lock();
		try{
			return map.get(key);
					
		}finally{
			r.unlock();
		}
	}
}
