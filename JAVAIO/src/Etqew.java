
public class Etqew {

	/**
	 * @param args
	 */
	static int f(int x)
	{
	int s = 0;
	while(x>0)
	{	
		s+=f(x);
		x--;
	}
	return Math.max(s, 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(f(35));
	}

}
