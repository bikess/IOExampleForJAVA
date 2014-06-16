package inputoutstream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamExample {

	/**
	 * @param args
	 */
//	使用FileInputStream读取文件
	public static byte[] readFileByFileInputStream(File file)throws IOException{
//		ByteArrayOutputStream 是按照 字节数组流 输出，每次输出以字节数组形式写入输出流
		ByteArrayOutputStream output = new ByteArrayOutputStream();
//		FileInputStream 是处理文件输入流，以字节流读取
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int bytenum = 0;
//			read(byte[],a,len)从此输入流中将最多 len 个字节的数据读入一个 byte 数组中,以数组总偏移量a开始存储。
//			此read方法返回读入缓冲区的字节总数，倘若读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1
			while((bytenum =(fis.read(buffer, 0, buffer.length)))!=-1){
//				将指定 byte 数组b 中从偏移量 0开始的 bytenum 个字节写入此 byte 数组输出流output中去
				output.write(buffer,0,bytenum);
			}
//			把写入的字节输出流装换为字符串输出
			System.out.println(output.toString());
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			if(fis!=null) fis.close();
			if(output!=null) output.close();
		}
//		toByteArray 创建一个新分配的 byte 数组。其大小是此输出流的当前大小，并且缓冲区的有效内容已复制到该数组中
		return output.toByteArray();
		
	}
//	使用BufferedInputStream读取文件
	public static byte[] readFileByBufferedInputStream(File file)throws Exception{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try{
			//将文件数据转换成文件字节输入流，文件字节输入流FileInputStream是字节输入流InputStream的子类
			fis = new FileInputStream(file);
//			对带缓冲的字节输入流初始化化，其初始化参数必须是字节输入流。注意BufferedInputStream,是FliterinputStream（装饰字节输入）类的子类
			bis = new BufferedInputStream(fis);
//			byte.mark();
			byte[] buffer = new byte[1024];
			int bytenum = 0;
			while((bytenum = bis.read(buffer, 0, buffer.length))!=-1){
				output.write(buffer,0,bytenum);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fis.close();
			bis.close();
			output.close();
		}
		return output.toByteArray();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("F:/XML.txt");
//		获得输出的字节数组
		try {
//			byte[] bu = readFileByFileInputStream(file);
////			将字节数组转换成字符串,方法1,直接利用字节数组初始化字符串变量
//			String out = new String(bu);
////			将字节数组转换成字符串，方法2
//			out = String.copyValueOf(out.toCharArray(), 0,bu.length);
//			System.out.println(out);
//			for(int i =0;i<bu.length;i++){
//				System.out.println((char)bu[i]);
//			}
			readFileByFileInputStream(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		
//		String in = "Hello";
//		byte[] bt = in.getBytes();
//		ByteArrayInputStream bis = new ByteArrayInputStream(bt);
//		for(int i=0;i<2;i++){
//			int c;
////			read（）方法：从此输入流中读取下一个数据字节。返回一个 0 到 255 范围内的 int 字节值，也就是返回的是字节值。如果因为到达流末尾而没有可用的字节，则返回值 -1。
//			while((c=bis.read())!=-1){
//				if(i==0){
//					System.out.print((char)c);
//                }
//                else
//                {
//                    System.out.print(Character.toUpperCase((char)c));
//                }
//			}
////			reset方法将重置字节数组输入流，从而可以重新使用这个输入流。
//			bis.reset();
//		}
	}

}
