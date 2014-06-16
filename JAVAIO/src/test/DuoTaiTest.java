package test;

class A {  
    public String show(D obj){  
           return ("A and D");  
    }   
    public String show(A obj){  
           return ("A and A");  
    }   
}   
class B extends A{  
    public String show(B obj){  
           return ("B and B");  
    }  
    public String show(A obj){  
           return ("B and A");  
    }   
}  
class C extends B{}   
class D extends B{}  
public class DuoTaiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();  
        A a2 = new B();  
        B b = new B();  
        C c = new C();   
        D d = new D();   
        System.out.println(a1.show(b));    //A and A
        System.out.println(a1.show(c));    // A and A
        System.out.println(a1.show(d));    // A and D
        
        System.out.println(a2.show(b));    //B and A很关键！首先this=a2，a2是A，而A中没有show（B）方法，那么先去A的超类找，A没有超类，
//       那么看this.((super)B)有没有，有则绑定的是这个方法。而a2指向的是B的对象引用，因此最终调用的是 B.show（A）
        System.out.println(a2.show(c));   //同理 输出 B and A 
        
        System.out.println(a2.show(d));  // 当没有指定对象应用的时候，调用的是A.show(D),当装换成对象引用的时候，由于B中没有B.show（D）方法，也就是没有重写父类的方法，没有重写肯定调用父类的方法，转而调用
//        A.show(D)     输出为 A and D
        System.out.println(b.show(b));    //B and B
        System.out.println(b.show(c));     // b.(c)没有-》A.(c)没有-》b.(super(c))=b.(b)存在，输出B and B
        System.out.println(b.show(d));     //b.d没有-》A.d 存在，输出 A and D
	}

}
