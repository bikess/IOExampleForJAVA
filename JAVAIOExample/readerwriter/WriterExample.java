package readerwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriterExample {

	/**
	 * @param args
	 */
	public static void copyFile(String file) throws IOException{
		BufferedReader br = null;
		BufferedWriter bw = null;
		try{
			br = new BufferedReader(new FileReader(file));
			bw = new BufferedWriter(new FileWriter(file+".bak"));
			String line = null;
			while((line = br.readLine())!=null){
				bw.write(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			br.close();bw.close();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
