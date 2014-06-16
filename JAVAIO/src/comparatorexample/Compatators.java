package comparatorexample;


// 自定义要实现的比较器
public class Compatators {
//	定义返回值为java比较器的静态方法
	public static java.util.Comparator getComparator(){
		return new java.util.Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				//o1 is a objection of class String
				if(o1 instanceof String){
					return compare((String)o1,(String)o2);
				}else if(o1 instanceof Integer){
					return compare((Integer)o1,(Integer)o2);
				}else if(o1 instanceof Person){
					return compare( (Person) o1, (Person) o2);
				}else
				{  
					System.err.println("未找到合适的比较器");  
					return 1;  
			    } 
			}
//			 这是两个String类型的对象的比较器
			public int compare(String o1,String o2){
				String s1 = (String)o1;
				String s2 = (String)o2;
				int len1 = s1.length();
				int len2 = s2.length();
				int n =Math.min(len1, len2);
				char v1[]=s1.toCharArray();
				char v2[]=s2.toCharArray();
				int pos = 0;
				while(n--!=0){
					char c1 = v1[pos];
					char c2 = v2[pos];
//					这是按照从小到大排列的，若改为c2-c1则变为从大到小
					if(c1!=c2){
						return c1-c2;
					}
					pos++;
				}
				return len1-len2;
			}
			
			public int compare(Integer o1, Integer o2) {  
		        int val1 = o1.intValue();  
		        int val2 = o2.intValue(); 
//		        这是按照从小到大排列，下面这句话的意思，写成 if结构如下面所示
		        return (val1 < val2 ? -1 : (val1 == val2 ? 0 : 1));  
////		       也可以这种表示方法，当val1<val2 返回-1，表示从小到大排列，val2>val1,表示从大到小排列
//		        if(val1<val2){
//		        	return -1;
//		        }else if(val1==val2){
//		        	return 0;}
//		        else{
//		        	return 1;
//		        }
		      }  
		      public int compare(Boolean o1, Boolean o2) {  
		  
//		         return (o1.equals(o2)? 0 : (o1.booleanValue()==true?1:-1));  
//		         用if结构表示,对于boolean类型的排序，当o1为true时候返回1，表示优先返回的是false值，然后返回true值
		         if(o1.equals(o2)){
		        	 return 0;
		         }else if(o1.booleanValue()==true){
		        	 return 1;
		         }else{
		        	 return -1;
		         }
		       }  
		  
		      public int compare(Person o1, Person o2) {  
		        String firstname1 = o1.getFirstname();  
		        String firstname2 = o2.getFirstname();  
		        String lastname1 = o1.getFirstname();  
		        String lastname2 = o2.getFirstname();  
		        Boolean sex1 = o1.getSex();  
		        Boolean sex2 = o2.getSex();  
		        Integer age1 = o1.getAge();  
		        Integer age2 = o2.getAge();  
//		        这是优先比较firstname，然后依次比较，===0表示按此字段比较两个值是相同的
		        return (compare(firstname1, firstname2) == 0 ?  
		             (compare(lastname1, lastname2) == 0 ? (compare(sex1, sex2) == 0 ? (compare(age1, age2) == 0 ? 0 :  
		              compare(age1, age2)) :  
		              compare(sex1, sex2)) :  
		              compare(lastname1, lastname2)) :  
		              compare(firstname1, firstname2));  
		
		      }  
		  
			
		};
	}
}
