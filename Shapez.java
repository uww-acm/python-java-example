import java.util.Scanner;
import java.lang.Math;

public class Shapez{
	public static void main(String[] args){ //should use Scanner, File I/O, while/for loops "
		String moreInput = "y";
		Scanner s = new Scanner(System.in);
		String shape = "";
		Point point;
		Circle circle;
		Rectangle rect;
		
		while(moreInput != null && moreInput.equalsIgnoreCase("y")){
			System.out.print("Enter the x coordinate for the point: ");
			double pointX = s.nextDouble(); s.nextLine();
			System.out.print("Enter the y coordinate for the point: ");
			double pointY = s.nextDouble(); s.nextLine();
			point = new Point(pointX, pointY);
			System.out.print("Enter a C to create a circle or an R to create a rectangle: ");
			shape = s.nextLine();
			if(shape.equalsIgnoreCase("c")){
				System.out.print("Enter the coordinates for the circle's centerpoint, separated by a space (x y): ");
				double cX = s.nextDouble();
				double cY = s.nextDouble();
				s.nextLine();
				System.out.print("Enter the circle's radius: ");
				double cR = s.nextDouble(); s.nextLine();
				circle = new Circle(new Point(cX, cY), cR);
				
				System.out.println("The area of the circle is " + circle.area());
				System.out.println("The circumference of the circle is " + circle.circumference());
				
				if(circle.contains(point))
					System.out.println("The point is within the circle");
				else
					System.out.println("The point is not in the circlce");
			}
			else if(shape.equalsIgnoreCase("r")){
				System.out.println("Enter the coordinates for the rectangle's upper-left corner, separated by a space (x y): ");
				double ulX = s.nextDouble();
				double ulY = s.nextDouble();
				s.nextLine();
				System.out.print("Enter the width of the rectangle: ");
				double w = s.nextDouble(); s.nextLine();
				System.out.print("Enter the height of the rectangle: ");
				double h = s.nextDouble(); s.nextLine();
				rect = new Rectangle(new Point(ulX, ulY), w, h);
				
				System.out.println("The area of the rectangle is " + rect.area());
				System.out.println("The perimeter of the rectangle is " + rect.perimeter());
				
				if(rect.isSquare())
					System.out.println("The rectangle is a square.");
				else
					System.out.println("The rectangle is not a square.");
				
				if(rect.contains(point))
					System.out.println("The point is within the rectangle.");
				else
					System.out.println("The point is not within the rectangle.");
			}
			else{
				System.out.println("Error: unrecognized shape type.");
			}
			
			System.out.print("Would you like to create a new shape? (y/n): ");
			moreInput = s.nextLine();
		}
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
	private double width, height;
	
	public Rectangle(){
		upperLeft = new Point();
		width = height = 0;
	}
	
	public Rectangle(Point upperLeft, double width, double height){
		this.upperLeft = upperLeft;
		this.width = Math.abs(width);
		this.height = Math.abs(height);
	}
	
	void setWidth(double width){
		this.width = Math.abs(width);
	}
	
	double getWidth(){
		return width;
	}
	
	void setHeight(double height){
		this.height = Math.abs(height);
	}
	
	double getHeight(){
		return height;
	}
	
	double area(){
		return width*height;
	}
	
	double perimeter(){
		return 2*width+2*height;
	}
	
	public String toString(){
		return "[" + upperLeft + "; w: " + width + "; h: " + height + "]";
	}
	
	boolean isSquare(){
		return (width == height);
	}
	
	boolean contains(Point p){
		return (p.x > upperLeft.x && p.x < upperLeft.x+width && p.y < upperLeft.y && p.y > upperLeft.y-height);
	}
}

class Circle{
	Point center;
	private double radius;
	
	public Circle(){
		center = new Point(0, 0);
		radius = 0;
	}
	
	public Circle(Point center, double radius){
		this.center = center;
		this.radius = Math.abs(radius);
	}
	
	void setRadius(double radius){
		this.radius = Math.abs(radius);
	}
	
	double getRadius(){
		return radius;
	}
	
	double area(){
		return Math.PI*radius*radius;
	}
	
	double circumference(){
		return 2*Math.PI*radius;
	}
	
	boolean contains(Point p){
		return (Point.distance(center, p) <= radius);
	}
	
	public String toString(){
		return "[" + center + "; r: " + radius + "]";
	}
}
