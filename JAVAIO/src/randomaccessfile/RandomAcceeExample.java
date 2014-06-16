package randomaccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//对文件进行随机访问的代码
public class RandomAcceeExample {

	/**
	 * @param args
	 */
//	创建一个大小固定的文件
	public static void createFile(String file, int size) throws IOException{
		File temp = new File(file);
//		RamdomAccessFile随机访问文件类，支持对文件的随机读取，写入
//		new RandomAccessFile（File file，String mode）初始化函数：创建从中读取和向其中写入（可选）的随机访问文件流，该文件由 File 参数指定，mode 参数指定用以打开文件的访问模式
		RandomAccessFile raf = new RandomAccessFile(temp, "rw");
//		设置此文件的长度
		raf.setLength(size);
		raf.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
