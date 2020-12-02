package id.ac.its.izzulhaq023;

public class Circle extends Shape2D {

	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(double radius) {
		if(radius < 0.0) {
			this.radius = 0.0;
		}
		else {
			this.radius = radius;
		}
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		if(radius < 0.0) {
			this.radius = 0.0;
		}
		else {
			this.radius = radius;
		}
	}
	
	public double getArea() {
		return Math.PI * getRadius() * getRadius();
	}
	
	public double getCircumference() {
		return 2 * Math.PI * getRadius();
	}
}
