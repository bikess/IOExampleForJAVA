package test;

import java.util.HashMap;
import java.util.Map;

public class ShaiZi {

	/**
	 * 6个面的骰子 标上1 2 3 4 5 6 投掷8次, 出现哪个结果的概率最大
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = new int[6];
		for(int i =0;i<6;i++){
			num[i] = i+1;
		}
		Map<Integer,Integer> hashmap = new HashMap<>();
		
		getResult(hashmap,0,0,num);
		System.out.println(hashmap.toString());
	}

	private static void getResult(Map<Integer, Integer> hashmap, int midResult, int depth,
			int[] num) {
		// TODO Auto-generated method stub
		if(depth==8){
			if(hashmap.containsKey(midResult)){
				hashmap.put(midResult, hashmap.get(midResult)+1);
			}else{
				hashmap.put(midResult, 1);
			}
			return;
		}
		for(int i = 0;i<num.length;i++){
			int ret = midResult + num[i];
			getResult(hashmap, ret, depth+1, num);
			
		}
	}

}
