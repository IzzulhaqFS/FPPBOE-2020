package id.ac.its.izzulhaq023;

public class Rectangle extends Shape2D {

	private double height;
	private double width;
	
	public Rectangle() {
		
	}
	
	public Rectangle(double height, double width) {
		if(height < 0.0) {
			this.height = 0.0;
		}
		else {
			this.height = height;
		}
		
		if(width < 0.0) {
			this.width = 0.0;
		}
		else {
			this.width = width;
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if(height < 0.0) {
			this.height = 0.0;
		}
		else {
			this.height = height;
		}
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if(width < 0.0) {
			this.width = 0.0;
		}
		else {
			this.width = width;
		}
	}
	
	public double getArea() {
		return getHeight() * getWidth();
	}
	
	public double getCircumference() {
		return 2 * (getHeight() + getWidth());
	}
}
