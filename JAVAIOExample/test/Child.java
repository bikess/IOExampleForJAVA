package test;
/***
 *  注意子类与父类的类变量、实例变量与类方法、实例方法之间的覆盖与隐藏的关系
 * @author bike
 *
 */
  public class Child extends Parent{ 
          int x=9; 
          void add(int y){ 
               x+=y; 
          } 
          public static void main(String[] args){ 
               Parent p=new Child(); 
               System.out.println(((Child)p).x); 
          }   
     }
