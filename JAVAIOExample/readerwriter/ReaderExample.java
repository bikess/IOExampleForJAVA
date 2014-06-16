package readerwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample {

	/**
	 * @param args
	 */
	
//	使用BufferedReader读取文件内容,BufferedReader是带缓冲的字符输入类，是抽象类Reader的子类
	public static String readFile(String file)throws IOException{
		BufferedReader br = null;
//		StringBuffer一个类似于 String 的字符串缓冲区,主要方法有两个：append 方法始终将这些字符添加到缓冲区的末端；而 insert 方法则在指定的点添加字符
		StringBuffer sb = new StringBuffer();
//		FileReader 文件字符输入类，（从文件中，以字符的形式读取输入），是InputStreamReader(其又是抽象类字符输入类Reader的子类)的子类.
		FileReader fr = null;
		try{
			fr = new FileReader(file);
//			bufferReader初始化参数是Reader，也就是使Reader，变成可以缓冲的Reader
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine())!=null){
				sb.append(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			br.close();
			fr.close();
		}
		return sb.toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
