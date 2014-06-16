package concurrent;

/* ================================================================================== 
 * 描述：生产者－－消费者 
 * 
 * ================================================================================== 
 */ 
// 生成者与消费者需要共享的资源
class ShareData{
	private char c;
//	通知变量,用于唤醒消费这或者生成者
	private boolean writeable = true;
	
//	生成者的方法
	public synchronized void setShareChar(char c){
//		开始的时候writeable为true，不执行等待
		if(!writeable){
			try{
//			未消费则等待
			wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.c = c;
//		标记已经生产了
		writeable = false;
//		通知消费者已经生成可以消费了
		notify();
	}
	public synchronized char getSharechar(){
		if(writeable){
			try{
//				未生成等待
				wait();
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
//		标记已经消费
		writeable = true;
		notify();
		return this.c;
	}
}
// 生成者线程
class Producer extends Thread{
	private ShareData s;
	Producer(ShareData s){
		this.s = s;
	}
	public void run(){
		for(char ch = 'A';ch<='Z';ch++){
			try{
				Thread.sleep((int)Math.random()*400);
			}catch(InterruptedException e){}
			s.setShareChar(ch);
			System.out.println(ch+"\tproducer by producer.");
		}
	}
}
class Consumer extends Thread{
	private ShareData s;
	public Consumer(ShareData s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}
	public void run(){
		char ch;
		do{
			try{
				Thread.sleep((int)Math.random()*400);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			ch = s.getSharechar();
			System.out.println(ch+"\tconsumer by consumer.**");
		}while(ch!='Z');
	}
}
public class ConcurrentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareData s = new ShareData();
		new Consumer(s).start();
		new Producer(s).start();
	}

}
