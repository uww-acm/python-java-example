from math import sqrt, pi 

class Point:
	def __init__(self, x, y):
		self.x = float(x)
		self.y = float(y)
	
	def __str__(self):
		return "(" + str(self.x) + ", " + str(self.y) + ")"
	
	def distance(self, p1, p2):
		if isinstance(p1, Point) and isinstance(p2, Point):
			return sqrt((p2.x-p1.x)**2+(p2.y-p1.y)**2)
			
class Rectangle:
	def __init__(self, point, w, h):
		self.upperLeft = point
		self.width = abs(w)
		self.height = abs(h)
			
	def __str__(self):
		return "[" + str(self.upperLeft) + "; w: " + str(self.width) + "; h: " + str(self.height) + "]"
		
	def area(self):
		return self.width*self.height
		
	def perimeter(self):
		return 2*self.height+2*self.width
		
	def isSquare(self):
		return (self.width == self.height)
		
	def contains(self, p):
		if isinstance(p, Point):
			return (p.x > self.upperLeft.x and p.x < self.upperLeft.x+self.width and p.y < self.upperLeft.y and p.y > self.upperLeft.y-self.height)
		else:
			return False 
	
class Circle:
	def __init__(self, p, r):
		self.center = p
		self.radius = abs(r)

	def __str__(self):
		return "[" + str(self.center) + "; r: " + str(self.radius) + "]"
		
	def area(self):
		return pi*self.radius**2
		
	def circumference(self):
		return 2*pi*self.radius
		
	def contains(self, p):
		if isinstance(p, Point):
			return (Point.distance(self.center, p) <= self.radius)
		else:
			return False
			
moreInput = "y"

while moreInput == "y" or moreInput == "Y":
	pointX = float(input("Enter the x coordinate for the point: "))
	pointY = float(input("Enter the y coordinate for the point: "))
	point = Point(pointX, pointY)
	print(point)
	shape = input("Enter a c to create a circle or an r to create a rectangle: ")
	if shape == "c" or shape == "C":
		c = input("Enter the coordinates for the circle's centerpoint separated by a space (x y): ").split(" ")
		r = float(input("Enter the circle's radius: "))
		circle = Circle(Point(c[0], c[1]), r)
		print(circle)
		print("The area of the circle is " + str(circle.area()))
		print("The circumference of the circle is " + str(circle.circumference()))
		if circle.contains(point):
			print("The point is within the circle")
		else:
			print("The point is not within the circle")
			
	elif shape == "r" or shape == "R":
		r = input("Enter the coordinates for the rectangle's upper-left point, separated by a space (x y): ").split(" ")
		w = float(input("Enter the width for the rectangle: "))
		h = float(input("Enter the height for the rectangle: "))
		rect = Rectangle(Point(r[0], r[1]), w, h)
		print(rect)
		print("The area of the rectangle is " + str(rect.area()))
		print("The perimeter of the rectangle is " + str(rect.area()))
		if rect.isSquare():
			print("Rectangle is square")
		else:
			print("Rectangle is not a square")
		if rect.contains(point):
			print("Point is in rectangle")
		else:
			print("Point is not in rectangle")	
		
	else:
		print("Unrecognized shape type")
		
	moreInput = input("Would you like to do more? (y/n): ")

