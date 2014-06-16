package comparatorexample;

// 定义Person类
public class Person {
	String firstname,lastname;
	Boolean sex;
	int age;
	public Person(String firstname,String lastname, Boolean sex, int age){
		this.firstname =firstname;
		this.lastname = lastname;
		this.sex = sex;
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	为了输入方便，重写toString()方法
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		男 表示true
		return firstname+" "+lastname+" "+(sex.booleanValue()?"男":"女")+" "+age;
	}
	
}
