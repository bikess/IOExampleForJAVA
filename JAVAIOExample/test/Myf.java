package test;

public class Myf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int f[]= new int[10];
		f[0]=f[1]=1;
		for(i=2;i<f.length;i++)
			f[i] = f[i-1]+f[i-2];
		for(i=1;i<f.length;i++)
			System.out.println("F["+i+"]="+f[i-1]);
	}

}
