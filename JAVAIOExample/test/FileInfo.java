package test;

import java.io.File;
import java.util.Date;

public class FileInfo {

	/**
	 * @param args
	 */
//	文件的目录
	private String filePath;
//	构造函数
	public FileInfo(String path)
	{
		this.filePath = path;
	}
//	获取当前路径下的文件的属性信息
	public void searchFiles(){
		File fileDirectory = new File(filePath);
		for(File file: fileDirectory.listFiles()){
			System.out.println("显示文件名:"+file.getName());
			System.out.println("显示文件的决定路径:"+file.getAbsolutePath());
			System.out.println("修改日期:"+new Date(file.lastModified()));
			System.out.println("文件的大小:"+file.length()+"B");
			System.out.println("是否为文件:"+file.isFile());
			System.out.println("是否为隐藏文件:"+file.isHidden());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		定义文件路径
		String path = "E:/temp";
		FileInfo myfile = new FileInfo(path);
//		显示文件属性信息
		myfile.searchFiles();
	}

}
