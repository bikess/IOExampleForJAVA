import java.net.URL;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5,b=3;
		if(!(a==b)&&(a==1+b++)){
			
		}
		System.out.println(a+"\t"+b);
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(System.class.getClassLoader());
		System.out.println(test.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
//	    URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
//		   for (int i = 0; i < urls.length; i++) {
//		     System.out.println(urls.toString());
//		   }
		//最大可用内存，对应-Xmx
		System.out.println(Runtime.getRuntime().maxMemory());
		// //当前JVM空闲内存
		System.out.println(Runtime.getRuntime().freeMemory());
		//当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
		System.out.println(Runtime.getRuntime().totalMemory());
	}

}
