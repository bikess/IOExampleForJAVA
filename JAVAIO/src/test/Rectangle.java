package test;

import java.io.InputStream;
import java.util.Scanner;

public class Rectangle {

	/**
	 * @param args
	 */
//	定义矩形的长
	private double length;
//	定义矩形的宽
	private double width;
//	构造函数，为矩形的长与宽赋值
	public Rectangle(double x, double y){
		this.length = x;
		this.width = y;
	}
public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	//	返回矩形的面积
	public double getArea(){
		return length*width;
	}
//	返回矩形的周长
	public double getCirde(){
		return 2*(length+width);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入矩形的长与宽：");
//		键盘输入矩形的长与宽
		Scanner in = new Scanner(System.in);
		double length = in.nextDouble();
		double width = in.nextDouble();
		System.out.println(ObjectSizeFetcher.getObjectSize(new Rectangle()));
		Rectangle my = new Rectangle(length, width);
//		输出面积
//		System.out.println(my.getArea());
//		输出周长
//		System.out.println(my.getCirde());
	}

}
