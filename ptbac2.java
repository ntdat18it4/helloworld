package main;
import static java.lang.Math.*;
import java.util.Scanner;
public class ptbac2 {

	public static void main(String[] args) {
		double a,b,c,delta;
		Scanner input = new Scanner(System.in);
		System.out.println("nhap vao a=");
		a=input.nextDouble();
		System.out.println("nhap vao b=");
		b=input.nextDouble();
		System.out.println("nhap vao c");
		c= input.nextDouble();
		delta = b*b-4*a*c;
		if (delta<0) {
		System.out.println("phuong trinh vo nghiem");
		} else if(delta==0){
		System.out.println("phuong trinh co nghiem kep");
		System.out.println("x= " +(-b/(2*a)));
		}
		else{
			System.out.println("phuong trinh co hai nghiem phan biet");
			System.out.println("x1=" + (-b+sqrt(delta))/(2*a));
			System.out.println("x2=" +(-b-sqrt(delta))/(2*a));
			}
		}
	}


