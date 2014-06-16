package inputoutstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutStreamExample {

	/**
	 * @param args
	 */
//	使用FileOutputStream复制文件
	public static void copyFileByFileOutputStream(File file) throws IOException
	{
	    FileInputStream fis = null;
	    FileOutputStream fos = null;
	    try
	    {
	        fis = new FileInputStream(file);
	        fos = new FileOutputStream(file.getName() + ".bak");
	        byte[] buffer = new byte[1024];
	        int bytesRead = 0;
	        while((bytesRead = fis.read(buffer,0,buffer.length)) != -1)
	        {
	            fos.write(buffer, 0, bytesRead);
	        }
	        fos.flush();
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error occurs during copying " + file.getAbsoluteFile());
	    }
	    finally
	    {
	        if (fis != null) fis.close();
	        if (fos != null) fos.close();
	    }
	}
//	使用BufferedOutputStream复制文件，FileOutputStream是outputStream的子类，
	public static void copyFilebyBufferedOutputStream(File file) throws Exception{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream(file.getName()+".bak");
//			BufferedOutputStream带缓冲的字节输出流类
			bos = new BufferedOutputStream(fos);
			byte[] buffer = new byte[1024];
			int bytenum = 0;
			while((bytenum = bis.read(buffer, 0, buffer.length))!=-1)
			{
//				将指定 byte 数组buffer中从偏移量 0 开始的 len 个字节写入此缓冲的输出流。
				bos.write(buffer, 0, bytenum);
			}
//			刷新此缓冲的输出流。这迫使所有缓冲的输出字节被写出到底层输出流中,不要从缓冲区丢失
			bos.flush();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			bis.close();
			fis.close();
			bos.close();
			fos.close();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
