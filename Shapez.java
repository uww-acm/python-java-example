import java.util.Scanner;
import java.lang.Math;

public class Shapez{
	public static void main(String[] args){
		
	}
	
}

class Point{
	double x, y;
	
	public Point(){
		x = 0; y = 0;
	}
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
	static double distance(Point p1, Point p2){
		return Math.sqrt(Math.pow(p2.x-p1.x, 2)+Math.pow(p2.y-p1.y, 2));
	}
	
	
}

class Rectangle{
	Point upperLeft;
	double width, height;
	
	public Rectangle(){
		upperLeft = new Point();
		width = height = 0;
	}
	
	public Rectangle(Point upperLeft, double width, double height){
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	double area(){
		return width*height;
	}
	
	double perimeter(){
		return 2*width+2*height;
	}
	
	public String toString(){
		
		
		return null;
	}
	
	boolean isSquare(){
		return (width == height);
	}
	
	boolean contains(Point p){
		return (p.x > upperLeft.x && p.x < upperLeft.x+width && p.y > upperLeft.y && p.y < upperLeft.y+height);
	}
}

class Circle{
	Point center;
	double radius;
	
	public Circle(){
		center = new Point(0, 0);
		radius = 0;
	}
	
	public Circle(Point center, double radius){
		this.center = center;
		this.radius = radius;
	}
	
	double area(){
		return Math.PI*radius*radius;
	}
	
	double circumference(){
		return 2*Math.PI*radius;
	}
	
	boolean contains(Point p){
		return (center.distance(p) <= radius);
	}
}
