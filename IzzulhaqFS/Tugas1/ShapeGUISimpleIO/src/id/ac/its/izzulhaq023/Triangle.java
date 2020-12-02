package id.ac.its.izzulhaq023;

public class Triangle extends Shape2D {

	private double a;
	private double b;
	private double c;
	
	public Triangle() {
		
	}
	
	public Triangle(double a, double b, double c) {
		if(a < 0.0) {
			this.a = 0.0;
		}
		else {
			this.a = a;
		}
		
		if(b < 0.0) {
			this.b = 0.0;
		}
		else {
			this.b = b;
		}
		
		if(c < 0.0) {
			this.c = 0.0;
		}
		else {
			this.c = c;
		}
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		if(a < 0.0) {
			this.a = 0.0;
		}
		else {
			this.a = a;
		}
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		if(b < 0.0) {
			this.b = 0.0;
		}
		else {
			this.b = b;
		}
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		if(c < 0.0) {
			this.c = 0.0;
		}
		else {
			this.c = c;
		}
	}
	
	public double getArea() {
		double s = getCircumference()/2;
		return Math.sqrt(s * (s - getA()) * (s - getB()) * (s - getC()));
	}
	
	public double getCircumference() {
		return getA() + getB() + getC();
	}
}
